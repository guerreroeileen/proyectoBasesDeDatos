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
			String proceso = "pkatencionn3.patendersolicitud.";
			Statement statement = connection.createStatement();
			String query = "Begin" + proceso + "(" + cedFun + "," + codSol + "," + comentario + "," + estado + ");"
					+ "End";
			ResultSet resp = statement.executeQuery(query);
			String re = resp.getString(1);
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
}
