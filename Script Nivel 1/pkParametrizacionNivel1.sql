CREATE OR REPLACE PACKAGE pkParametrizacion IS

PROCEDURE pInsertar(vIdentificador in  NUMBER, vintervaloAtencion in NUMBER, vnumeroSolicitudesFuncionario in NUMBER);
PROCEDURE pEliminar(vIdentificador in  NUMBER);
PROCEDURE pModificar(vIdentificador in  NUMBER, vintervaloAtencion in NUMBER, vnumeroSolicitudesFuncionario in NUMBER);
FUNCTION pConsultar(vIdentificador in  NUMBER) RETURN parametrizacion%rowtype;

END pkParametrizacion;

CREATE OR REPLACE PROCEDURE pInsertar
(vIdentificador in  NUMBER, vintervaloAtencion in NUMBER, vnumeroSolicitudesFuncionario in NUMBER)IS
BEGIN
    INSERT INTO PARAMETRIZACION VALUES(vIdentificador,vintervaloAtencion,vnumeroSolicitudesFuncionario);

    EXCEPTION 
    WHEN DUP_VAL_ON_INDEX THEN
    RAISE_APPLICATION_ERROR(-20001,'El id esta duplicado');
    WHEN OTHERS THEN
    RAISE_APPLICATION_ERROR(-20001,'Error'||SQLERRM||SQLCODE);
END pInsertar;

CREATE OR REPLACE PROCEDURE pEliminar
(vIdentificador in  NUMBER) IS
BEGIN
DELETE FROM PARAMETRIZACION TP
WHERE TP.Identificador=vIdentificador;

EXCEPTION
WHEN NO_DATA_FOUND THEN
RAISE_APPLICATION_ERROR(-20001,'El ID que se quiere eliminar no existe');
WHEN OTHERS THEN
RAISE_APPLICATION_ERROR(-20001,'Error'||SQLERRM||SQLCODE);
END pEliminar;

CREATE OR REPLACE PROCEDURE pModificar
(vIdentificador in  NUMBER, vintervaloAtencion in NUMBER, vnumeroSolicitudesFuncionario in NUMBER) IS
BEGIN
UPDATE PARAMETRIZACION TP
SET
TP.Identificador=vIdentificador,
TP.intervaloAtencion=vintervaloAtencion,
TP.numeroSolicitudesFuncionario=vnumeroSolicitudesFuncionario
WHERE TP.Identificador=vIdentificador;

EXCEPTION
WHEN NO_DATA_FOUND THEN
RAISE_APPLICATION_ERROR(-20001,'El ID que se quiere modificar no existe');
WHEN OTHERS THEN
RAISE_APPLICATION_ERROR(-20001,'Error'||SQLERRM||SQLCODE);
END pModificar;

CREATE OR REPLACE FUNCTION  pConsultar
(vIdentificador in VARCHAR)
RETURN PARAMETRIZACION%rowtype IS 
rowTP PARAMETRIZACION%rowtype;
BEGIN 
SELECT*INTO rowTP
FROM PARAMETRIZACION TP
WHERE TP.Identificador=vIdentificador;

EXCEPTION
WHEN NO_DATA_FOUND THEN
RAISE_APPLICATION_ERROR(-20001,'El ID que se quiere consultar no existe');
WHEN OTHERS THEN
RAISE_APPLICATION_ERROR(-20001,'Error'||SQLERRM||SQLCODE);
END pConsultar;


