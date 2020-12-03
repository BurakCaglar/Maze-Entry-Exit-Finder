package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.event.ActionEvent;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class mazeController {
	@FXML
	private Button b1;
	@FXML
	private Button b2;
	@FXML
	private Button b3;
	@FXML
	private Canvas c1;
	@FXML
	private TextField t1;
	@FXML
	private TextField t2;
	@FXML
	private TextField t3;
	@FXML
	private TextField t4;

	// Event Listener on Button[#b1].onAction
	@FXML
	public void dosya(ActionEvent event) throws FileNotFoundException {
		String string = "";
		String E = "E";
		String S = "S";
		int numOfE = 0;
		int numOfS = 0;
		int sutunSayisi= 0;
		int colunmOfE = 0;
		int colunmOfS = 0;
		
		
		FileChooser chooser = new FileChooser();
	    chooser.setTitle("Dosyayi sec");
	    File file = chooser.showOpenDialog(new Stage());
	    Scanner scan = new Scanner(file);
	    
		List<String> arrayLine = new ArrayList<String>();

	    // while loop
	    while (scan.hasNextLine()) {
	      sutunSayisi++;
	      string = scan.nextLine();
	      System.out.println(string);
	      if(string.contains(E)) {
	    	  numOfE = string.indexOf(E);
	    	  colunmOfE = sutunSayisi;
	      } else if (string.contains(S)) {
	    	  numOfS = string.indexOf(S);
	    	  colunmOfS = sutunSayisi;
	      }
	      
	      arrayLine.add(string);
	      
	    }
	    scan.close();
	    
	    
	    String[] tempsArray = arrayLine.toArray(new String[0]);
	    
	    
	    
		t1.setText("Satýr Sayýsý: " + tempsArray.length);
		t2.setText("Sutun Sayýsý: " + tempsArray[1].length());
		t3.setText("Giris: " + colunmOfS + ". satir " + (numOfS+1) + ". sutun");
		t4.setText("Cikis: "+ + colunmOfE + ". satir " + (numOfE+1) + ". sutun ");
		
		double multipleWidth = 588.0 / (tempsArray[1].length());
		double multipleHeight = 288.0 / (tempsArray.length);
		
		double multipleNumOfSH = 588.0 / (numOfS+1);
		double multipleNumOfSW = 288.0 / (colunmOfS+1);
		
		
		GraphicsContext canvas = c1.getGraphicsContext2D();
		
		
		canvas.strokeRect(0, 0, (tempsArray[1].length())*multipleWidth, (tempsArray.length)*multipleHeight) ;
		
		canvas.setFill(Color.GREEN);
		canvas.fillOval(numOfS*multipleNumOfSH, colunmOfS*multipleNumOfSW, 10, 10);
		canvas.setFill(Color.RED);
		canvas.fillOval(numOfE*multipleHeight, colunmOfE*multipleWidth, 10, 10);
		
		


  
	}
	// Event Listener on Button[#b2].onAction
	@FXML
	public void temizle(ActionEvent event) {
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
	}
	// Event Listener on Button[#b3].onAction
	@FXML
	public void kapat(ActionEvent event) {
		System.exit(0);
	}
}
