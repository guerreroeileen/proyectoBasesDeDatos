
package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

public class SistemaGestion {
	
	private Connection connection;
	private ArrayList<Solicitud> solicitudes;
	private ArrayList<ClienteXProducto> cxp;

	public SistemaGestion() throws Exception {
		
		solicitudes= new ArrayList<Solicitud>();
		cxp = new ArrayList<ClienteXProducto>();
		try {
			connection = ConectionBD.getConection();
		} catch (Exception e) {
			throw new Exception("Error al conectarse a la base de datos");
		}
		
		actualizarSolicitudes();
		actualizarClienteXProducto();
	}
	
	
	public void actualizarClienteXProducto() throws SQLException{
		
		
		Statement st= connection.createStatement();
		ResultSet rs= st.executeQuery("SELECT s.* FROM ClienteXProducto s");
		
		while(rs.next()) {
			
			 String cliente_cc= rs.getString("cliente_cedula");     
		     String producto = rs.getString("producto_id");       
		     Date fecha_inicio = rs.getDate("fechainicio");   
		     Date fecha_fin = rs.getDate("fechafin");
			
			ClienteXProducto c= new ClienteXProducto(cliente_cc, producto, fecha_inicio, fecha_fin);
		     
			cxp.add(c);
		}
	}

	public void actualizarSolicitudes() throws SQLException {
		
		Statement st= connection.createStatement();
		ResultSet rs= st.executeQuery("SELECT s.* FROM SOLICITUD s");
		
		while(rs.next()) {
		   	String n_solicitud = rs.getString("n_solicitud") ;           
	        String observaciones = rs.getString("observaciones");       
	        Date fechaasignacion = rs.getDate("fechaasignacion");     
	        Date fechaatencion   = rs.getDate("fechaatencion");       
	        String causa = rs.getString("causa");                
	        String comentariofuncionario = rs.getString("comentariofuncionario");   
	        String cliente_cedula =rs.getString("cliente_cedula");           
	        String estado_codigo = rs.getString("estado_codigo");        
	        String funcionario_cedula = rs.getString("funcionario_cedula");     
	        String anomalia_id = rs.getString("anomalia_id");             
	        String tiposolicitud_id = rs.getString("tiposolicitud_id");        
	        String producto_id = rs.getString("producto_id");
	        
	      
	        Solicitud s= new Solicitud(n_solicitud, observaciones, fechaasignacion, fechaatencion, causa, comentariofuncionario, cliente_cedula, estado_codigo, funcionario_cedula, anomalia_id, tiposolicitud_id, producto_id);
	        
	        solicitudes.add(s);
		}
		
		
	}
	public ArrayList<Solicitud> consultarSolicitudFuncionario(String funcionario_cedula) throws SQLException {
		
		actualizarSolicitudes();
		ArrayList<Solicitud> filtro= new ArrayList<Solicitud>();
		
		for (int i = 0; i < solicitudes.size(); i++) {
			
			if(solicitudes.get(i).getFuncionariocedula().equals(funcionario_cedula)) {
			
				filtro.add(solicitudes.get(i));
				
			}
		}
		
		return filtro;
		}
	
		
	public ArrayList<Solicitud> consultarSolicitudEstado(String estado) throws SQLException {
		
		actualizarSolicitudes();

		ArrayList<Solicitud> filtro= new ArrayList<Solicitud>();
		
		for (int i = 0; i < solicitudes.size(); i++) {
			
			if(solicitudes.get(i).getEstado_codigo().equals(estado)) {
			
				filtro.add(solicitudes.get(i));
				
			}
		}
		
		return filtro;
		}
	
	public ArrayList<Solicitud> consultarSolicitudTipo(String tipo) throws SQLException {
		
		actualizarSolicitudes();

		ArrayList<Solicitud> filtro= new ArrayList<Solicitud>();
		
		for (int i = 0; i < solicitudes.size(); i++) {
			
			if(solicitudes.get(i).getTiposolicitud_id().equals(tipo)) {
			
				filtro.add(solicitudes.get(i));
				
			}
		}
		
		return filtro;
		}
	
	
	public ArrayList<ClienteXProducto> consultarProductoCliente(String cliente) throws SQLException {


		actualizarClienteXProducto();
		
		ArrayList<ClienteXProducto> filtro= new ArrayList<ClienteXProducto>();

		for (int i = 0; i < cxp.size(); i++) {

			if(cxp.get(i).getCliente_cc().equals(cliente)) {

				filtro.add(cxp.get(i));

			}
		}

		return filtro;
	}

