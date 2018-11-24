create or replace PACKAGE pkRegistroNivel2 AS

PROCEDURE pRegistrarEstado (ivCodigo IN VARCHAR2, ivNombre IN VARCHAR2); 
PROCEDURE pRegistrarFuncionario(ivCedula IN VARCHAR2, ivNombre IN VARCHAR2, ivDireccion IN VARCHAR2,  ivTelefono IN VARCHAR2, ivFechaNacimiento IN DATE);
PROCEDURE pRegistrarAnomalia(ivNombre IN VARCHAR2, ivId IN VARCHAR2);
PROCEDURE pRegistrarCliente(ivCedula VARCHAR2, ivNombre VARCHAR2, ivFechaNacimiento VARCHAR2, ivDireccion VARCHAR, ivTelefono VARCHAR2);
PROCEDURE pRegistrarProducto(ivIdProducto IN VARCHAR2, ivNombre IN VARCHAR2, ivTipo_prod_id IN VARCHAR2);
PROCEDURE pRSolicitud(idSolicitud VARCHAR2, cedula VARCHAR2,observacion VARCHAR2,tipoSolicitud VARCHAR2, idProducto VARCHAR2);
PROCEDURE pModificarSolicitud(ivIDSolicitud VARCHAR2, ivTipoProducto VARCHAR2, ivCodProducto VARCHAR2 );
END pkRegistroNivel2;

CREATE OR REPLACE PACKAGE BODY pkRegistroNivel2 AS

PROCEDURE pRegistrarFuncionario(ivCedula IN VARCHAR2, ivNombre IN VARCHAR2, ivDireccion IN VARCHAR2,  ivTelefono IN VARCHAR2, ivFechaNacimiento IN DATE)
  IS
  BEGIN 
      pkFuncionarioNivel1.PINSERTAR(ivCedula, ivNombre, ivDireccion, ivTelefono , ivFechaNacimiento);
  EXCEPTION
  WHEN OTHERS THEN
  RAISE_APPLICATION_ERROR(-20001, 'Error al insertar en la tabla Funcionario'||SQLCODE);
  END pRegistrarFuncionario;
  
  PROCEDURE pRegistrarEstado(ivCodigo IN VARCHAR2, ivNombre IN VARCHAR2)
  IS
  BEGIN 
      pkEstadoNivel1.PINSERTAR(ivCodigo, ivNombre);
  EXCEPTION
  WHEN OTHERS THEN
  RAISE_APPLICATION_ERROR(-20001, 'Error al insertar en la tabla Funcionario'||SQLCODE);
  END pRegistrarEstado;
  
  PROCEDURE pRegistrarProducto(ivIdProducto IN VARCHAR2, ivNombre IN VARCHAR2, ivTipo_prod_id IN VARCHAR2)is
  begin
  pkProductoNivel1.pInsertar (ivIdProducto, ivNombre, ivTipo_prod_id);
  
EXCEPTION
  WHEN OTHERS THEN
  RAISE_APPLICATION_ERROR(-20000, 'Error al insertar en la tabla Producto'||SQLCODE);
  END pRegistrarEstado;
  
  PROCEDURE pRegistrarAnomalia(ivNombre IN VARCHAR2, ivId IN VARCHAR2)

    IS

    BEGIN
    -- Utiliza el metodo de insertar del nivel 1 correspondiente a anomalia para insertarla
    pkAnomaliaNivel1.pInsertar(ivNombre , ivId );
    
    EXCEPTION
    
	WHEN DUP_VAL_ON_INDEX THEN
    
        RAISE_APPLICATION_ERROR(-20001,'El id esta duplicado.');
        
	WHEN OTHERS THEN
    
        RAISE_APPLICATION_ERROR(-20001,'Error'||SQLERRM||SQLCODE);
    

END pRegistrarAnomalia;

PROCEDURE pRegistrarCliente(ivCedula VARCHAR2, ivNombre VARCHAR2, ivFechaNacimiento VARCHAR2, ivDireccion VARCHAR, ivTelefono VARCHAR2)
    
    IS
    
    BEGIN
    
    pkClienteNivel1.pInsertar(ivCedula , ivNombre , ivFechaNacimiento , ivDireccion , ivTelefono );
    
    EXCEPTION
    -- copie las mismas excepciones de la capa 1
	WHEN DUP_VAL_ON_INDEX THEN
    
        RAISE_APPLICATION_ERROR(-20001,'El id esta duplicado.');
    
	WHEN OTHERS THEN
    
        RAISE_APPLICATION_ERROR(-20001,'Unknown Error'||SQLERRM||SQLCODE);
    
    END pRegistrarCliente;
    
PROCEDURE pRSolicitud(tipoProducto VARCHAR2, cedula VARCHAR2,observacion VARCHAR2,tipoSolicitud VARCHAR2, idProducto VARCHAR2
, ivCausa VARCHAR2, nombreAnomalia VARCHAR2) IS

fechaAsignacion DATE;
fechaAtencion DATE;
estadoCodigo VARCHAR2;
funcionarioCedula VARCHAR2;
comentarioFuncionario VARCHAR2;
Cliente Cliente%rowType;
numeroSolicitud Solicitud.N_solicitud%type;
tipoSolici VARCHAR2;

BEGIN
-- tienen que ver donde va ese metodo creado por jaiver y kevin
numeroSolicitud := sequence_id_solicitud.nextval;
fechaAsignacion := sysdate;
estadoCodigo := 'En_espera';
fechaAtencion := null;
funcionarioCedula := null;
anomaliaID := nombreAnomalia;
comentarioFuncionario := null;

cliente:= pkClienteNivel1.fConsultar(cedula);
tipoSolici := pktiposolicitudn1.fconsultar(tipoSolicitud);


CASE tipoSolici.nombre
WHEN 'nuevoproducto' THEN
causa := null;
anomaliaID := null;
pk_solicitud_n1.pinsertar(numeroSolicitud,observacion,fechaAsignacion,fechAtencion,causa,comentarioFuncionario,cedula,estadoCodigo,funcionarioCedula,anomaliaID,tipoSolici,idProducto);
WHEN 'retiro' THEN
anomaliaID := null;
observacion := null;
pk_solicitud_n1.pinsertar(numeroSolicitud,observacion,fechaAsignacion,fechAtencion,causa,comentarioFuncionario,cedula,estadoCodigo,funcionarioCedula,anomaliaID,tipoSolici,idProducto);
WHEN 'danos' THEN 
causa := null;
pk_solicitud_n1.pinsertar(numeroSolicitud,observacion,fechaAsignacion,fechAtencion,causa,comentarioFuncionario,cedula,estadoCodigo,funcionarioCedula,anomaliaID,tipoSolici,idProducto);
WHEN 'reclamos' THEN 
causa := null;
anomaliaID := null;
pk_solicitud_n1.pinsertar(numeroSolicitud,observacion,fechaAsignacion,fechAtencion,causa,comentarioFuncionario,cedula,estadoCodigo,funcionarioCedula,anomaliaID,tipoSolici,idProducto);

END CASE;

Exception When other then

raise_application_error(-20201,' no esta registrado');

END pRSolicitud;



PROCEDURE pModificarSolicitud(ivIDSolicitud VARCHAR2, ivTipoProducto VARCHAR2, ivCodProducto VARCHAR2 )
IS 
BEGIN
pk_solicitud_n1.pmodificarproducto(ivIDSolicitud,ivTipoProducto);

EXCEPTION
WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20001,'La solicitud que se quiere modificar no existe.');

END pModificarSolicitud;
  
  END pkRegistroNivel2;
