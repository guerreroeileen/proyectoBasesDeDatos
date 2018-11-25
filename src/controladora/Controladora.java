package controladora;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vista.ViewGestionarDatos;
import vista.ViewOpcionesFuncionario;
import vista.ViewPrincipal;

public class Controladora extends Application{
	
	private ViewGestionarDatos viewGestionarDatos;
	private ViewPrincipal viewPrincipal;
	private ViewOpcionesFuncionario viewOpcionesFuncionario;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader f = new FXMLLoader();
		FileInputStream file = new FileInputStream(new File("views/fxml/ViewPrincipal.fxml"));
		Pane pane = f.load(file);
		Scene scene = new Scene(pane, 285, 200);
//		scene.getStylesheets().add(new FileInputStream(new File("views/css/application.css")));
		primaryStage.setScene(scene);
		primaryStage.show();
		viewPrincipal = (ViewPrincipal)f.getController();
		registrarEventosViewPrincipal();
	}
	
	@SuppressWarnings("unchecked")
	private void registrarEventosViewPrincipal() {
		viewPrincipal.getButIngresar().addEventHandler(MouseEvent.MOUSE_CLICKED, controlarEventoPrincipal());
	}
	
	@SuppressWarnings("unchecked")
	private void registrarEventosViewOpcionesFuncionario() {
		viewPrincipal.getButIngresar().addEventHandler(MouseEvent.MOUSE_CLICKED, controlarEventoPrincipal());
	}
	
	@SuppressWarnings("rawtypes")
	private EventHandler controlarEventoPrincipal() {
		return new EventHandler() {
			@Override
			public void handle(Event evento) {
				String comando = ((Button)evento.getSource()).getText();
				switch(comando) {
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
				String comando = ((Button)evento.getSource()).getText();
				Stage stage = new Stage();
				FXMLLoader f = new FXMLLoader();
				switch(comando) {
				case "Consultas":
					try {
						FileInputStream file = new FileInputStream(new File("views/fxml/ViewConsultas.fxml"));
						Pane pane = f.load(file);
						Scene scene = new Scene(pane,200,150);
						stage.setScene(scene);
					}catch (Exception e) {
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
						Pane pane = f.load(file);
						Scene scene = new Scene(pane,200,150);
						stage.setScene(scene);
					}catch (Exception e) {
						e.printStackTrace();
					}
					stage.show();
					break;	
				}
			}
			
		};
	}
	
	@SuppressWarnings("rawtypes")
	private EventHandler controlarEventosGestionarClientes() {
		return new EventHandler() {
			@Override
			public void handle(Event evento) {
				String comando = ((Button)evento.getSource()).getText();
				switch(comando) {
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
				String comando = ((Button)evento.getSource()).getText();
				switch(comando) {
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
				String comando = ((Button)evento.getSource()).getText();
				switch(comando) {
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
				String comando = ((Button)evento.getSource()).getText();
				switch(comando) {
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
		if(false/*usuario es cliente*/) {
			
		}else if(true/*usuario es cliente*/) {
			Stage stage = new Stage();
			FXMLLoader f = new FXMLLoader();
			try {
				FileInputStream file = new FileInputStream(new File("views/fxml/ViewOpcionesFuncionario.fxml"));
				Pane pane = f.load(file);
				Scene scene = new Scene(pane,200,150);
				stage.setScene(scene);
			}catch (Exception e) {
				e.printStackTrace();
			}
			stage.show();
		}else {
			//usuario no existe
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
