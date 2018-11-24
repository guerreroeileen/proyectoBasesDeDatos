create or replace PACKAGE pkEstadoNivel1 IS 

    PROCEDURE pInsertar(ivCodigo IN VARCHAR2, ivNombre IN VARCHAR2);

    PROCEDURE pEliminar(ivCodigo IN VARCHAR2);

    PROCEDURE pModificar(ivCodigo IN VARCHAR2, ivNombre IN VARCHAR2);

    FUNCTION fConsultar(ivCodigo IN VARCHAR2) RETURN ESTADO%rowtype;

    FUNCTION fConsultarPorNombre(ivNombre IN VARCHAR2) RETURN ESTADO%rowtype;

END pkEstadoNivel1;

/

create or replace PACKAGE BODY pkEstadoNivel1 IS 
-- Insertar
  PROCEDURE pInsertar(ivCodigo IN VARCHAR2, ivNombre IN VARCHAR2) IS
    BEGIN
    INSERT INTO ESTADO
    VALUES (ivCodigo, ivNombre);
    
        EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
        RAISE_APPLICATION_ERROR(-20001,'Error, este estado ya existe.');
        WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);
    END pInsertar;

  --Eliminar
  
   PROCEDURE pEliminar(ivCodigo IN VARCHAR2) IS
    BEGIN
    DELETE FROM ESTADO S WHERE S.codigo = ivCodigo;
     EXCEPTION
        WHEN NO_DATA_FOUND THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error, no existe un estado con ese codigo.');
        WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);
  END pEliminar;
  
    -- Actualizar
  PROCEDURE pModificar(ivCodigo IN VARCHAR2, ivNombre IN VARCHAR2) IS
    BEGIN
    UPDATE ESTADO 
    SET  codigo=ivCodigo ,Nombre=ivNombre
    WHERE codigo=ivCodigo ;
    
    EXCEPTION
        WHEN NO_DATA_FOUND THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error, no existe un estado con ese codigo.');
        WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);
        
  END pModificar;

    --OBTENER
  FUNCTION fConsultar(ivCodigo IN VARCHAR2) RETURN ESTADO%rowtype
    IS ovEstado ESTADO%rowtype;
    BEGIN
        SELECT * into ovEstado
        FROM ESTADO
        WHERE codigo=ivCodigo ;
        
        EXCEPTION
            WHEN NO_DATA_FOUND THEN 
            RAISE_APPLICATION_ERROR(-20001,'Error, no existe un estado con ese codigo.');
            WHEN OTHERS THEN 
            RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);
        
    END fConsultar;

 FUNCTION fConsultarPorNombre(ivNombre IN VARCHAR2) RETURN ESTADO%rowtype
    IS ovEstado ESTADO%rowtype;
    BEGIN
        SELECT * into ovEstado
        FROM ESTADO
        WHERE Nombre=ivNombre ;
        
        EXCEPTION
            WHEN NO_DATA_FOUND THEN 
            RAISE_APPLICATION_ERROR(-20001,'Error, no existe un estado con ese codigo.');
            WHEN OTHERS THEN 
            RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);
        
    END fConsultarPorNombre;

  END pkEstadoNivel1;
