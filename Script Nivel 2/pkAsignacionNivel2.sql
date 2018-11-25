CREATE OR REPLACE PACKAGE pkasigancionnivel2 IS 

PROCEDURE pasignacionautomatica (
        ividsolicitud IN VARCHAR2
    );
    PROCEDURE pAsignacionIndividual(ividsolicitud IN VARCHAR2, ivFuncioanrio in VARCHAR2);

END pkasigancionnivel2;
/
CREATE OR REPLACE PACKAGE BODY pkregistronivel2 IS


    PROCEDURE pasignacionautomatica (
        ividsolicitud IN VARCHAR2
    ) IS
        declare       cedulafuncionario VARCHAR;
        cantidad      NUMBER;
        datosnumero   NUMBER;
        
    BEGIN
    insert into tabla (id) select id from funcionario;
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
            ELSE
                DELETE tabla
                WHERE
                    id = cedulafuncionario;

                SELECT
                    COUNT(*)
                INTO datosnumero
                FROM
                    tabla

            END IF;

        END LOOP;

    END pasignacionautomatica;
    
    PROCEDURE pAsignacionIndividual(ividsolicitud IN VARCHAR2, ivFuncioanrio in VARCHAR2) is
    begin pksolicitudnivel1.pmodificarsolicitudasignacion(ividsolicitud,ivFuncioanrio);
     EXCEPTION
     WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20000, 'Error'||SQLCODE);
      WHEN OTHERS THEN
    RAISE_APPLICATION_ERROR(-20000, 'Error'||SQLCODE);
    
    end pAsignacionIndividual;

END pkregistronivel2;