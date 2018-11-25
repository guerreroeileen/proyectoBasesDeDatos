CREATE OR REPLACE PACKAGE pkparametrizacion IS
    PROCEDURE pinsertar (
        videntificador                  IN NUMBER,
        vintervaloatencion              IN NUMBER,
        vnumerosolicitudesfuncionario   IN NUMBER
    );

    PROCEDURE peliminar (
        videntificador IN NUMBER
    );

    PROCEDURE pmodificar (
        videntificador                  IN NUMBER,
        vintervaloatencion              IN NUMBER,
        vnumerosolicitudesfuncionario   IN NUMBER
    );

    FUNCTION fconsultar (
        videntificador IN NUMBER
    ) RETURN parametrizacion%rowtype;

END pkparametrizacion;
/

CREATE OR REPLACE PACKAGE BODY pkparametrizacion IS

    PROCEDURE pinsertar (
        videntificador                  IN NUMBER,
        vintervaloatencion              IN NUMBER,
        vnumerosolicitudesfuncionario   IN NUMBER
    ) IS
    BEGIN
        INSERT INTO parametrizacion VALUES (
            videntificador,
            vintervaloatencion,
            vnumerosolicitudesfuncionario
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
        videntificador IN NUMBER
    ) IS
    BEGIN
        DELETE FROM parametrizacion tp
        WHERE
            tp.identificador = videntificador;

    EXCEPTION
        WHEN no_data_found THEN
            raise_application_error(-20001,'El ID que se quiere eliminar no existe');
        WHEN OTHERS THEN
            raise_application_error(-20001,'Error'
                                            || sqlerrm
                                            || sqlcode);
    END peliminar;

    PROCEDURE pmodificar (
        videntificador                  IN NUMBER,
        vintervaloatencion              IN NUMBER,
        vnumerosolicitudesfuncionario   IN NUMBER
    ) IS
    BEGIN
        UPDATE parametrizacion tp
        SET
            tp.identificador = videntificador,
            tp.intervaloatencion = vintervaloatencion,
            tp.numerosolicitudesfuncionario = vnumerosolicitudesfuncionario
        WHERE
            tp.identificador = videntificador;

    EXCEPTION
        WHEN no_data_found THEN
            raise_application_error(-20001,'El ID que se quiere modificar no existe');
        WHEN OTHERS THEN
            raise_application_error(-20001,'Error'
                                            || sqlerrm
                                            || sqlcode);
    END pmodificar;

    FUNCTION fconsultar (
        videntificador IN NUMBER
    ) RETURN parametrizacion%rowtype IS
        rowtp   parametrizacion%rowtype;
    BEGIN
        SELECT
            *
        INTO rowtp
        FROM
            parametrizacion tp
        WHERE
            tp.identificador = videntificador;
    return rowtp;
    EXCEPTION
        WHEN no_data_found THEN
            raise_application_error(-20001,'El ID que se quiere consultar no existe');
        WHEN OTHERS THEN
            raise_application_error(-20001,'Error'
                                            || sqlerrm
                                            || sqlcode);
    END fconsultar;

END pkparametrizacion;