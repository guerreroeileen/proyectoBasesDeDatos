package vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ViewRegistrarSolicitud {

	private Pane paneContenido;

	@FXML
	private VBox vBoxPanel;

	@FXML
	private ChoiceBox<?> chbTipoSolicitud;

	@FXML
	private ImageView imgBanner;

	@FXML
	private Button bRegistrar;

	/**
	 * Tambien inicializa el banner en con la imagen views/imagenes/banner.jpg
	 * @param paneContenido panel root de la vista
	 */
	
	public void inicializar(Pane paneContenido) {
		this.paneContenido = paneContenido;
		modificarBanner("views/imagenes/banner.jpg");
	}

	public Pane obtenerPaneContenido() {
		return paneContenido;
	}

	public Pane obtenerVBoxPane() {
		return vBoxPanel;
	}

	public Button obtenerBotonRegistrar() {
		return bRegistrar;
	}

	public void modificarBanner(String rutaImagen) {
		FileInputStream streamImagen;
		try {
			streamImagen = new FileInputStream(rutaImagen);
			imgBanner.setImage(new Image(streamImagen, imgBanner.getFitWidth(), imgBanner.getFitHeight(), false, false));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
