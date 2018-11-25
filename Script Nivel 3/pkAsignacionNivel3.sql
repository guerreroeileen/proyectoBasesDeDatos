CREATE OR REPLACE PACKAGE pkasignacionnivel3 IS
    FUNCTION fasignacionautomatica (
        ividsolicitud IN VARCHAR2
    ) RETURN VARCHAR2;

    FUNCTION fasignacionindividual (
        ividsolicitud     IN VARCHAR2,
        ividfuncionario   IN VARCHAR2
    ) RETURN VARCHAR2;

END pkasignacionnivel3;
/

CREATE OR REPLACE PACKAGE BODY pkasignacionnivel3 IS

    FUNCTION fasignacionautomatica (
        ividsolicitud IN VARCHAR2
    ) RETURN VARCHAR2 IS
    BEGIN
        pkasigancionnivel2.pasignacionautomatica(ividsolicitud);
        RETURN 'No_Exception';
    EXCEPTION
        WHEN OTHERS THEN
            RETURN sqlerrm;
    END fasignacionautomatica;

    FUNCTION fasignacionindividual (
        ividsolicitud     IN VARCHAR2,
        ividfuncionario   IN VARCHAR2
    ) RETURN VARCHAR2 IS
    BEGIN
        pkasigancionnivel2.pasignacionindividual(ividsolicitud,ividfuncionario);
        RETURN 'No_Exception';
    EXCEPTION
        WHEN OTHERS THEN
            RETURN sqlerrm;
    END fasignacionindividual;

END pkasignacionnivel3;