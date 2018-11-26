
package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalTime;
import java.util.ArrayList;

public class SistemaGestion {
	
	private Connection connection;
	private ArrayList<Solicitud> solicitudes;
	private ArrayList<ClienteXProducto> cxp;
	private ArrayList<Cliente> clientes;
	private ArrayList<Funcionario> funcionarios;

	public SistemaGestion()  {
		
		solicitudes= new ArrayList<Solicitud>();
		cxp = new ArrayList<ClienteXProducto>();
		clientes= new ArrayList<Cliente>();
		funcionarios= new ArrayList<Funcionario>();

		try {
			connection = ConectionBD.getConection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
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
	
	public void actualizarFuncionario()throws SQLException {
		
		Statement st= connection.createStatement();
		ResultSet rs= st.executeQuery("SELECT s.* FROM FUNCIONARIO s");
		
		while(rs.next()) {
			

			String cedula= rs.getString("cedula");           
		    String nombre= rs.getString("nombre");            
		    Date fechanacimiento= rs.getDate("fechanacimiento");  
		    String direccion= rs.getString("direccion");         
		    String telefono= rs.getString("telefono");
			
		    Funcionario f= new Funcionario(cedula, nombre, direccion, telefono, fechanacimiento);
		    funcionarios.add(f);
		}
		
		
	}
	
	public void actualizarClientes()throws SQLException{
		
		Statement st= connection.createStatement();
		ResultSet rs= st.executeQuery("SELECT s.* FROM CLIENTE s");
		
		while(rs.next()) {
			

			String cedula= rs.getString("cedula");           
		    String nombre= rs.getString("nombre");            
		    Date fechanacimiento= rs.getDate("fechanac");  
		    String direccion= rs.getString("direccion");         
		    int telefono= rs.getInt("telefono");
			
		    Cliente c= new Cliente(cedula, nombre, direccion, fechanacimiento, telefono);
		    clientes.add(c);
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
	
	public boolean verificarUsuario(String cedulaCliente) throws Exception{
		
		actualizarFuncionario();
		actualizarClientes();
		
		System.out.println(clientes.get(0).getCedula());
		for (int i = 0; i < clientes.size(); i++) {
		
			if(clientes.get(i).getCedula().equals(cedulaCliente)) {
				
				return true;
			}
			
			
		}
		for (int i = 0; i < funcionarios.size(); i++) {
			
			if(funcionarios.get(i).getIvcedula().equals(cedulaCliente)) {
				
				
				return false;
			}
			
			
		}

		
		
		throw new Exception("No está registrado en nuestra base de datos");
		
		
	}
	public String consultarSolicitudFuncionario(String funcionario_cedula) throws SQLException {
		
		actualizarSolicitudes();
		String filtro= "";
		
		for (int i = 0; i < solicitudes.size(); i++) {
			
			if(solicitudes.get(i).getFuncionariocedula().equals(funcionario_cedula)) {
			
				filtro+= "Solicitud #: "+solicitudes.get(i).getN_solicitud()+" Estado: "+solicitudes.get(i).getEstado_codigo() + " Causa: "+ solicitudes.get(i).getCausa()+"\n";
				
			}
		}
		
		return filtro;
		}
	
		
	public String consultarSolicitudEstado(String estado) throws SQLException {
		
		actualizarSolicitudes();

		String filtro= "";
		
		for (int i = 0; i < solicitudes.size(); i++) {
			
			if(solicitudes.get(i).getEstado_codigo().equals(estado)) {
			
				filtro+= "Solicitud #: "+solicitudes.get(i).getN_solicitud()+" Estado: "+solicitudes.get(i).getEstado_codigo() + " Causa: "+ solicitudes.get(i).getCausa()+"\n";
				
			}
		}
		
		return filtro;
		}
	
	public String consultarSolicitudTipo(String tipo) throws SQLException {
		
		actualizarSolicitudes();

		String filtro= " " ;
		
		for (int i = 0; i < solicitudes.size(); i++) {
			
			if(solicitudes.get(i).getTiposolicitud_id().equals(tipo)) {
			
				filtro+= "Solicitud #: "+solicitudes.get(i).getN_solicitud()+" Estado: "+solicitudes.get(i).getEstado_codigo() + " Causa: "+ solicitudes.get(i).getCausa()+"\n";
				
			}
		}
		
		return filtro;
		}
	
	
	public String consultarProductoCliente(String cliente) throws SQLException {


		actualizarClienteXProducto();
		
		String filtro= "";

		for (int i = 0; i < cxp.size(); i++) {

			if(cxp.get(i).getCliente_cc().equals(cliente)) {

				filtro+= "Producto: "+ cxp.get(i).getProducto()+ "Fecha inicio: "+ cxp.get(i).getFecha_inicio()+ "Fecha fin: "+ cxp.get(i).getFecha_fin()+ "\n";

			}
		}

		return filtro;
	}
	
	public void asignarSolicitud(String cods, String cedfuncionario) throws SQLException {
		
		String proceso = "{? = call pkatencionn3.fasignacionindividual(?,?)}";			
		CallableStatement c = connection.prepareCall(proceso);
		c.registerOutParameter(1, Types.VARCHAR);
		c.setString(2, cedfuncionario);
		c.setString(3, cods);
	
		c.execute();
		
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
	
	public void registrarTipoProducto(String id, String nombre, String descripcion) throws Exception {
		
		String proceso= "{? = call pktipoproducto.pinsertar(?,?,?)}";
		
		try {
			CallableStatement c = connection.prepareCall(proceso);
		
			c.setString(0,id);
			c.setString(1, nombre);
			c.setString(2, descripcion);
			
			c.execute();
		}catch (SQLException e) {
			
			throw new Exception("Error al efectuar la operación");
		}catch (Exception a) {
			
			a.printStackTrace();
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
	
	public void registrarFuncionario(String nombre, String cedula, String direccion, String telefono) throws Exception {
		String proceso = "{? = call pkregistronivel3.pregistrarfuncionario(?,?,?,?,?)}";			
		try {
			CallableStatement c = connection.prepareCall(proceso);
			c.registerOutParameter(1, Types.VARCHAR);
			c.setString(2, cedula);
			c.setString(3, nombre);
			c.setString(4, direccion);
			c.setString(5, telefono);
			c.setDate(6, Date.valueOf("2018-11-26"));
			c.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new Exception("Error al efectuar la operacion");
		} catch (Exception a) {
			throw new Exception(a.getMessage());
		}
	}
	
	public void registrarCliente(String nombre, String cedula, String direccion, String telefono) throws Exception {
		String proceso = "{? = call pkregistronivel3.pregistrarcliente(?,?,?,?,?)}";			
		try {
			CallableStatement c = connection.prepareCall(proceso);
			c.registerOutParameter(1, Types.VARCHAR);
			c.setString(2, cedula);
			c.setString(3, nombre);
			c.setString(4, direccion);
			c.setString(5, telefono);
			c.setDate(6, Date.valueOf("2018-11-26"));
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
	
	public void eliminarFuncionario(String id) throws Exception {
		try {
			String proceso = "{call pkFuncionarioNivel1.pEliminar(?)}";
			CallableStatement c = connection.prepareCall(proceso);
			c.setString(1, id);
			
			c.execute();
		} catch (SQLException e) {
			throw new Exception("Error al efectuar la operacion");

		} catch (Exception a) {
			throw new Exception(a.getMessage());

		}	
	}
	
	public void eliminarEstado(String id) throws Exception {
		try {
			String proceso = "{call pkEstadoNivel1.pEliminar(?)}";
			CallableStatement c = connection.prepareCall(proceso);
			c.setString(1, id);
			
			c.execute();
		} catch (SQLException e) {
			throw new Exception("Error al efectuar la operacion");

		} catch (Exception a) {
			throw new Exception(a.getMessage());

		}	
	}
	
	public void eliminarProducto(String id) throws Exception {
		try {
			String proceso = "{call pkproductonivel1.peliminar(?)}";
			CallableStatement c = connection.prepareCall(proceso);
			c.setString(1, id);
			
			c.execute();
		} catch (SQLException e) {
			throw new Exception("Error al efectuar la operacion");

		} catch (Exception a) {
			throw new Exception(a.getMessage());

		}	
	}
		
	public static void main(String[] args) {
		try {
			SistemaGestion s = new SistemaGestion();
			
		
			//s.atenderSolicitud("1061816906", "1", "Uis", "2");
//			s.registrarSolicitud( Davila","1111111111","El escondite","222",new Date(1981,12,23));

			System.out.println("Exito");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
}
