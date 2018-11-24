create or replace PACKAGE pktiposolicitudn1 IS
    PROCEDURE pinsertar (
        nombre        VARCHAR2,
        ids           VARCHAR2,
        descripcion   VARCHAR2
    );

    PROCEDURE pborrartipo (
        ids VARCHAR2
    );

    PROCEDURE pmodificartipo (
        nombreP        VARCHAR2,
        ids           VARCHAR2,
        descripcionP   VARCHAR2
    );

    FUNCTION fconsultar (
        ids VARCHAR2
    ) RETURN tiposolicitud%rowtype;

END pktiposolicitudn1;
/
create or replace PACKAGE BODY pktiposolicitudn1 AS

    PROCEDURE pinsertar (
        nombre        VARCHAR2,
        ids           VARCHAR2,
        descripcion   VARCHAR2
    ) IS
    BEGIN
        INSERT INTO tiposolicitud VALUES (
            nombre,
            ids,
            descripcion
        );

    END pinsertar;

    PROCEDURE pborrartipo (
        ids VARCHAR2
    ) IS
    BEGIN
        DELETE FROM tiposolicitud t
        WHERE
            t.id = ids;

    END pborrartipo;

    PROCEDURE pmodificartipo (
        nombreP        VARCHAR2,
        ids           VARCHAR2,
        descripcionP   VARCHAR2
    ) IS
    BEGIN
        UPDATE tiposolicitud t
        SET
            t.nombre = nombreP,
            t.descripcion = descripcionP
        WHERE
            t.id = ids;

    END pmodificartipo;

    FUNCTION fconsultar (
        ids VARCHAR2
    ) RETURN tiposolicitud%rowtype IS
        fila   tiposolicitud%rowtype;
    BEGIN
        SELECT
            *
        INTO fila
        FROM
            tiposolicitud t
        WHERE
            t.id = ids;

        RETURN fila;
    END fconsultar;

END pktiposolicitudn1;