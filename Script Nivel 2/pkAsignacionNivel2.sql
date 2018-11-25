CREATE OR REPLACE PACKAGE pkasigancionnivel2 IS
    PROCEDURE pasignacionautomatica (
        ividsolicitud IN VARCHAR2
    );

    PROCEDURE pasignacionindividual (
        ividsolicitud   IN VARCHAR2,
        ivfuncioanrio   IN VARCHAR2
    );

END pkasigancionnivel2;
/

CREATE OR REPLACE PACKAGE BODY pkasigancionnivel2 IS

    PROCEDURE pasignacionautomatica (
        ividsolicitud IN VARCHAR2
    ) IS
        cedulafuncionario   VARCHAR(50);
        cantidad            NUMBER;
        datosnumero         NUMBER;
        parametro           NUMBER;
        vrecorrido          NUMBER;
    BEGIN
        vrecorrido := 0;
        SELECT
            COUNT(cedula)
       INTO datosnumero
        FROM
            funcionario;

        WHILE vrecorrido < datosnumero LOOP
            SELECT
                cedula
            INTO cedulafuncionario
            FROM
                funcionario
            WHERE
                ROWNUM = vrecorrido;

            cantidad := pksolicitudn1.darsolicitudes(cedulafuncionario);
            parametro := pkparametrizacion.fconsultar(1).NUMEROSOLICITUDESFUNCIONARIO;
            IF cantidad < parametro THEN
                pksolicitudn1.pmodificarsolicitudasignacion(ividsolicitud,cedulafuncionario);
                datosnumero := 0;
            ELSE
                vrecorrido := vrecorrido + 1;
            END IF;

        END LOOP;

    END pasignacionautomatica;

    PROCEDURE pasignacionindividual (
        ividsolicitud   IN VARCHAR2,
        ivfuncioanrio   IN VARCHAR2
    ) IS
    BEGIN
        pksolicitudn1.pmodificarsolicitudasignacion(ividsolicitud,ivfuncioanrio);
    EXCEPTION
        WHEN no_data_found THEN
            raise_application_error(-20000,'Error' || sqlcode);
        WHEN OTHERS THEN
            raise_application_error(-20000,'Error' || sqlcode);
    END pasignacionindividual;

END pkasigancionnivel2;