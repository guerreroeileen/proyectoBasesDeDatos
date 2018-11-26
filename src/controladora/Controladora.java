package controladora;

import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.SistemaGestion;
import vista.ViewAsignarSolicitud;
import vista.ViewAtenderSolicitud;
import vista.ViewConsultas;
import vista.ViewGestionarDatos;
import vista.ViewOpcionesFuncionario;
import vista.ViewPrincipal;
import vista.ViewRegistrarSolicitud;
import vista.ViewRegistrarSolicitud.Eleccion;

public class Controladora extends Application {

	private SistemaGestion sg = new SistemaGestion();
	
	private ViewGestionarDatos viewGestionarDatos;
	private ViewPrincipal viewPrincipal;
	private ViewOpcionesFuncionario viewOpcionesFuncionario;
	private ViewConsultas viewConsultas;
	private ViewRegistrarSolicitud viewRegistrarSolicitud;
	private ViewAtenderSolicitud viewAtenderSolicitudes;
	private ViewAsignarSolicitud viewAsignarSolicitud;

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
	private void registrarEventoAsignacion() {
		viewAsignarSolicitud.getButAsignarSolicitud().addEventHandler(MouseEvent.MOUSE_CLICKED, controlarEventoAsignacion());
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void registrarEventosViewOpcionesFuncionario() {
		EventHandler handler = controlarEventosOpcionesFuncionario();
		viewOpcionesFuncionario.getButConsultas().addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		viewOpcionesFuncionario.getButAsignarSolic().addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		viewOpcionesFuncionario.getButAtenderSolic().addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		viewOpcionesFuncionario.getButGestorDatos().addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })

	private void registrarEventosConsultas() {
		EventHandler handler = controlarEventosConsultas();
		viewConsultas.getButCsltaSolicXTipo().addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		viewConsultas.getButCsltaSolicXCliente().addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		viewConsultas.getButCsltaSolicXEstado().addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		viewConsultas.getButCsltaSolicXFunc().addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
	}

	@SuppressWarnings("rawtypes")
	private EventHandler controlarEventosConsultas() {
		return new EventHandler() {
			@Override
			public void handle(Event evento) {
				String comando = ((Button) evento.getSource()).getText();
				switch (comando) {
				case "Consultar x funcionario":{
					consultarXFuncionario(viewConsultas.getTxtCedulaFuncionario().getText());
					break;}
				case "Consultar x estado":{
					consultarXEstado(viewConsultas.getCmbBoxEstadoSol().getValue());
					break;}
				case "Consultar x tipo":{
					consultarXTipo(viewConsultas.getCmbBoxTipoSol().getValue());
					break;}
				case "Consultar x cliente}":{
					consultarXCliente(viewConsultas.getTxtCedulaCliente().getText());
					break;}
				}
			}

		};
	}
	
