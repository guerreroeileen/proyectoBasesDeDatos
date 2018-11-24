package modelo;

public class Main {
	public static void main(String[] args) {
		try {
			SistemaGestion s = new SistemaGestion();

			s.atenderSolicitud("1061816906", "2", "Uis", "2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}
}
