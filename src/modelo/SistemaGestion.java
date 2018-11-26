
package modelo;

import java.sql.*;

public class SistemaGestion {
	private Connection connection;

	public SistemaGestion() throws Exception {
		try {
			connection = ConectionBD.getConection();
		} catch (Exception e) {
			throw new Exception("Error al conectarse a la base de datos");
		}
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
//			s.registrarSolicitud( Davila","1111111111","El escondite","222",new Date(1981,12,23));
			System.out.println("Exito");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
}