	public boolean atenderSolicitud(String cedFun, String codSol, String comentario, String estado) throws Exception {
		try {
			String proceso = "{? = call pkatencionn3.fatendersolicitud(?,?,?,?)}";			
			CallableStatement c = connection.prepareCall(proceso);
			c.registerOutParameter(1, Types.VARCHAR);
			c.setString(2, cedFun);
			c.setString(3, codSol);
			c.setString(4, comentario);
			c.setString(5, estado);

			c.execute();
			
			String p=c.getString(1);
			if(!p.equals("0")) {
				throw new Exception(p);
			}
			return true;
		} catch (SQLException e) {
			throw new Exception("Error al efectuar la operacion");

		} catch (Exception a) {
			throw new Exception(a.getMessage());

		}
	}
	
	public void registrarEstado(String codigo, String nombre) throws Exception {
		String proceso = "{? = call pkregistronivel3.pregistrarestado(?,?)}";			
		try {
			CallableStatement c = connection.prepareCall(proceso);
			c.registerOutParameter(1, Types.VARCHAR);
			c.setString(2, codigo);
			c.setString(3, nombre);
			c.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new Exception("Error al efectuar la operacion");
		} catch (Exception a) {
			throw new Exception(a.getMessage());
		}
	}
	
	public void registrarProducto(String id, String nombre, String idTipoProducto) throws Exception {
		String proceso = "{? = call pkregistronivel3.pregistrarproducto(?,?,?)}";			
		try {
			CallableStatement c = connection.prepareCall(proceso);
			c.registerOutParameter(1, Types.VARCHAR);
			c.setString(2, id);
			c.setString(3, nombre);
			c.setString(4, idTipoProducto);
			c.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new Exception("Error al efectuar la operacion");
		} catch (Exception a) {
			throw new Exception(a.getMessage());
		}
	}
	
	public void registrarAnomalia(String nombre, String id) throws Exception {
		String proceso = "{? = call pkregistronivel3.pregistraranomalia(?,?)}";			
		try {
			CallableStatement c = connection.prepareCall(proceso);
			c.registerOutParameter(1, Types.VARCHAR);
			c.setString(2, nombre);
			c.setString(3, id);
			c.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new Exception("Error al efectuar la operacion");
		} catch (Exception a) {
			throw new Exception(a.getMessage());
		}
	}
	
	public void registrarFuncionario(String nombre, String cedula, String direccion, String telefono, Date fechaNacimiento) throws Exception {
		String proceso = "{? = call pkregistronivel3.pregistrarfuncionario(?,?,?,?,?)}";			
		try {
			CallableStatement c = connection.prepareCall(proceso);
			c.registerOutParameter(1, Types.VARCHAR);
			c.setString(2, cedula);
			c.setString(3, nombre);
			c.setString(4, direccion);
			c.setString(5, telefono);
			c.setDate(6, fechaNacimiento);
			c.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new Exception("Error al efectuar la operacion");
		} catch (Exception a) {
			throw new Exception(a.getMessage());
		}
	}
	
	public void registrarCliente(String nombre, String cedula, String direccion, String telefono, Date fechaNacimiento) throws Exception {
		String proceso = "{? = call pkregistronivel3.pregistrarcliente(?,?,?,?,?)}";			
		try {
			CallableStatement c = connection.prepareCall(proceso);
			c.registerOutParameter(1, Types.VARCHAR);
			c.setString(2, cedula);
			c.setString(3, nombre);
			c.setString(4, direccion);
			c.setString(5, telefono);
			c.setDate(6, fechaNacimiento);
			c.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new Exception("Error al efectuar la operacion");
		} catch (Exception a) {
			throw new Exception(a.getMessage());
		}
	}
	
	public void registrarSolicitud(String cedCliente, String tipoProd, String observ, String tipoSolic, String ivcaus, String nomAnoma) throws Exception {
		try {
			switch(tipoSolic) {
			case "TS_1":
				registrarSolicitudNuevoProducto(cedCliente, tipoProd, observ);
				break;
			case "TS_2":
				registrarSolicitudRetiro(cedCliente, tipoProd, ivcaus);
				break;
			case "TS_3":
				registrarSolicitudDano(cedCliente, tipoProd, observ, nomAnoma);
				break;
			case "TS_4":
				registrarSolicitudModificacion(cedCliente, tipoProd, observ);
				break;
			case "TS_5":
				registrarSolicitudReclamo(cedCliente, tipoProd, observ);
				break;
			}
		} catch (SQLException e) {
			throw new Exception("Error al efectuar la operacion");

		} catch (Exception a) {
			throw new Exception(a.getMessage());

		}
	}

