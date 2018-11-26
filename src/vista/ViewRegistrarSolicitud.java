package vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;

import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewRegistrarSolicitud {

	private Pane paneContenido;

	private Stage stage;

	@FXML
	private VBox vbPanel;

	@FXML
	private Pane vbSolicitudPanel;

	@FXML
	private ChoiceBox<Eleccion> chbTipoSolicitud;

	@FXML
	private ImageView imgBanner;

	@FXML
	private Button bRegistrar;

	private HashMap<String, Node> nodos;

	/**
	 * Tambien inicializa el banner en con la imagen views/imagenes/banner.jpg y una
	 * Hash ID-Nodo para guardar los componentes de la vista de solicitud actual
	 * 
	 * @param paneContenido panel root de la vista
	 */

	public void inicializar(String name, Pane paneContenido) {

		this.paneContenido = paneContenido;
		stage = new Stage();
		stage.setScene(new Scene(paneContenido));
		stage.setTitle(name);
		stage.setResizable(false);
		nodos = new HashMap<>();
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

	public ChoiceBox<Eleccion> obtenerChoiceBox() {
		return chbTipoSolicitud;
	}
	
	public void agregarEleccion(String nombre, String comando) {
		Eleccion eleccion = new Eleccion(nombre, comando);
		chbTipoSolicitud.getItems().add(eleccion);
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
			this.nodos = new HashMap<>();
			for (Node node : vbSolicitudPanel.getChildren()) {
				this.nodos.put(node.getId(), node);
			}
			vbPanel.getChildren().set(0, vbSolicitudPanel);
		}

	}

	/**
	 * Retorna un nodo de la vista que posea el id correspondiente.
	 * 
	 * @param id El id del nodo, se refiere a los ids asignados en el archivo .fxml
	 * @return nodo, Nodo de la vista, generalmente de tipo button, hyperlink o
	 *         choicebox
	 */
	public Node obtenerNodoPorId(String id) {
		return nodos.get(id);
	}

	public Collection<Node> obtenerNodos() {
		return nodos.values();

	}

	public Stage getStage() {
		return stage;
	}

	/**
	 * Clase usadar para ChoiceBox cuenta como una elección que tiene un nombre, con
	 * el que se muestra en la vista y un comando, que reprenta la eleccion
	 * 
	 * @author mgltorsa
	 *
	 */
	public class Eleccion {
		private String nombre;
		private String comando;

		public Eleccion(String nombre, String comando) {
			this.nombre = nombre;
			this.comando = comando;
		}

		public String obtenerComando() {
			return comando;
		}

		public String obtenerNombre() {
			return nombre;
		}

		@Override
		public String toString() {
			return nombre;
		}
	}

}
