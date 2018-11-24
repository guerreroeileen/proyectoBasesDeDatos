package modelo;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConectionBD {
	private static Connection connection;
	public static Connection getConection() throws Exception {
		if(connection==null) {
			connection=conectarYConsultarBD();
		}
		return connection;
	}
	private static Connection conectarYConsultarBD() throws Exception {
		String ip="200.3.193.244";
		String puerto="1522";
		String insta="ESTUD";
		String user="P09551_1_10";
		String password=user;
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection contection=DriverManager.getConnection("jdbc:oracle:thin:@"+ip+":"+puerto+":"+insta,user,password);
		return contection;
	}


}
