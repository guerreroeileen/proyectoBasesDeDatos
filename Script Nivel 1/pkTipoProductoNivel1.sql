CREATE OR REPLACE PACKAGE pktipoproducto IS
    PROCEDURE pinsertar (
        vidtipoprod       IN VARCHAR2,
        vnombretipoprod   IN VARCHAR2,
        vdescripcion      IN VARCHAR2
    );

    PROCEDURE peliminar (
        vidtipoproducto IN VARCHAR2
    );

    PROCEDURE pmodificar (
        vidtipoprod       IN VARCHAR2,
        vnombretipoprod   IN VARCHAR2,
        vdescripcion      IN VARCHAR2
    );

    FUNCTION fconsultar (
        vidtipoprod IN VARCHAR2
    ) RETURN tipoproducto%rowtype;

END pktipoproducto;
/

CREATE OR REPLACE PACKAGE BODY pktipoproducto IS

    PROCEDURE pinsertar (
        vidtipoprod       IN VARCHAR2,
        vnombretipoprod   IN VARCHAR2,
        vdescripcion      IN VARCHAR2
    ) IS
    BEGIN
        INSERT INTO tipoproducto VALUES (
            vidtipoprod,
            vnombretipoprod,
            vdescripcion
        );

    EXCEPTION
        WHEN dup_val_on_index THEN
            raise_application_error(-20001,'El id esta duplicado');
        WHEN OTHERS THEN
            raise_application_error(-20001,'Error'
                                            || sqlerrm
                                            || sqlcode);
    END pinsertar;

    PROCEDURE peliminar (
        vidtipoproducto IN VARCHAR2
    ) IS
    BEGIN
        DELETE FROM tipoproducto tp
        WHERE
            tp.id = vidtipoproducto;

    EXCEPTION
        WHEN no_data_found THEN
            raise_application_error(-20001,'El ID que se quiere eliminar no existe');
        WHEN OTHERS THEN
            raise_application_error(-20001,'Error'
                                            || sqlerrm
                                            || sqlcode);
    END peliminar;

    PROCEDURE pmodificar (
        vidtipoprod       IN VARCHAR2,
        vnombretipoprod   IN VARCHAR2,
        vdescripcion      IN VARCHAR2
    ) IS
    BEGIN
        UPDATE tipoproducto tp
        SET
            tp.nombre = vnombretipoprod,
            tp.descripcion = vdescripcion
        WHERE
            tp.id = vidtipoprod;

    EXCEPTION
        WHEN no_data_found THEN
            raise_application_error(-20001,'El ID que se quiere modificar no existe');
        WHEN OTHERS THEN
            raise_application_error(-20001,'Error'
                                            || sqlerrm
                                            || sqlcode);
    END pmodificar;

    FUNCTION fconsultar (
        vidtipoprod IN VARCHAR2
    ) RETURN tipoproducto%rowtype IS
        rowtp   tipoproducto%rowtype;
    BEGIN
        SELECT
            *
        INTO rowtp
        FROM
            tipoproducto tp
        WHERE
            tp.id = vidtipoprod;

        RETURN rowtp;
    EXCEPTION
        WHEN no_data_found THEN
            raise_application_error(-20001,'El ID que se quiere consultar no existe');
        WHEN OTHERS THEN
            raise_application_error(-20001,'Error'
                                            || sqlerrm
                                            || sqlcode);
    END fconsultar;

END pktipoproducto;