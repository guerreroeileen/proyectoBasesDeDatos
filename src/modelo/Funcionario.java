package modelo;

import java.sql.Date;

public class Funcionario {

	private String ivcedula;            
    private String ivnombre;            
    private String ivdireccion;         
    private String ivtelefono;
    private Date ivfechanacimiento;
	
    public Funcionario(String ivcedula, String ivnombre, String ivdireccion, String ivtelefono, Date ivfechanacimiento) {
		super();
		this.ivcedula = ivcedula;
		this.ivnombre = ivnombre;
		this.ivdireccion = ivdireccion;
		this.ivtelefono = ivtelefono;
		this.ivfechanacimiento = ivfechanacimiento;
	}

	public String getIvcedula() {
		return ivcedula;
	}

	public void setIvcedula(String ivcedula) {
		this.ivcedula = ivcedula;
	}

	public String getIvnombre() {
		return ivnombre;
	}

	public void setIvnombre(String ivnombre) {
		this.ivnombre = ivnombre;
	}

	public String getIvdireccion() {
		return ivdireccion;
	}

	public void setIvdireccion(String ivdireccion) {
		this.ivdireccion = ivdireccion;
	}

	public String getIvtelefono() {
		return ivtelefono;
	}

	public void setIvtelefono(String ivtelefono) {
		this.ivtelefono = ivtelefono;
	}

	public Date getIvfechanacimiento() {
		return ivfechanacimiento;
	}

	public void setIvfechanacimiento(Date ivfechanacimiento) {
		this.ivfechanacimiento = ivfechanacimiento;
	}   
    
    
}