	public void consultarXFuncionario(String cedulaFunc) {
		
		
		try {
			viewConsultas.getTxtResultConsulta().setText(sg.consultarSolicitudFuncionario(cedulaFunc));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TODO - completar con modelo.
		
		
	}
	
	public void consultarXEstado(String estado) {
		//TODO - completar con modelo.
		
		try {
			sg.consultarSolicitudEstado(estado);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void consultarXTipo(String tipo) {
		//TODO - completar con modelo.
		try {
			sg.consultarSolicitudTipo(tipo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void consultarXCliente(String cedulaCliente) {
		//TODO - completar con modelo.

		try {
			sg.consultarProductoCliente(cedulaCliente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked"})
	private void registrarEventosGestionarDatos() {
		EventHandler handlerClientes = controlarEventosGestionarClientes();
		EventHandler handlerTipoProductos = controlarEventosGestionarTipoProductos();
		EventHandler handlerTipoSolicitudes = controlarEventosGestionarTipoSolicitudes();
		EventHandler handlerFuncionarios = controlarEventosGestionarFuncionarios();
		
		viewGestionarDatos.getButAgregarClient().addEventHandler(MouseEvent.MOUSE_CLICKED, handlerClientes);
		viewGestionarDatos.getButBorrarClient().addEventHandler(MouseEvent.MOUSE_CLICKED, handlerClientes);
		viewGestionarDatos.getButBuscarClientAct().addEventHandler(MouseEvent.MOUSE_CLICKED, handlerClientes);
		viewGestionarDatos.getButBuscarClientElim().addEventHandler(MouseEvent.MOUSE_CLICKED, handlerClientes);
		viewGestionarDatos.getButModClient().addEventHandler(MouseEvent.MOUSE_CLICKED, handlerClientes);
		
		viewGestionarDatos.getButAgregarFunc().addEventHandler(MouseEvent.MOUSE_CLICKED, handlerFuncionarios);
		viewGestionarDatos.getButBorrarFunc().addEventHandler(MouseEvent.MOUSE_CLICKED, handlerFuncionarios);
		viewGestionarDatos.getButBuscarFuncAct().addEventHandler(MouseEvent.MOUSE_CLICKED, handlerFuncionarios);
		viewGestionarDatos.getButBuscarFuncElim().addEventHandler(MouseEvent.MOUSE_CLICKED, handlerFuncionarios);
		viewGestionarDatos.getButModFunc().addEventHandler(MouseEvent.MOUSE_CLICKED, handlerFuncionarios);
		
		viewGestionarDatos.getButAgregarTiProducto().addEventHandler(MouseEvent.MOUSE_CLICKED, handlerTipoProductos);
		viewGestionarDatos.getButBorrarTiProducto().addEventHandler(MouseEvent.MOUSE_CLICKED, handlerTipoProductos);
		viewGestionarDatos.getButBuscarTiProductAct().addEventHandler(MouseEvent.MOUSE_CLICKED, handlerTipoProductos);
		viewGestionarDatos.getButBuscarTiProductElim().addEventHandler(MouseEvent.MOUSE_CLICKED, handlerTipoProductos);
		viewGestionarDatos.getButModTiProducto().addEventHandler(MouseEvent.MOUSE_CLICKED, handlerTipoProductos);
		
		viewGestionarDatos.getButAgregarTiSolicitud().addEventHandler(MouseEvent.MOUSE_CLICKED, handlerTipoSolicitudes);
		viewGestionarDatos.getButBorrarTiSolicitud().addEventHandler(MouseEvent.MOUSE_CLICKED, handlerTipoSolicitudes);
		viewGestionarDatos.getButBuscarTiSolicAct().addEventHandler(MouseEvent.MOUSE_CLICKED, handlerTipoSolicitudes);
		viewGestionarDatos.getButBuscarTiSolicElim().addEventHandler(MouseEvent.MOUSE_CLICKED, handlerTipoSolicitudes);
		viewGestionarDatos.getButModTiSolicitud().addEventHandler(MouseEvent.MOUSE_CLICKED, handlerTipoSolicitudes);
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
	private EventHandler controlarEventoAsignacion() {
		return new EventHandler() {
			@Override
			public void handle(Event evento) {
				String comando = ((Button) evento.getSource()).getText();
				switch (comando) {
				case "Asignar":
					asignarSolicitudAFuncionario(viewAsignarSolicitud.getTxtCodSolicitud().getText(), viewAsignarSolicitud.getTxtCedulaFuncionario().getText());
					break;
				}
			}

		};
	}
	
	public void asignarSolicitudAFuncionario(String codigo, String cedula) {
		//TODO realizar en el modelo la asignación. En caso de algúno de los fallos se puede desplegar un Alert (es como JOptionPane).
		
		try {
			sg.asignarSolicitud(codigo, cedula);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
					try {
						FileInputStream file = new FileInputStream(new File("views/fxml/ViewAtenderSolicitud.fxml"));
						Pane pane = f.load(file);
						viewAtenderSolicitudes = f.getController();
						viewAtenderSolicitudes.inicializar("Atendiendo solicitudes", pane);
						registrarEventosAtenderSolicitudes();
						viewAtenderSolicitudes.getStage().show();
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case "Asignar solicitudes":
					try {
						FileInputStream file = new FileInputStream(new File("views/fxml/ViewAsignarSolicitud.fxml"));
						Parent pane = f.load(file);
						Scene scene = new Scene(pane, 312, 117);
						stage.setScene(scene);
						viewAsignarSolicitud = (ViewAsignarSolicitud) f.getController();
						registrarEventoAsignacion();
					} catch (Exception e) {
						e.printStackTrace();
					}
					stage.show();
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

	public void registrarEventosAtenderSolicitudes() {
		EventHandler<ActionEvent> handler = controlarEventosAtenderSolicitudes();
		viewAtenderSolicitudes.getRechazar().setOnAction(handler);
		viewAtenderSolicitudes.getRadioButtonAtendiendo().setOnAction(handler);
		viewAtenderSolicitudes.getAtender().setOnAction(handler);

	}

	private EventHandler<ActionEvent> controlarEventosAtenderSolicitudes() {
		EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Node nodo = (Node) event.getSource();
				String idSrc = nodo.getId();
				switch (idSrc) {
				case "bAtender": {
					atenderSolicitud();
					break;
				}
				case "bRechazar": {
					rechazarSolicitud();
					break;
				}

				case "rbAtendiendo": {
					boolean isSelected = viewAtenderSolicitudes.getRadioButtonAtendiendo().isSelected();
					cambiarModoAtenderSolicitud(isSelected);
					break;
				}

				default: {
					break;
				}
				}

			}
		};
		return handler;
	}

	public void cambiarModoAtenderSolicitud(boolean danoOReclamo) {
		Button bRechazar = viewAtenderSolicitudes.getRechazar();
		bRechazar.setVisible(danoOReclamo);
		bRechazar.setDisable(!danoOReclamo);
	}

	public void atenderSolicitud() {
		String cedula = viewAtenderSolicitudes.getTextFieldCedula().getText();
		String codigo = viewAtenderSolicitudes.geTextFieldCodigo().getText();
		String observaciones = viewAtenderSolicitudes.getTextAreaObservaciones().getText();
		
		try {
			sg.atenderSolicitud(cedula, codigo, observaciones, "1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO conectarse a modelo.
	}

	public void rechazarSolicitud() {
		String cedula = viewAtenderSolicitudes.getTextFieldCedula().getText();
		String codigo = viewAtenderSolicitudes.geTextFieldCodigo().getText();
		String observaciones = viewAtenderSolicitudes.getTextAreaObservaciones().getText();
		
			try {
				sg.atenderSolicitud(cedula, codigo, observaciones, "Rechazada");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		// TODO conectarse a modelo.

	}

	private void inicializarEstadosEnConsultas() {
		// TODO setear el combo box del view consultas para mostrar los estados que
		// existen.

	}

	private void inicializarTipoSolicitudesEnConsultas() {
		// TODO setear el combo box del view consultas para mostrar los tipos que
		// existen.
	

	}

	@SuppressWarnings({ "rawtypes", "unused" })
	private EventHandler controlarEventosGestionarClientes() {
		return new EventHandler() {
			@Override
			public void handle(Event evento) {
				String comando = ((Button) evento.getSource()).getText();
				switch (comando) {
				case "Agregar":{
					String nombre = viewGestionarDatos.getTxtNombClientCrear().getText();
					String cedula = viewGestionarDatos.getTxtCedulaClientCrear().getText();
					//String fechaNacimiento = viewGestionarDatos.getTxtCedulaClientCrear().getText();
					String direccion = viewGestionarDatos.getTxtDirClientCrear().getText();
					String telefono = viewGestionarDatos.getTxtTelClientCrear().getText();
					
					try {
						sg.registrarCliente(nombre, cedula, direccion, telefono);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// TODO conectarse a modelo para agregar el cliente.
					break;}
				case "Modificar":{
					String nombre = viewGestionarDatos.getTxtNombClientMod().getText();
					String cedula = viewGestionarDatos.getTxtCedulaClientMod().getText();
//					String fechaNacimiento = viewGestionarDatos.getTxtCedulaClientCrear().getText();
					String direccion = viewGestionarDatos.getTxtDirClientMod().getText();
					String telefono = viewGestionarDatos.getTxtTelClientMod().getText();
					// TODO conectarse a modelo para modificar el cliente.
					break;}
				case "Buscar":{
					String cedula = viewGestionarDatos.getTxtCedulaClientMod().getText();
					// TODO conectarse a modelo para buscar el cliente que se quiere modificar.
					break;}
				case "Encontrar":{
					String cedula = viewGestionarDatos.getTxtCedulaClientBorrar().getText();
					// TODO conectarse a modelo para buscar el cliente que se quiere eliminar.
					break;}
				case "Borrar":{
					String cedula = viewGestionarDatos.getTxtCedulaClientBorrar().getText();
					// TODO conectarse a modelo para eliminar el cliente.
					break;}
				}
			}

		};
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	private EventHandler controlarEventosGestionarTipoProductos() {
		return new EventHandler() {
			@Override
			public void handle(Event evento) {
				String comando = ((Button) evento.getSource()).getText();
				switch (comando) {
				case "Agregar":{
					String codigo = viewGestionarDatos.getTxtCodTiProductoCrear().getText();
					String descripcion = viewGestionarDatos.getTxtDescTiProductoCrear().getText();
					// TODO conectarse a modelo para agregar el tipo de producto.
					
					break;}
				case "Modificar":{
					String codigo = viewGestionarDatos.getTxtCodTiProductoMod().getText();
					// TODO conectarse a modelo para modificar el tipo de producto.
					break;}
				case "Buscar":{
					String codigo = viewGestionarDatos.getTxtCodTiProductoMod().getText();
					// TODO conectarse a modelo para buscar el tipo de producto que se quiere modificar.
					break;}
				case "Encontrar":{
					String codigo = viewGestionarDatos.getTxtCodTiProductoBorrar().getText();
					// TODO conectarse a modelo para buscar el tipo de producto que se quiere eliminar.
					break;}
				case "Borrar":{
					String codigo = viewGestionarDatos.getTxtCodTiProductoBorrar().getText();
					// TODO conectarse a modelo para eliminar el tipo de producto.
					break;}
				}
			}

		};
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	private EventHandler controlarEventosGestionarFuncionarios() {
		return new EventHandler() {
			@Override
			public void handle(Event evento) {
				String comando = ((Button) evento.getSource()).getText();
				switch (comando) {
				case "Agregar":{
					String nombre = viewGestionarDatos.getTxtNombFuncCrear().getText();
					String cedula = viewGestionarDatos.getTxtCedulaFuncCrear().getText();
//					String fechaNacimiento = viewGestionarDatos.getTxtCedulaClientCrear().getText();
					String direccion = viewGestionarDatos.getTxtDirFuncCrear().getText();
					String telefono = viewGestionarDatos.getTxtTelFuncCrear().getText();
					// TODO conectarse a modelo para agregar el funcionario.
					
					try {
						sg.registrarFuncionario(nombre, cedula, direccion, telefono);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;}
				case "Modificar":{
					String cedula = viewGestionarDatos.getTxtCedulaFuncMod().getText();
					// TODO conectarse a modelo para modificar el funcionario.
					break;}
				case "Buscar":{
					String cedula = viewGestionarDatos.getTxtCedulaFuncMod().getText();
					// TODO conectarse a modelo para buscar el funcionario que se quiere modificar.
					break;}
				case "Encontrar":{
					String cedula = viewGestionarDatos.getTxtCedulaFuncBorrar().getText();
					// TODO conectarse a modelo para buscar el funcionario que se quiere eliminar.
					break;}
				case "Borrar":{
					String cedula = viewGestionarDatos.getTxtCedulaFuncBorrar().getText();
					// TODO conectarse a modelo para eliminar el funcionario.
					break;}
				}
			}

		};
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	private EventHandler controlarEventosGestionarTipoSolicitudes() {
		return new EventHandler() {
			@Override
			public void handle(Event evento) {
				String comando = ((Button) evento.getSource()).getText();
				switch (comando) {
				case "Agregar":{
					String codigo = viewGestionarDatos.getTxtCodTiSolicitudCrear().getText();
					String descripcion = viewGestionarDatos.getTxtDecTiSolicitudCrear().getText();
					// TODO conectarse a modelo para agregar el tipo de solicitud.
					break;}
				case "Modificar":{
					String codigo = viewGestionarDatos.getTxtCodTiSolicitudMod().getText();
					// TODO conectarse a modelo para modificar el tipo de solicitud.
					break;}
				case "Buscar":{
					String codigo = viewGestionarDatos.getTxtCodTiSolicitudMod().getText();
					// TODO conectarse a modelo para buscar el tipo de solicitud que se quiere modificar.
					break;}
				case "Encontrar":{
					String codigo = viewGestionarDatos.getTxtCodTiSolicitudBorrar().getText();
					// TODO conectarse a modelo para buscar el tipo de solicitud que se quiere eliminar.
					break;}
				case "Borrar":{
					String codigo = viewGestionarDatos.getTxtCodTiSolicitudBorrar().getText();
					// TODO conectarse a modelo para eliminar el tipo de solicitud.
					break;}
				}
			}

		};
	}

	public void verificarUsuario() {
		// Metodo para verificar usuario, TODO
		try {
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

			} else {
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
			}
		} catch (Exception e) {
			mostrarMensajeAUsuario(AlertType.ERROR, "Error", e.getMessage());
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

			registrarSolicituDeCreacion();
			break;
		}

		case "Modificacion": {
			registrarSolicituDeModificacion();

			break;
		}

		case "Dano": {
			registrarSolicituDeDano();

			break;
		}

		case "Cancelacion": {
			registrarSolicituDeCancelacion();

			break;
		}

		case "Reclamo": {
			registrarSolicituDeReclamo();

			break;
		}
		default: {
			mostrarMensajeAUsuario(AlertType.CONFIRMATION, "Solicitud", "Seleccione un tipo de solicitud");
		}
		}
	}

	private void registrarSolicituDeCreacion() {
		try {
			Object[] info = obtenerDatosGeneralesRegistrarSolicitud();
			String cedula = (String) info[0];
			String producto = (String) info[1];
			String observaciones = (String) info[2];
			// TODO Conectar al modelo y usar datos para registrar solicitud de creacion
		} catch (Exception e) {
			mostrarMensajeAUsuario(AlertType.ERROR, "Error registrando", e.getMessage());
			
		}

	}

	private void registrarSolicituDeModificacion() {
		try {
			// TODO QUITAR SYSO
			System.out.println("mod");
			Object[] info = obtenerDatosGeneralesRegistrarSolicitud();
			@SuppressWarnings("unchecked")
			ChoiceBox<String> chbNuevoProducto = (ChoiceBox<String>) viewRegistrarSolicitud
					.obtenerNodoPorId("chbNuevoProducto");
			int indexNuevoProducto = chbNuevoProducto.getSelectionModel().getSelectedIndex();
			String cedula = (String) info[0];
			String producto = (String) info[1];
			String observaciones = (String) info[2];
			String nuevoProducto = chbNuevoProducto.getItems().get(indexNuevoProducto);
			// TODO Conectar al modelo
		} catch (Exception e) {
			mostrarMensajeAUsuario(AlertType.ERROR, "Error registrando", e.getMessage());

		}
	}

	private void registrarSolicituDeDano() {
		try {
			// TODO QUITAR SYSO
			System.out.println("dano");
			Object[] info = obtenerDatosGeneralesRegistrarSolicitud();
			@SuppressWarnings("unchecked")
			ChoiceBox<String> chbAnomalia = (ChoiceBox<String>) viewRegistrarSolicitud.obtenerNodoPorId("chbAnomalia");
			int indexAnomalia = chbAnomalia.getSelectionModel().getSelectedIndex();
			String cedula = (String) info[0];
			String producto = (String) info[1];
			String observaciones = (String) info[2];
			String anomalia = chbAnomalia.getItems().get(indexAnomalia);

			// TODO Conectar al modelo
		} catch (Exception e) {
			mostrarMensajeAUsuario(AlertType.ERROR, "Error registrando", e.getMessage());

		}
	}

	private void registrarSolicituDeCancelacion() {
		try {
			// TODO QUITAR SYSO
			System.out.println("can");
			Object[] info = obtenerDatosGeneralesRegistrarSolicitud();
			String cedula = (String) info[0];
			String producto = (String) info[1];
			String observaciones = (String) info[2];
			String causa = ((TextArea) viewRegistrarSolicitud.obtenerNodoPorId("taCausa")).getText();
			// TODO Conectar al modelo
		} catch (Exception e) {
			mostrarMensajeAUsuario(AlertType.ERROR, "Error registrando", e.getMessage());

		}
	}

	private void registrarSolicituDeReclamo() {
		try {
			// TODO QUITAR SYSO
			System.out.println("rec");
			Object[] info = obtenerDatosGeneralesRegistrarSolicitud();
			String cedula = (String) info[0];
			String producto = (String) info[1];
			String observaciones = (String) info[2];
			// TODO Conectar al modelo
		} catch (Exception e) {
			mostrarMensajeAUsuario(AlertType.ERROR, "Error registrando", e.getMessage());
		}
	}

	public void mostrarTextAreaObservaciones() {
		Node nodo = viewRegistrarSolicitud.obtenerNodoPorId("taObservaciones");
		if (nodo != null) {
			nodo.setVisible(!nodo.isVisible());

			nodo.setDisable(!nodo.isDisable());

			((TextArea) nodo).setText("");
		}
	}

	/**
	 * Este metodo obtiene los datos generales para registrar una solicitud: cedula,
	 * producto seleccionado y observaciones.
	 * 
	 * @return info en cada indice posee: 0: cedula, 1:producto, 2:observaciones
	 * @throws Exception No se ha seleccionado ningun producto
	 */
	private Object[] obtenerDatosGeneralesRegistrarSolicitud() throws Exception {
		Object[] info = new Object[3];

		TextField tfCedula = (TextField) viewRegistrarSolicitud.obtenerNodoPorId("tfCedula");
		@SuppressWarnings("unchecked")
		ChoiceBox<String> chbProductos = (ChoiceBox<String>) viewRegistrarSolicitud.obtenerNodoPorId("chbProducto");
		TextArea taObservaciones = (TextArea) viewRegistrarSolicitud.obtenerNodoPorId("taObservaciones");

		String cedula = tfCedula.getText();
		info[0] = cedula;

		int indexProducto = chbProductos.getSelectionModel().getSelectedIndex();

		if (indexProducto >= 0) {
			String producto = chbProductos.getItems().get(indexProducto);
			String observaciones = taObservaciones.getText();
			info[1] = producto;
			info[2] = producto;
		} else {
			throw new Exception("No se ha seleccionado ningun producto");
		}

		return info;

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
		if (pane != null) {
			viewRegistrarSolicitud.agregarEnVBox(pane);
		}
		
		((Hyperlink) viewRegistrarSolicitud.obtenerNodoPorId("hlObservaciones"))
				.setOnAction(getActionHandlerRegistrarSolicitud());

		@SuppressWarnings("unchecked")
		ChoiceBox<String> anomalias = (ChoiceBox<String>) viewRegistrarSolicitud.obtenerNodoPorId("chbAnomalia");
		if (anomalias != null) {
			cargarAnomaliasSolicitud(anomalias);
		}

		@SuppressWarnings("unchecked")
		ChoiceBox<String> productos = (ChoiceBox<String>) viewRegistrarSolicitud.obtenerNodoPorId("chbProducto");

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
	 * Metodo para actualizar GUI ya sea desde el hilo main o hilos fuera del hilo
	 * de la vista principal javaFx
	 * 
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

	public void mostrarMensajeAUsuario(AlertType type, String title, String contentText) {
		Alert alert = new Alert(type, contentText, ButtonType.APPLY, ButtonType.CANCEL);
		alert.setTitle(title);
		alert.show();

	}

	/**
	 * Retorna un valor booleano que verifica si la cÃ©dula de entrada pertenece a un
	 * cliente.
	 * 
	 * @param cedula
	 * @return value, TRUE Si es cliente, FALSE si es funcionario
	 * @throws Exception si el cliente no existe debe retornar una excepcion.
	 */
	private boolean verificarUsuario(String cedula) throws Exception {
		// TODO conectarse al mundo y retornar valor o excepcion
		
		return sg.verificarUsuario(cedula);

	}

	public static void main(String[] args) {
		launch(args);
	}

}
