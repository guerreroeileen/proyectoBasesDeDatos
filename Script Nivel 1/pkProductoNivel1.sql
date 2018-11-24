CREATE OR REPLACE PACKAGE pkProductoNivel1 IS

PROCEDURE  pInsertar (ivIdProducto IN VARCHAR2, ivNombre IN VARCHAR2, ivTipo_prod_id IN VARCHAR2);
PROCEDURE  pEliminar (ivIdProducto IN VARCHAR2);
FUNCTION  fConsultar (ivIdProducto IN VARCHAR2) RETURN oPRODUCTO%rowtype;
PROCEDURE  pModificar (vIdProducto IN VARCHAR2, vNombre IN VARCHAR2, vTipo_prod_id IN VARCHAR2);
END pkProdutoNivel1;

/
CREATE OR REPLACE PROCEDURE  pInsertar (ivIdProducto IN VARCHAR2, ivNombre IN VARCHAR2, ivTipo_prod_id IN VARCHAR2) IS
BEGIN
    INSERT INTO PRODUCTO VALUES(ivIdProducto,ivNombre,ivTipo_prod_id);
    
    EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
    RAISE_APPLICATION_ERROR(-20001,'El id esta duplicado.');
    WHEN OTHERS THEN 
    RAISE_APPLICATION_ERROR(-20001,'ERROR'||SQLERRM||SQLCODE);
    
END pInsertar;

/
CREATE OR REPLACE PROCEDURE  pEliminar (ivIdProducto IN VARCHAR2) IS
BEGIN
    DELETE FROM PRODUCTO vProducto
    WHERE vProducto.ID=ivIdProducto;
    
    EXCEPTION 
    WHEN NO_DATA_FOUND THEN
    RAISE_APPLICATION_ERROR(-20001,'El id a eliminar no existe.');
    WHEN OTHERS THEN 
    RAISE_APPLICATION_ERROR(-20001,'ERROR'||SQLERRM||SQLCODE);
    
END pEliminar;

FUNCTION  fConsultar (ivIdProducto IN VARCHAR2) RETURN oPRODUCTO%rowtype IS rowProducto PRODUCTO%rowtype;
BEGIN
    SELECT * INTO rowProducto
    FROM PRODUCTO vProducto
    WHERE vProducto.ID=ivIdProducto;
    
    EXCEPTION
    WHEN NO_DATA_FOUND THEN 
    RAISE_APPLICATION_ERROR(-20001,'El id a consultar no existe.');
    WHEN OTHERS THEN 
    RAISE_APPLICATION_ERROR(-20001,'ERROR'||SQLERRM||SQLCODE);
    
END fConsultar;

/
CREATE OR REPLACE PROCEDURE  pModificar (vIdProducto IN VARCHAR2, vNombre IN VARCHAR2, vTipo_prod_id IN VARCHAR2) IS
BEGIN
    UPDATE PRODUCTO P
    SET
    P.NOMBRE=vNombre, P.TIPOPRODUCTO_ID=vTipo_prod_id
    WHERE P.ID=vIdProducto;
    
    EXCEPTION
    WHEN NO_DATA_FOUND THEN 
    RAISE_APPLICATION_ERROR(-20001,'El producto a consultar no existe.');
    WHEN OTHERS THEN 
    RAISE_APPLICATION_ERROR(-20001,'ERROR'||SQLERRM||SQLCODE);
    
END pModificar;