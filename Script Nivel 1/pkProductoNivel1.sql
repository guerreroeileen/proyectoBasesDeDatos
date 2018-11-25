CREATE OR REPLACE PACKAGE pkproductonivel1 IS
    PROCEDURE pinsertar (
        ividproducto     IN VARCHAR2,
        ivnombre         IN VARCHAR2,
        ivtipo_prod_id   IN VARCHAR2
    );

    PROCEDURE peliminar (
        ividproducto IN VARCHAR2
    );

    FUNCTION fconsultar (
        ividproducto IN VARCHAR2
    ) RETURN producto%rowtype;

    PROCEDURE pmodificar (
        vidproducto     IN VARCHAR2,
        vnombre         IN VARCHAR2,
        vtipo_prod_id   IN VARCHAR2
    );

END pkproductonivel1;
/

CREATE OR REPLACE PACKAGE BODY pkproductonivel1 IS

    PROCEDURE pinsertar (
        ividproducto     IN VARCHAR2,
        ivnombre         IN VARCHAR2,
        ivtipo_prod_id   IN VARCHAR2
    ) IS
    BEGIN
        INSERT INTO producto VALUES (
            ividproducto,
            ivnombre,
            ivtipo_prod_id
        );

    EXCEPTION
        WHEN dup_val_on_index THEN
            raise_application_error(-20001,'El id esta duplicado.');
        WHEN OTHERS THEN
            raise_application_error(-20001,'ERROR'
                                            || sqlerrm
                                            || sqlcode);
    END pinsertar;

    PROCEDURE peliminar (
        ividproducto IN VARCHAR2
    ) IS
    BEGIN
        DELETE FROM producto vproducto
        WHERE
            vproducto.id = ividproducto;

    EXCEPTION
        WHEN no_data_found THEN
            raise_application_error(-20001,'El id a eliminar no existe.');
        WHEN OTHERS THEN
            raise_application_error(-20001,'ERROR'
                                            || sqlerrm
                                            || sqlcode);
    END peliminar;

    FUNCTION fconsultar (
        ividproducto IN VARCHAR2
    ) RETURN producto%rowtype IS
        rowproducto   producto%rowtype;
    BEGIN
        SELECT
            *
        INTO rowproducto
        FROM
            producto vproducto
        WHERE
            vproducto.id = ividproducto;

        RETURN rowproducto;
    EXCEPTION
        WHEN no_data_found THEN
            raise_application_error(-20001,'El id a consultar no existe.');
        WHEN OTHERS THEN
            raise_application_error(-20001,'ERROR'
                                            || sqlerrm
                                            || sqlcode);
    END fconsultar;

    PROCEDURE pmodificar (
        vidproducto     IN VARCHAR2,
        vnombre         IN VARCHAR2,
        vtipo_prod_id   IN VARCHAR2
    ) IS
    BEGIN
        UPDATE producto p
        SET
            p.nombre = vnombre,
            p.tipoproducto_id = vtipo_prod_id
        WHERE
            p.id = vidproducto;

    EXCEPTION
        WHEN no_data_found THEN
            raise_application_error(-20001,'El producto a consultar no existe.');
        WHEN OTHERS THEN
            raise_application_error(-20001,'ERROR'
                                            || sqlerrm
                                            || sqlcode);
    END pmodificar;

END pkproductonivel1;