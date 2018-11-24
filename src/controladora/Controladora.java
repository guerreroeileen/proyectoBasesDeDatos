package controladora;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controladora extends Application{

	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader f = new FXMLLoader();
		
		FileInputStream file = new FileInputStream(new File(""));
		Pane pane = f.load(file);
		
		//INICIALIZAR PRINCIPAL
		
	}
	
	

	
}
