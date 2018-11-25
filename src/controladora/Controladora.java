package controladora;

import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controladora extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader f = new FXMLLoader();
		FileInputStream file = new FileInputStream(new File("views/fxml/ViewPrincipal.fxml"));
		Pane pane = f.load(file);
		Scene scene = new Scene(pane, 285, 200);
//		scene.getStylesheets().add(new FileInputStream(new File("views/css/application.css")));
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
