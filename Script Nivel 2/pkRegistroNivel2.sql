create or replace PACKAGE pkRegistroNivel2 AS
--procesos definidos
PROCEDURE pRegistrarEstado (ivCodigo IN VARCHAR2, ivNombre IN VARCHAR2); 
PROCEDURE pRegistrarFuncionario(ivNombre IN VARCHAR2, ivCedula IN VARCHAR2, ivFechaNacimiento IN DATE, ivDireccion IN VARCHAR2,  ivTelefono IN VARCHAR2);
PROCEDURE pRegistrarAnomalia(ivNombre IN VARCHAR2, ivId IN VARCHAR2);
PROCEDURE pRegistrarCliente(ivCedula VARCHAR2, ivNombre VARCHAR2, ivFechaNacimiento VARCHAR2, ivDireccion VARCHAR, ivTelefono VARCHAR2);
PROCEDURE pRegistrarProducto(ivIdProducto IN VARCHAR2, ivNombre IN VARCHAR2, ivTipo_prod_id IN VARCHAR2);
--PROCEDURE pRegistrarSolicitud();

END pkRegistroNivel2;

CREATE OR REPLACE PACKAGE BODY pkRegistroNivel2 AS

PROCEDURE pRegistrarFuncionario(ivNombre IN VARCHAR2, ivCedula IN VARCHAR2, ivFechaNacimiento IN DATE, ivDireccion IN VARCHAR2,  ivTelefono IN VARCHAR2)
  IS
  BEGIN 
      PKFUNCIONARIO.PINSERTAR(ivNombre, ivCedula, ivFechaNacimiento, ivDireccion, ivTelefono);
  EXCEPTION
  WHEN OTHERS THEN
  RAISE_APPLICATION_ERROR(-20000, 'Error al insertar en la tabla Funcionario'||SQLCODE);
  END pRegistrarFuncionario;
  
  PROCEDURE pRegistrarEstado(ivCodigo IN VARCHAR2, ivNombre IN VARCHAR2)
  IS
  BEGIN 
      PKESTADO.PINSERTAR(ivCodigo, ivNombre);
  EXCEPTION
  WHEN OTHERS THEN
  RAISE_APPLICATION_ERROR(-20000, 'Error al insertar en la tabla Funcionario'||SQLCODE);
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
    

  
  END pkRegistroNivel2;
