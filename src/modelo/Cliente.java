package modelo;

import java.sql.Date;

public class Cliente {

	private String cedula;           
    private String nombre;            
    private Date fechanacimiento;  
    private String direccion;         
    private int telefono;
	
    public Cliente(String cedula, String nombre, String direccion, Date fechanacimiento, int telefono) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.fechanacimiento = fechanacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	} 
    
    	
    
}

