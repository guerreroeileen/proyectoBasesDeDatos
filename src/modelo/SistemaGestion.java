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
	public static void main(String[] args) {
		try {
			SistemaGestion s = new SistemaGestion();

			s.atenderSolicitud("1061816906", "2", "Uis", "2");
			System.out.println("Exito");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
}
