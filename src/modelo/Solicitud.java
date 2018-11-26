package modelo;

import java.sql.Date;

public class Solicitud {

   	private String n_solicitud  ;           
   	private String observaciones;       
   	private Date fechaasignacion;     
   	private Date fechaatencion;       
   	private String causa;                
   	private String comentariofuncionario;   
   	private String cliente_cedula;           
   	private String estado_codigo;        
   	private String funcionariocedula;     
   	private String anomalia_id;             
   	private String tiposolicitud_id ;        
   	private String producto_id ;
	
    public Solicitud(String n_solicitud, String observaciones, Date fechaasignacion, Date fechaatencion, String causa,
			String comentariofuncionario, String cliente_cedula, String estado_codigo, String funcionariocedula,
			String anomalia_id, String tiposolicitud_id, String producto_id) {
		super();
		this.n_solicitud = n_solicitud;
		this.observaciones = observaciones;
		this.fechaasignacion = fechaasignacion;
		this.fechaatencion = fechaatencion;
		this.causa = causa;
		this.comentariofuncionario = comentariofuncionario;
		this.cliente_cedula = cliente_cedula;
		this.estado_codigo = estado_codigo;
		this.funcionariocedula = funcionariocedula;
		this.anomalia_id = anomalia_id;
		this.tiposolicitud_id = tiposolicitud_id;
		this.producto_id = producto_id;
	}

	public String getN_solicitud() {
		return n_solicitud;
	}

	public void setN_solicitud(String n_solicitud) {
		this.n_solicitud = n_solicitud;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Date getFechaasignacion() {
		return fechaasignacion;
	}

	public void setFechaasignacion(Date fechaasignacion) {
		this.fechaasignacion = fechaasignacion;
	}

	public Date getFechaatencion() {
		return fechaatencion;
	}

	public void setFechaatencion(Date fechaatencion) {
		this.fechaatencion = fechaatencion;
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public String getComentariofuncionario() {
		return comentariofuncionario;
	}

	public void setComentariofuncionario(String comentariofuncionario) {
		this.comentariofuncionario = comentariofuncionario;
	}

	public String getCliente_cedula() {
		return cliente_cedula;
	}

	public void setCliente_cedula(String cliente_cedula) {
		this.cliente_cedula = cliente_cedula;
	}

	public String getEstado_codigo() {
		return estado_codigo;
	}

	public void setEstado_codigo(String estado_codigo) {
		this.estado_codigo = estado_codigo;
	}

	public String getFuncionariocedula() {
		return funcionariocedula;
	}

	public void setFuncionariocedula(String funcionariocedula) {
		this.funcionariocedula = funcionariocedula;
	}

	public String getAnomalia_id() {
		return anomalia_id;
	}

	public void setAnomalia_id(String anomalia_id) {
		this.anomalia_id = anomalia_id;
	}

	public String getTiposolicitud_id() {
		return tiposolicitud_id;
	}

	public void setTiposolicitud_id(String tiposolicitud_id) {
		this.tiposolicitud_id = tiposolicitud_id;
	}

	public String getProducto_id() {
		return producto_id;
	}

	public void setProducto_id(String producto_id) {
		this.producto_id = producto_id;
	}
    
    
}