	public void registrarSolicitudNuevoProducto(String cedCliente, String tipoProduct, String observ) throws SQLException {
		
			String proceso = "{? = call pkregistronivel3.pregistrarsolicitud(?,?,?,?,?,?,?)}";
			CallableStatement c = connection.prepareCall(proceso);
			c.registerOutParameter(1, Types.VARCHAR);
			c.setString(2, tipoProduct);
			c.setString(3, cedCliente);
			c.setString(4, observ);
			c.setString(5, "TS_1");
			c.setString(6, putidProducto(tipoProduct));
			c.setString(7, "");
			c.setString(8, "");
			c.execute();

	}
	
	public void registrarSolicitudModificacion(String cedCliente, String tipoProduct, String observ) throws SQLException {
		
		String proceso = "{? = call pkregistronivel3.pregistrarsolicitud(?,?,?,?,?,?,?)}";
		CallableStatement c = connection.prepareCall(proceso);
		c.registerOutParameter(1, Types.VARCHAR);
		c.setString(2, tipoProduct);
		c.setString(3, cedCliente);
		c.setString(4, observ);
		c.setString(5, "TS_4");
		c.setString(6, putidProducto(tipoProduct));
		c.setString(7, "");
		c.setString(8, "");
		c.execute();

	}
	
	public void registrarSolicitudDano(String cedCliente, String tipoProduct, String observ, String anom) throws SQLException {
		
		String proceso = "{? = call pkregistronivel3.pregistrarsolicitud(?,?,?,?,?,?,?)}";
		CallableStatement c = connection.prepareCall(proceso);
		c.registerOutParameter(1, Types.VARCHAR);
		c.setString(2, tipoProduct);
		c.setString(3, cedCliente);
		c.setString(4, observ);
		c.setString(5, "TS_3");
		c.setString(6, putidProducto(tipoProduct));
		c.setString(7, "");
		c.setString(8, anom);
		c.execute();

	}
	
	public void registrarSolicitudReclamo(String cedCliente, String tipoProduct, String observ) throws SQLException {
		
		String proceso = "{? = call pkregistronivel3.pregistrarsolicitud(?,?,?,?,?,?,?)}";
		CallableStatement c = connection.prepareCall(proceso);
		c.registerOutParameter(1, Types.VARCHAR);
		c.setString(2, tipoProduct);
		c.setString(3, cedCliente);
		c.setString(4, observ);
		c.setString(5, "TS_5");
		c.setString(6, putidProducto(tipoProduct));
		c.setString(7, "");
		c.setString(8, "");
		c.execute();

	}
	
	public void registrarSolicitudRetiro(String cedCliente, String tipoProduct, String causa) throws SQLException {
		
		String proceso = "{? = call pkregistronivel3.pregistrarsolicitud(?,?,?,?,?,?,?)}";
		CallableStatement c = connection.prepareCall(proceso);
		c.registerOutParameter(1, Types.VARCHAR);
		c.setString(2, tipoProduct);
		c.setString(3, cedCliente);
		c.setString(4, "");
		c.setString(5, "TS_2");
		c.setString(6, putidProducto(tipoProduct));
		c.setString(7, causa);
		c.setString(8, "");
		c.execute();

	}
	
	private String putidProducto(String tipo) {
		String id = "";
		if(tipo.equals("voz")) {
			id = "P_1";
		}
		else if(tipo.equals("datos")) {
			id = "P_2";
		} else {
			id = "P_3";
		}
		return id;
	}
		
	public static void main(String[] args) {
		try {
			SistemaGestion s = new SistemaGestion();
<<<<<<< HEAD
	
			//s.atenderSolicitud("1061816906", "1", "Uis", "2");
=======
//			s.registrarSolicitud( Davila","1111111111","El escondite","222",new Date(1981,12,23));
>>>>>>> abe0637352b1bc5d08d5f57c731e7c97bb1233ad
			System.out.println("Exito");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
}
