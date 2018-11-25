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
import vista.ViewInicioSesion;

public class Controladora extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Inicializar ventana inicio sesion

		inicializarInicioSesion(primaryStage);

		// INICIALIZAR PRINCIPAL

	}

	private void inicializarInicioSesion(Stage primaryStage) {
		FXMLLoader loader = null;
		File fxmlView = new File("./views/fxml/ViewInicioSesion.fxml");
		try {
			FileInputStream inputFxml = new FileInputStream(fxmlView);
			loader = new FXMLLoader();
			Pane contentPane = loader.load(inputFxml);
			ViewInicioSesion viewSesion = loader.getController();
			viewSesion.modificarPanelContenido(contentPane);
			primaryStage.setScene(new Scene(contentPane));
			esperarSesion(viewSesion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void esperarSesion(ViewInicioSesion viewSesion) {
		Button[] botones = viewSesion.obtenerBotones();
		EventHandler<MouseEvent> gestorDeEventos = obtenerViewSesionListener();

		botones[0].setOnMouseClicked(gestorDeEventos);
	}

	private EventHandler<MouseEvent> obtenerViewSesionListener() {
		EventHandler<MouseEvent> gestorDeEventos = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				Button boton =(Button)event.getSource();
				String botonStr = boton.getText();
				
				if(botonStr.equalsIgnoreCase("ingresar")) {
					
				}else if(botonStr.equalsIgnoreCase("salir")) {
					
				}
				
			}
		};
		return gestorDeEventos;
	}

}
