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

CREATE OR REPLACE PACKAGE BODY pkregistronivel2 IS PROCEDURE pasignacionautomatica (
    ividsolicitud IN VARCHAR2
) IS
    declare       cedulafuncionario VARCHAR;
    cantidad      NUMBER;
    datosnumero   NUMBER;
        
    BEGIN
    INSERT INTO tabla ( id )
        SELECT
            id
        FROM
            funcionario;

    SELECT
        COUNT(*)
    INTO datosnumero
    FROM
        tabla;

WHILE datosnumero > 0 LOOP
    SELECT
        top(1) id
    INTO cedulafuncionario
    FROM
        tabla
    ORDER BY
        id;

    cantidad := pksolicitudnivel1.darsolicitudes(cedulafuncionario);
    parametro := pkparametrizacionnivel1.fconsultarnumerosolicitud(1);
IF cantidad < parametro THEN
    pksolicitudnivel1.pmodificarsolicitudasignacion(ividsolicitud,cedulafuncionario);
    datosnumero := 0;
            ELSE DELETE tabla
WHERE
    id = cedulafuncionario; SELECT
      COUNT(*)
  INTO datosnumero
  FROM
          tabla   end
    if;
    end     loop;
    end     pasignacionautomatica;

    PROCEDURE pasignacionindividual (
        ividsolicitud   IN VARCHAR2,
        ivfuncioanrio   IN VARCHAR2
    ) IS
    BEGIN
        pksolicitudnivel1.pmodificarsolicitudasignacion(ividsolicitud,ivfuncioanrio);
    EXCEPTION
        WHEN no_data_found THEN
            raise_application_error(-20000,'Error' || sqlcode);
        WHEN OTHERS THEN
            raise_application_error(-20000,'Error' || sqlcode);
    END pasignacionindividual;

END pkregistronivel2;