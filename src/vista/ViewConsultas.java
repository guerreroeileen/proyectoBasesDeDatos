package vista;

import java.awt.Choice;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ViewConsultas {

    @FXML
    private ScrollPane scrollConsultas;

    @FXML
    private Label labCsltaSolicXFunc;

    @FXML
    private Button butCsltaSolicXFunc;

    @FXML
    private TextField txtCedulaFuncionario;

    @FXML
    private Label labCsltaSolicXEstado;

    @FXML
    private Label labCsltaSolicXTipo;

    @FXML
    private TextField txtCedulaCliente;

    @FXML
    private Button butCsltaSolicXEstado;

    @FXML
    private Button butCsltaSolicXTipo;

    @FXML
    private Button butCsltaSolicXCliente;

    @FXML
    private Label labCsltaProdXCliente;

    @FXML
    private ChoiceBox<String> cmbBoxEstadoSol;

    @FXML
    private ChoiceBox<String> cmbBoxTipoSol;
    
    @FXML
    private TextArea txtResultConsulta;

	public TextArea getTxtResultConsulta() {
		return txtResultConsulta;
	}

	public void setTxtResultConsulta(TextArea txtResultConsulta) {
		this.txtResultConsulta = txtResultConsulta;
	}

	public TextField getTxtCedulaFuncionario() {
		return txtCedulaFuncionario;
	}

	public void setTxtCedulaFuncionario(TextField txtCedulaFuncionario) {
		this.txtCedulaFuncionario = txtCedulaFuncionario;
	}

	public TextField getTxtCedulaCliente() {
		return txtCedulaCliente;
	}

	public void setTxtCedulaCliente(TextField txtCedulaCliente) {
		this.txtCedulaCliente = txtCedulaCliente;
	}

	public ChoiceBox<String> getCmbBoxEstadoSol() {
		return cmbBoxEstadoSol;
	}

	public void setCmbBoxEstadoSol(ChoiceBox<String> cmbBoxEstadoSol) {
		this.cmbBoxEstadoSol = cmbBoxEstadoSol;
	}

	public ChoiceBox<String> getCmbBoxTipoSol() {
		return cmbBoxTipoSol;
	}

	public void setCmbBoxTipoSol(ChoiceBox<String> cmbBoxTipoSol) {
		this.cmbBoxTipoSol = cmbBoxTipoSol;
	}

	public Button getButCsltaSolicXFunc() {
		return butCsltaSolicXFunc;
	}

	public Button getButCsltaSolicXEstado() {
		return butCsltaSolicXEstado;
	}

	public Button getButCsltaSolicXTipo() {
		return butCsltaSolicXTipo;
	}

	public Button getButCsltaSolicXCliente() {
		return butCsltaSolicXCliente;
	}
    
    

}
