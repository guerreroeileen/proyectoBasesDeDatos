package controladora;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vista.ViewConsultas;
import vista.ViewGestionarDatos;
import vista.ViewOpcionesFuncionario;
import vista.ViewPrincipal;
import vista.ViewRegistrarSolicitud;
import vista.ViewRegistrarSolicitud.Eleccion;

public class Controladora extends Application {

	private ViewGestionarDatos viewGestionarDatos;
	private ViewPrincipal viewPrincipal;
	private ViewOpcionesFuncionario viewOpcionesFuncionario;
	private ViewConsultas viewConsultas;
	private ViewRegistrarSolicitud viewRegistrarSolicitud;

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader f = new FXMLLoader();
		FileInputStream file = new FileInputStream(new File("views/fxml/ViewPrincipal.fxml"));
		Pane pane = f.load(file);
		Scene scene = new Scene(pane, 285, 200);
//		scene.getStylesheets().add(new FileInputStream(new File("views/css/application.css")));
		primaryStage.setScene(scene);
		primaryStage.show();
		viewPrincipal = (ViewPrincipal) f.getController();
		registrarEventosViewPrincipal();
	}

	@SuppressWarnings("unchecked")
	private void registrarEventosViewPrincipal() {
		viewPrincipal.getButIngresar().addEventHandler(MouseEvent.MOUSE_CLICKED, controlarEventoPrincipal());
	}

	@SuppressWarnings("unchecked")
	private void registrarEventosViewOpcionesFuncionario() {
		viewOpcionesFuncionario.getButConsultas().addEventHandler(MouseEvent.MOUSE_CLICKED,
				controlarEventosOpcionesFuncionario());
		viewOpcionesFuncionario.getButAsignarSolic().addEventHandler(MouseEvent.MOUSE_CLICKED,
				controlarEventosOpcionesFuncionario());
		viewOpcionesFuncionario.getButAtenderSolic().addEventHandler(MouseEvent.MOUSE_CLICKED,
				controlarEventosOpcionesFuncionario());
		viewOpcionesFuncionario.getButGestorDatos().addEventHandler(MouseEvent.MOUSE_CLICKED,
				controlarEventosOpcionesFuncionario());
	}

	@SuppressWarnings("unchecked")
	private void registrarEventosConsultas() {
		viewConsultas.getButCsltaSolicXTipo().addEventHandler(MouseEvent.MOUSE_CLICKED, controlarEventosConsultas());
		viewConsultas.getButCsltaSolicXCliente().addEventHandler(MouseEvent.MOUSE_CLICKED, controlarEventosConsultas());
		viewConsultas.getButCsltaSolicXEstado().addEventHandler(MouseEvent.MOUSE_CLICKED, controlarEventosConsultas());
		viewConsultas.getButCsltaSolicXFunc().addEventHandler(MouseEvent.MOUSE_CLICKED, controlarEventosConsultas());
	}

	private EventHandler controlarEventosConsultas() {
		return new EventHandler() {
			@Override
			public void handle(Event evento) {
				String comando = ((Button) evento.getSource()).getText();
				switch (comando) {
				case "Consultar x funcionario":
					System.out.println("algo");
					break;
				case "Consultar x estado":
					System.out.println("algo");
					break;
				case "Consultar x tipo":
					System.out.println("algo");
					break;
				case "Consultar x cliente":
					System.out.println("algo");
					break;
				}
			}

		};
	}

	@SuppressWarnings("unchecked")
	private void registrarEventosGestionarDatos() {

	}

	@SuppressWarnings("rawtypes")
	private EventHandler controlarEventoPrincipal() {
		return new EventHandler() {
			@Override
			public void handle(Event evento) {
				String comando = ((Button) evento.getSource()).getText();
				switch (comando) {
				case "Ingresar":
					verificarUsuario();
					break;
				}
			}

		};
	}

	@SuppressWarnings("rawtypes")
	private EventHandler controlarEventosOpcionesFuncionario() {
		return new EventHandler() {
			@Override
			public void handle(Event evento) {
				String comando = ((Button) evento.getSource()).getText();
				Stage stage = new Stage();
				FXMLLoader f = new FXMLLoader();
				switch (comando) {
				case "Consultas":
					try {
						FileInputStream file = new FileInputStream(new File("views/fxml/ViewConsultas.fxml"));
						Pane pane = f.load(file);
						Scene scene = new Scene(pane, 586, 354);
						stage.setScene(scene);
						viewConsultas = (ViewConsultas) f.getController();
						registrarEventosConsultas();
						inicializarTipoSolicitudesEnConsultas();
						inicializarEstadosEnConsultas();
					} catch (Exception e) {
						e.printStackTrace();
					}
					stage.show();
					break;
				case "Atender solicitudes":

					break;
				case "Asignar solicitudes":

					break;
				case "Gestor de datos":
					try {
						FileInputStream file = new FileInputStream(new File("views/fxml/ViewGestionarDatos.fxml"));
						Parent pane = f.load(file);
						Scene scene = new Scene(pane, 328, 255);
						stage.setScene(scene);
						viewGestionarDatos = (ViewGestionarDatos) f.getController();
						registrarEventosGestionarDatos();
					} catch (Exception e) {
						e.printStackTrace();
					}
					stage.show();
					break;
				}
			}

		};
	}

	private void inicializarEstadosEnConsultas() {
		// TODO setear el combo box del view consultas para mostrar los estados que
		// existen.

	}

	private void inicializarTipoSolicitudesEnConsultas() {
		// TODO setear el combo box del view consultas para mostrar los tipos que
		// existen.

	}

	@SuppressWarnings("rawtypes")
	private EventHandler controlarEventosGestionarClientes() {
		return new EventHandler() {
			@Override
			public void handle(Event evento) {
				String comando = ((Button) evento.getSource()).getText();
				switch (comando) {
				case "Agregar":

					break;
				case "Modificar":

					break;
				case "Borrar":

					break;
				}
			}

		};
	}

	@SuppressWarnings("rawtypes")
	private EventHandler controlarEventosGestionarTipoProductos() {
		return new EventHandler() {
			@Override
			public void handle(Event evento) {
				String comando = ((Button) evento.getSource()).getText();
				switch (comando) {
				case "Agregar":

					break;
				case "Modificar":

					break;
				case "Borrar":

					break;
				}
			}

		};
	}

	@SuppressWarnings("rawtypes")
	private EventHandler controlarEventosGestionarFuncionarios() {
		return new EventHandler() {
			@Override
			public void handle(Event evento) {
				String comando = ((Button) evento.getSource()).getText();
				switch (comando) {
				case "Agregar":

					break;
				case "Modificar":

					break;
				case "Borrar":

					break;
				}
			}

		};
	}

	@SuppressWarnings("rawtypes")
	private EventHandler controlarEventosGestionarTipoSolicitudes() {
		return new EventHandler() {
			@Override
			public void handle(Event evento) {
				String comando = ((Button) evento.getSource()).getText();
				switch (comando) {
				case "Agregar":

					break;
				case "Modificar":

					break;
				case "Borrar":

					break;
				}
			}

		};
	}

	public void verificarUsuario() {
		// Metodo para verificar usuario, TODO
		if (verificarUsuario(viewPrincipal.geTextFieldCedula().getText())) {
			// TODO - completar
			FXMLLoader loader = new FXMLLoader();
			try {
				FileInputStream xmlStream = new FileInputStream("./views/fxml/ViewRegistrarSolicitud.fxml");
				Pane pane = (Pane) loader.load(xmlStream);
				viewRegistrarSolicitud = loader.getController();
				viewRegistrarSolicitud.inicializar("Panel cliente", pane);
			} catch (Exception e) {
				e.printStackTrace();
			}
			iniciarEventosRegistrarSolicitud();

			viewRegistrarSolicitud.getStage().show();

		} else if (true/* usuario es cliente */) {
			Stage stage = new Stage();
			FXMLLoader f = new FXMLLoader();
			try {
				FileInputStream file = new FileInputStream(new File("views/fxml/ViewOpcionesFuncionario.fxml"));
				Pane pane = f.load(file);
				Scene scene = new Scene(pane, 200, 150);
				stage.setScene(scene);
				viewOpcionesFuncionario = (ViewOpcionesFuncionario) f.getController();
				registrarEventosViewOpcionesFuncionario();
			} catch (Exception e) {
				e.printStackTrace();
			}
			stage.show();
		} else {
			// TODO - usuario no existe
		}
	}

	private void iniciarEventosRegistrarSolicitud() {
		ChoiceBox<Eleccion> ch = viewRegistrarSolicitud.obtenerChoiceBox();
		viewRegistrarSolicitud.agregarEleccion("Creacion", "Creacion");
		viewRegistrarSolicitud.agregarEleccion("Modifiacion", "Modificacion");
		viewRegistrarSolicitud.agregarEleccion("Cancelacion", "Cancelacion");
		viewRegistrarSolicitud.agregarEleccion("Dano", "Dano");
		viewRegistrarSolicitud.agregarEleccion("Reclamo", "Reclamo");

		EventHandler<ActionEvent> handler = getActionHandlerRegistrarSolicitud();
		ch.setOnAction(handler);
		viewRegistrarSolicitud.obtenerBotonRegistrar().setOnAction(handler);
	}

	private EventHandler<ActionEvent> getActionHandlerRegistrarSolicitud() {
		EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Node node = (Node) event.getSource();
				String id = node.getId();
				switch (id) {
				case "chbTipoSolicitud": {

					try {
						cargarVistaSolicitud();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}

				case "bRegistrar": {
					registrarSolicitud();
					break;
				}

				case "hlObservaciones": {
					mostrarTextAreaObservaciones();
					break;
				}

				}

			}
		};

		return handler;
	}

	public void registrarSolicitud() {
		ChoiceBox<Eleccion> ch = viewRegistrarSolicitud.obtenerChoiceBox();

		int selected = ch.getSelectionModel().getSelectedIndex();
		String str = "";
		if (selected >= 0) {
			str = ((Eleccion) ch.getItems().get(selected)).obtenerComando();
		}

		switch (str) {
		case "Creacion": {

			// TODO Registrar solicitud de Creacion
			break;
		}

		case "Modificacion": {
			// TODO Registrar solicitud de Modificacion

			break;
		}

		case "Dano": {
			// TODO Registrar solicitud de Danio

			break;
		}

		case "Cancelacion": {
			// TODO Registrar solicitud de Cancelacion

			break;
		}

		case "Reclamo": {
			// TODO Registrar solicitud de Reclamo

			break;
		}
		default: {
			// TODO No se selecciono ningun tipo de solicitud

			System.out.println("No registrar");
		}
		}
	}

	public void mostrarTextAreaObservaciones() {
		Node nodo = viewRegistrarSolicitud.obtenerNodo("taObservaciones");
		if (nodo != null) {
			nodo.setVisible(!nodo.isVisible());

			nodo.setDisable(!nodo.isDisable());

			((TextArea) nodo).setText("");
		}
	}

	public void cargarVistaSolicitud() throws Exception {

		ChoiceBox<Eleccion> ch = viewRegistrarSolicitud.obtenerChoiceBox();
		int selected = ch.getSelectionModel().getSelectedIndex();

		String str = ((Eleccion) ch.getItems().get(selected)).obtenerComando();

		Pane pane = null;
		FXMLLoader loader = new FXMLLoader();
		FileInputStream is = null;

		if (str.equalsIgnoreCase("Creacion")) {

			is = new FileInputStream("./views/fxml/ViewSolicitudCreacion.fxml");

		} else if (str.equalsIgnoreCase("Modificacion")) {

			is = new FileInputStream("./views/fxml/ViewSolicitudModificar.fxml");

		} else if (str.equalsIgnoreCase("Cancelacion")) {

			is = new FileInputStream("./views/fxml/ViewSolicitudCancelacion.fxml");

		} else if (str.equalsIgnoreCase("Dano")) {

			is = new FileInputStream("./views/fxml/ViewSolicitudDano.fxml");

		} else if (str.equalsIgnoreCase("Reclamo")) {

			is = new FileInputStream("./views/fxml/ViewSolicitudReclamo.fxml");

		}

		pane = loader.load(is);
		viewRegistrarSolicitud.agregarEnVBox(pane);
		((Hyperlink) viewRegistrarSolicitud.obtenerNodo("hlObservaciones"))
				.setOnAction(getActionHandlerRegistrarSolicitud());

		@SuppressWarnings("unchecked")
		ChoiceBox<String> anomalias = (ChoiceBox<String>) viewRegistrarSolicitud.obtenerNodo("chbAnomalia");
		if (anomalias != null) {
			cargarAnomaliasSolicitud(anomalias);
		}

		@SuppressWarnings("unchecked")
		ChoiceBox<String> productos = (ChoiceBox<String>) viewRegistrarSolicitud.obtenerNodo("chbProducto");

		if (productos != null) {
			cargarProductosSolicitud(productos);
		}

	}

	private void cargarProductosSolicitud(ChoiceBox<String> productos) {
		List<String> productosBD = new ArrayList<>();
		// TODO Cargar productos desde BD y asignarlos a productosBD
		updateGUI(new Runnable() {

			@Override
			public void run() {
				productos.getItems().clear();
				for (String producto : productosBD) {
					productos.getItems().add(producto);
				}

			}
		});

	}

	/**
	 * Metodo para actualizar GUI ya sea desde el hilo main o hilos fuera del hilo de 
	 * la vista principal javaFx
	 * @param runnable Runnable que modifica elementos de la vista
	 */
	private void updateGUI(Runnable runnable) {
		Platform.runLater(runnable);
	}

	private void cargarAnomaliasSolicitud(ChoiceBox<String> anomalias) {
		List<String> anomaliasBD = new ArrayList<>();
		// TODO cargar anomalias en el choiceBox, conectar al modelo para pedir las
		// anomalias y asignarlas a anomaliasBD

		updateGUI(new Runnable() {

			@Override
			public void run() {
				anomalias.getItems().clear();
				for (String anomalia : anomaliasBD) {
					anomalias.getItems().add(anomalia);
				}

			}
		});

	}

	/**
	 * Retorna un valor booleano que verifica si la cédula de entrada pertenece a un
	 * cliente.
	 * 
	 * @param cedula Cedula del usuario
	 * @return
	 */
	private boolean verificarUsuario(String cedula) {
		// TODO conectarse al mundo y retornar valor
		return false;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
