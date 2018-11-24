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
			String proceso = "ret:=pkatencionn3.fatendersolicitud";
			Statement statement = connection.createStatement();
			String decl="DECLARE ret VARCHAR2(200); ";
			String query = decl+"Begin " + proceso + "('" + cedFun + "','" + codSol + "','" + comentario + "','" + estado + "');"
					+ " End;";
			ResultSet resp = statement.executeQuery(query);
			String re = resp.getString(0);
			if (re.equals("0")) {
				return true;
			} else {
				throw new Exception(re);
			}
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
