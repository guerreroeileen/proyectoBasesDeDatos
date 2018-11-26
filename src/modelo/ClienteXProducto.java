package modelo;

import java.sql.Date;

public class ClienteXProducto {
	
	  private String cliente_cc;     
      private String producto;       
      private Date fecha_inicio;   
      private Date fecha_fin;
	
      public ClienteXProducto(String cliente_cc, String producto, Date fecha_inicio, Date fecha_fin) {
		super();
		this.cliente_cc = cliente_cc;
		this.producto = producto;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
	}

	public String getCliente_cc() {
		return cliente_cc;
	}

	public void setCliente_cc(String cliente_cc) {
		this.cliente_cc = cliente_cc;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
      
      
      
}
