package vista;

import java.util.HashMap;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ViewAsignarSolicitud {

    @FXML
    private Label labCodSolicitud;

    @FXML
    private Label labCedulaFuncionario;

    @FXML
    private TextField txtCodSolicitud;

    @FXML
    private TextField txtCedulaFuncionario;

    @FXML
    private Button butAsignarSolicitud;

	public TextField getTxtCodSolicitud() {
		return txtCodSolicitud;
	}

	public void setTxtCodSolicitud(TextField txtCodSolicitud) {
		this.txtCodSolicitud = txtCodSolicitud;
	}

	public TextField getTxtCedulaFuncionario() {
		return txtCedulaFuncionario;
	}

	public void setTxtCedulaFuncionario(TextField txtCedulaFuncionario) {
		this.txtCedulaFuncionario = txtCedulaFuncionario;
	}

	public Button getButAsignarSolicitud() {
		return butAsignarSolicitud;
	}
    
    

}

