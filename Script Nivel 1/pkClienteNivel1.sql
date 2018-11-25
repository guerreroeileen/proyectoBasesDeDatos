CREATE OR REPLACE PACKAGE pkclientenivel1 AS
    PROCEDURE pinsertar (
        cedula            cliente.cedula%TYPE,
        nombre            cliente.nombre%TYPE,
        fechanacimiento   cliente.fechanac%TYPE,
        direccion         cliente.direccion%TYPE,
        telefono          cliente.telefono%TYPE
    );

    PROCEDURE pmodificar (
        cedula            cliente.cedula%TYPE,
        nombre            cliente.nombre%TYPE,
        fechanacimiento   cliente.fechanac%TYPE,
        direccion         cliente.direccion%TYPE,
        telefono          cliente.telefono%TYPE
    );

    PROCEDURE peliminar (
        cedula cliente.cedula%TYPE
    );

    FUNCTION fconsultar (
        cedula cliente.cedula%TYPE
    ) RETURN cliente%rowtype;

END pkclientenivel1;
/

CREATE OR REPLACE PACKAGE BODY pkclientenivel1 AS

    PROCEDURE pinsertar (
        cedula            cliente.cedula%TYPE,
        nombre            cliente.nombre%TYPE,
        fechanacimiento   cliente.fechanac%TYPE,
        direccion         cliente.direccion%TYPE,
        telefono          cliente.telefono%TYPE
    ) IS
    BEGIN
        INSERT INTO cliente VALUES (
            cedula,
            nombre,
            fechanacimiento,
            direccion,
            telefono
        );

    EXCEPTION
        WHEN OTHERS THEN
            raise_application_error(-2001,'El programa intentó insertar valores duplicados en una columna que está restringida por un índice único'
            );
    END pinsertar;

    PROCEDURE pmodificar (
        cedula            cliente.cedula%TYPE,
        nombre            cliente.nombre%TYPE,
        fechanacimiento   cliente.fechanac%TYPE,
        direccion         cliente.direccion%TYPE,
        telefono          cliente.telefono%TYPE
    ) IS
    BEGIN
        UPDATE cliente c
        SET
            c.nombre = nombre,
            c.fechanac = fechanacimiento,
            c.direccion = direccion,
            c.telefono = telefono
        WHERE
            c.cedula = cedula;

    EXCEPTION
        WHEN OTHERS THEN
            raise_application_error(-2001,'El programa intentó insertar valores duplicados en una columna que está restringida por un índice único'
            );
    END pmodificar;

    PROCEDURE peliminar (
        cedula cliente.cedula%TYPE
    ) IS
    BEGIN
        DELETE FROM cliente c
        WHERE
            c.cedula = cedula;

    END peliminar;

    FUNCTION fconsultar (
        cedula cliente.cedula%TYPE
    ) RETURN cliente%rowtype IS
        rowcliente   cliente%rowtype;
    BEGIN
        SELECT
            *
        INTO rowcliente
        FROM
            cliente c
        WHERE
            c.cedula = cedula;

        RETURN rowcliente;
    EXCEPTION
        WHEN too_many_rows OR invalid_number THEN
            raise_application_error(-2001,'Numero invalido o regresa mas de 1 tupla');
    END fconsultar;

END pkclientenivel1;