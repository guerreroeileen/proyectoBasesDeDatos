package vista;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


public class ViewInicioSesion {

	private Pane contenido;
	
    @FXML
    private TextField tfCedula;

    @FXML
    private Button bIngresar;
    
    @FXML
    private Button bSalir;
    
    public ViewInicioSesion() {
    	
    	
    }

	public void modificarPanelContenido(Pane contenido) {
		this.contenido=contenido;
	}

	public Button[] obtenerBotones() {
		Button[] botones = new Button[2];
		botones[0]=bIngresar;
		botones[1]=bSalir;
		return botones;
	}
}
