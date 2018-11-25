package controladora;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controladora extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader f = new FXMLLoader();
		FileInputStream file = new FileInputStream(new File("views/fxml/ViewConsultas.fxml"));
		Pane pane = f.load(file);
		Scene scene = new Scene(pane,520,400);
//		scene.getStylesheets().add(new FileInputStream(new File("views/css/application.css")));
		primaryStage.setScene(scene);
		primaryStage.show();
		//INICIALIZAR PRINCIPAL
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
}
