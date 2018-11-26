
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
	public static void main(String[] args) {
		try {
			SistemaGestion s = new SistemaGestion();
	
			//s.atenderSolicitud("1061816906", "1", "Uis", "2");
			System.out.println("Exito");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
}
