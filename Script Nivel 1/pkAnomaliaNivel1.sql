CREATE OR REPLACE PACKAGE pkanomalianivel1 IS
    PROCEDURE pinsertar (
        nombre   IN VARCHAR2,
        id       IN VARCHAR2
    );

    PROCEDURE pmodificar (
        nombre   IN VARCHAR2,
        id       IN VARCHAR2
    );

    PROCEDURE peliminar (
        id IN VARCHAR2
    );

    FUNCTION fconsultar (
        id IN VARCHAR2
    ) RETURN anomalia%rowtype;

END pkanomalianivel1;
/

CREATE OR REPLACE PACKAGE BODY pkanomalianivel1 IS 



--INSERTAR

    PROCEDURE pinsertar (
        nombre VARCHAR2,
        id VARCHAR2
    ) IS
    BEGIN
        INSERT INTO anomalia VALUES (
            id,
            nombre
        );

    EXCEPTION
        WHEN dup_val_on_index THEN
            raise_application_error(-20001,'El id esta duplicado.');
        WHEN OTHERS THEN
            raise_application_error(-20001,'Error'
                                            || sqlerrm
                                            || sqlcode);
    END pinsertar;

--MODIFICAR

    PROCEDURE pmodificar (
        nombre VARCHAR2,
        id VARCHAR2
    ) IS
    BEGIN
        UPDATE anomalia a
        SET
            a.nombre = nombre
        WHERE
            a.id = id;

    EXCEPTION
        WHEN no_data_found THEN
            raise_application_error(-20001,'El ID que se quiere modificar no existe.');
        WHEN OTHERS THEN
            raise_application_error(-20001,'Error'
                                            || sqlerrm
                                            || sqlcode);
    END pmodificar;

--ELIMINAR

    PROCEDURE peliminar (
        id VARCHAR2
    ) IS
    BEGIN
        DELETE FROM anomalia
        WHERE
            anomalia.id = id;

    EXCEPTION
        WHEN no_data_found THEN
            raise_application_error(-20001,'El ID que se quiere eliminar no existe.');
        WHEN OTHERS THEN
            raise_application_error(-20001,'Error'
                                            || sqlerrm
                                            || sqlcode);
    END peliminar;
--CONSULTAR

    FUNCTION fconsultar (
        id VARCHAR2
    ) RETURN anomalia%rowtype IS
        rowanomalia   anomalia%rowtype;
    BEGIN
        SELECT
            *
        INTO rowanomalia
        FROM
            anomalia
        WHERE
            anomalia.id = id;

    EXCEPTION
        WHEN no_data_found THEN
            raise_application_error(-20001,'El ID que se quiere modificar no existe.');
        WHEN OTHERS THEN
            raise_application_error(-20001,'Error'
                                            || sqlerrm
                                            || sqlcode);
    END fconsultar;

END pkanomalianivel1;