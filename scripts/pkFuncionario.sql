create or replace PACKAGE pkFuncionarioNivel1 IS 

    PROCEDURE pInsertar(ivCedula IN VARCHAR2, ivNombre IN VARCHAR2, ivDireccion IN VARCHAR2,  ivTelefono IN VARCHAR2, ivFechaNacimiento IN DATE);

    PROCEDURE pEliminar(ivCedula IN VARCHAR2);

    PROCEDURE pModificar(ivCedula IN VARCHAR2, ivNombre IN VARCHAR2, ivDireccion IN VARCHAR2,  ivTelefono IN VARCHAR2, ivFechaNacimiento IN DATE);

    FUNCTION fConsultar(ivCedula IN VARCHAR2) RETURN FUNCIONARIO%rowtype;

END pkFuncionarioNivel1;

/

create or replace PACKAGE BODY pkFuncionarioNivel1 IS 
-- Insertar
  PROCEDURE pInsertar(ivCedula IN VARCHAR2, ivNombre IN VARCHAR2, ivDireccion IN VARCHAR2,  ivTelefono IN VARCHAR2, ivFechaNacimiento IN DATE) IS
    BEGIN
    INSERT INTO FUNCIONARIO
    VALUES (ivCedula, ivNombre , ivDireccion, ivTelefono, ivFechaNacimiento);
    
        EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
        RAISE_APPLICATION_ERROR(-20001,'Error, este registro ya existe.');
        WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);
    END pInsertar;

  --Eliminar
  
   PROCEDURE pEliminar(ivCedula IN VARCHAR2) IS
    BEGIN
    DELETE FROM FUNCIONARIO S WHERE S.cedula = ivCedula;
     EXCEPTION
        WHEN NO_DATA_FOUND THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error, no existe un funcionario con ese número de cedula.');
        WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);
  END pEliminar;
  
    -- Actualizar
  PROCEDURE pModificar(ivCedula IN VARCHAR2, ivNombre IN VARCHAR2, ivDireccion IN VARCHAR2,  ivTelefono IN VARCHAR2, ivFechaNacimiento IN DATE) IS
    BEGIN
    UPDATE FUNCIONARIO 
    SET  cedula=ivCedula ,Nombre=ivNombre, fechaNacimiento= ivFechaNacimiento, direccion=ivDireccion, telefono= ivTelefono
    WHERE cedula=ivCedula;
    
    EXCEPTION
        WHEN NO_DATA_FOUND THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error,  no existe un funcionario con ese número de cedula.');
        WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);
        
  END pModificar;

    --OBTENER
  FUNCTION fConsultar(ivCedula IN VARCHAR2) RETURN FUNCIONARIO%rowtype
    IS ovFuncionario FUNCIONARIO%rowtype;
    BEGIN
        SELECT * into ovFuncionario
        FROM FUNCIONARIO
        WHERE cedula=ivCedula;
        
        EXCEPTION
            WHEN NO_DATA_FOUND THEN 
            RAISE_APPLICATION_ERROR(-20001,'Error, no existe un funcionario con ese número de cedula.');
            WHEN OTHERS THEN 
            RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);
        
    END fConsultar;

  END pkFuncionarioNivel1;
