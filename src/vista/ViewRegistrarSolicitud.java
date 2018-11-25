package vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;

import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ViewRegistrarSolicitud {

	private Pane paneContenido;

	@FXML
	private VBox vbPanel;

	@FXML
	private Pane vbSolicitudPanel;

	@FXML
	private ChoiceBox<String> chbTipoSolicitud;

	@FXML
	private ImageView imgBanner;

	@FXML
	private Button bRegistrar;

	private HashMap<String, Node> nodos;

	/**
	 * Tambien inicializa el banner en con la imagen views/imagenes/banner.jpg
	 * y una Hash ID-Nodo para guardar los componentes de la vista de solicitud actual
	 * @param paneContenido panel root de la vista
	 */

	public void inicializar(Pane paneContenido) {
		this.paneContenido = paneContenido;
		nodos=new HashMap<>();
		modificarBanner("views/imagenes/banner.jpg");
	}

	public Pane obtenerPaneContenido() {
		return paneContenido;
	}

	public VBox obtenerVBoxPane() {
		return vbPanel;
	}

	public Button obtenerBotonRegistrar() {
		return bRegistrar;
	}

	public ChoiceBox<String> obtenerChoiceBox() {
		return chbTipoSolicitud;
	}

	public void modificarBanner(String rutaImagen) {
		FileInputStream streamImagen;
		try {
			streamImagen = new FileInputStream(rutaImagen);
			imgBanner
					.setImage(new Image(streamImagen, imgBanner.getFitWidth(), imgBanner.getFitHeight(), false, false));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void agregarEnVBox(Pane pane) {
		this.vbSolicitudPanel = pane;

		if (vbSolicitudPanel != null) {
			this.nodos=new HashMap<>();
			for (Node node : vbSolicitudPanel.getChildren()) {
				this.nodos.put(node.getId(), node);
			}
			vbPanel.getChildren().set(0, vbSolicitudPanel);
		}

	}

	public Node obtenerNodo(String id) {
		return nodos.get(id);
	}

	public Collection<Node> obtenerNodos() {
		return nodos.values();
		
	}

}
