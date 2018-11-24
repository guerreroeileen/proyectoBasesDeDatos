create or replace PACKAGE pkRegistroNivel2 AS

PROCEDURE pRegistrarEstado (ivCodigo IN VARCHAR2, ivNombre IN VARCHAR2); 
PROCEDURE pRegistrarFuncionario(ivCedula IN VARCHAR2, ivNombre IN VARCHAR2, ivDireccion IN VARCHAR2,  ivTelefono IN VARCHAR2, ivFechaNacimiento IN DATE);
PROCEDURE pRegistrarAnomalia(ivNombre IN VARCHAR2, ivId IN VARCHAR2);
PROCEDURE pRegistrarCliente(ivCedula IN VARCHAR2, ivNombre IN VARCHAR2, ivFechaNacimiento IN VARCHAR2, ivDireccion IN VARCHAR, ivTelefono IN VARCHAR2);
PROCEDURE pRegistrarProducto(ivIdProducto IN VARCHAR2, ivNombre IN VARCHAR2, ivTipo_prod_id IN VARCHAR2);
PROCEDURE pRSolicitud(idSolicitud IN VARCHAR2, cedula IN VARCHAR2,observacion IN VARCHAR2,tipoSolicitud IN VARCHAR2, idProducto IN VARCHAR2);

/

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

PROCEDURE pRegistrarCliente(ivCedula IN VARCHAR2, ivNombre IN VARCHAR2, ivFechaNacimiento IN VARCHAR2, ivDireccion IN VARCHAR, ivTelefono IN VARCHAR2)
    
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
    
PROCEDURE prsolicitud (
        tipoproducto     VARCHAR2,
        cedula           VARCHAR2,
        observacion      VARCHAR2,
        tiposolicitud    VARCHAR2,
        idproducto       VARCHAR2,
        ivcausa          VARCHAR2,
        nombreanomalia   VARCHAR2
    ) IS

        fechaasignacion         DATE;
        fechaatencion           DATE;
        estadocodigo            VARCHAR2;
        funcionariocedula       VARCHAR2;
        comentariofuncionario   VARCHAR2;
        cliente                 cliente%rowtype;
        numerosolicitud         solicitud.n_solicitud%TYPE;
        tiposolici              VARCHAR2;
    BEGIN
-- tienen que ver donde va ese metodo creado por jaiver y kevin
        numerosolicitud := sequence_id_solicitud.nextval;
        fechaasignacion := SYSDATE;
        estadocodigo := 'En_espera';
        fechaatencion := NULL;
        funcionariocedula := NULL;
        anomaliaid := nombreanomalia;
        comentariofuncionario := NULL;
        cliente := pkclientenivel1.fconsultar(cedula);
        tiposolici := pktiposolicitudn1.fconsultar(tiposolicitud);
        CASE tiposolici.nombre
            WHEN 'nuevoproducto' THEN
                causa := NULL;
                anomaliaid := NULL;
                pk_solicitud_n1.pinsertar(numerosolicitud,observacion,fechaasignacion,fechatencion,causa,comentariofuncionario,cedula
               ,estadocodigo,funcionariocedula,anomaliaid,tiposolici,idproducto);

            WHEN 'retiro' THEN
                anomaliaid := NULL;
                observacion := NULL;
                pk_solicitud_n1.pinsertar(numerosolicitud,observacion,fechaasignacion,fechatencion,causa,comentariofuncionario,cedula
               ,estadocodigo,funcionariocedula,anomaliaid,tiposolici,idproducto);

            WHEN 'danos' THEN
                causa := NULL;
                pk_solicitud_n1.pinsertar(numerosolicitud,observacion,fechaasignacion,fechatencion,causa,comentariofuncionario,cedula
               ,estadocodigo,funcionariocedula,anomaliaid,tiposolici,idproducto);

            WHEN 'reclamos' THEN
                causa := NULL;
                anomaliaid := NULL;
                pk_solicitud_n1.pinsertar(numerosolicitud,observacion,fechaasignacion,fechatencion,causa,comentariofuncionario,cedula
               ,estadocodigo,funcionariocedula,anomaliaid,tiposolici,idproducto);

            WHEN 'modificacion' THEN
                pk_solicitud_n1.pinsertar(numerosolicitud,observacion,fechaasignacion,fechatencion,causa,comentariofuncionario,cedula
               ,estadocodigo,funcionariocedula,anomaliaid,tiposolici,idproducto);
        END CASE;

    EXCEPTION
        WHEN other THEN
            raise_application_error(-20201,' no esta registrado');
    END prsolicitud;
  
  END pkRegistroNivel2;
