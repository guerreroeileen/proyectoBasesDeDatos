package vista;


import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ViewAtenderSolicitud {

	private Stage stage;
	
	private Pane paneContenido;
	
	@FXML
    private TextField tfCedula;

    @FXML
    private TextField tfCodSolicitud;

    @FXML
    private TextArea taObservaciones;

    @FXML
    private Button bAtender;

    @FXML
    private RadioButton rbAtendiendo;

    @FXML
    private Button bRechazar;

	public void inicializar(String title, Pane pane) {
		paneContenido=pane;
		stage = new Stage();
		Scene scene = new Scene(paneContenido);
		stage.setScene(scene);
		stage.setTitle(title);
		
	}

	public Stage getStage() {
		return stage;
	}

	public RadioButton getRadioButtonAtendiendo() {
		return rbAtendiendo;
	}

	public Button getRechazar() {
		return bRechazar;
	}
	
	public TextField getTextFieldCedula() {
		return tfCedula;
	}
	
	public TextField geTextFieldCodigo() {
		return tfCodSolicitud;
	}

	public Button getAtender() {
		return bAtender;
	}

	public TextArea getTextAreaObservaciones() {
		return taObservaciones;
	}
}
