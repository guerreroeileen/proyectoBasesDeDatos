CREATE OR REPLACE PACKAGE pkregistronivel3 IS
    FUNCTION pregistrarfuncionario (
        ivcedula            IN VARCHAR2,
        ivnombre            IN VARCHAR2,
        ivdireccion         IN VARCHAR2,
        ivtelefono          IN VARCHAR2,
        ivfechanacimiento   IN DATE
    ) RETURN VARCHAR2;

    FUNCTION pregistrarestado (
        ivcodigo   IN VARCHAR2,
        ivnombre   IN VARCHAR2
    ) RETURN VARCHAR2;

    FUNCTION pregistrarcliente (
        ivcedula            VARCHAR2,
        ivnombre            VARCHAR2,
        ivfechanacimiento   VARCHAR2,
        ivdireccion         VARCHAR,
        ivtelefono          VARCHAR2
    ) RETURN VARCHAR2;

    FUNCTION pregistraranomalia (
        ivnombre   IN VARCHAR2,
        ivid       IN VARCHAR2
    ) RETURN VARCHAR2;

    FUNCTION pregistrarproducto (
        ividproducto     IN VARCHAR2,
        ivnombre         IN VARCHAR2,
        ivtipo_prod_id   IN VARCHAR2
    ) RETURN VARCHAR2;

    FUNCTION pregistrarsolicitud (
         tipoproducto     VARCHAR2,
        cedula           VARCHAR2,
        observacion      VARCHAR2,
        tiposolicitud    VARCHAR2,
        idproducto       VARCHAR2,
        ivcausa          VARCHAR2,
        nombreanomalia   VARCHAR2
    ) RETURN VARCHAR2;

END pkregistronivel3;
/

CREATE OR REPLACE PACKAGE BODY pkregistronivel3 IS

    FUNCTION pregistrarsolicitud (
        tipoproducto     VARCHAR2,
        cedula           VARCHAR2,
        observacion      VARCHAR2,
        tiposolicitud    VARCHAR2,
        idproducto       VARCHAR2,
        ivcausa          VARCHAR2,
        nombreanomalia   VARCHAR2
    ) RETURN VARCHAR2 IS
        BEGIN
            pkregistronivel2.pregistrarsolicitud(tipoproducto,cedula,observacion,tiposolicitud,idproducto,ivcausa,nombreanomalia);
            RETURN 'No_Exception';
        EXCEPTION
            WHEN OTHERS THEN
                RETURN sqlerrm;
        END pregistrarsolicitud;

    FUNCTION pregistrarfuncionario (
        ivcedula            IN VARCHAR2,
        ivnombre            IN VARCHAR2,
        ivdireccion         IN VARCHAR2,
        ivtelefono          IN VARCHAR2,
        ivfechanacimiento   IN DATE
    ) RETURN VARCHAR2 IS
    BEGIN
        pkregistronivel2.pregistrarfuncionario(ivcedula,ivnombre,ivdireccion,ivtelefono,ivfechanacimiento);
        RETURN 'No_Exception';
    EXCEPTION
        WHEN OTHERS THEN
            RETURN sqlerrm;
    END pregistrarfuncionario;

    FUNCTION pregistrarestado (
        ivcodigo   IN VARCHAR2,
        ivnombre   IN VARCHAR2
    ) RETURN VARCHAR2 IS
    BEGIN
        pkregistronivel2.pregistrarestado(ivcodigo,ivnombre);
        RETURN 'No_Exception';
    EXCEPTION
        WHEN OTHERS
            then
                return sqlerrm;
        end    pregistrarestado;

    FUNCTION pregistrarcliente (
        ivcedula            VARCHAR2,
        ivnombre            VARCHAR2,
        ivfechanacimiento   VARCHAR2,
        ivdireccion         VARCHAR,
        ivtelefono          VARCHAR2
    ) RETURN VARCHAR2 IS
    BEGIN
        pkregistronivel2.pregistrarcliente(ivcedula,ivnombre,ivfechanacimiento,ivdireccion,ivtelefono);
        RETURN 'No_Exception';
    EXCEPTION
        WHEN OTHERS THEN
            RETURN sqlerrm;
    END pregistrarcliente;

    FUNCTION pregistraranomalia (
        ivnombre   IN VARCHAR2,
        ivid       IN VARCHAR2
    ) RETURN VARCHAR2 IS
    BEGIN
        pkregistronivel2.pregistraranomalia(ivnombre,ivid);
        RETURN 'No_Exception';
    EXCEPTION
        WHEN OTHERS THEN
            RETURN sqlerrm;
    END pregistraranomalia;

    FUNCTION pregistrarproducto (
        ividproducto     IN VARCHAR2,
        ivnombre         IN VARCHAR2,
        ivtipo_prod_id   IN VARCHAR2
    ) RETURN VARCHAR2 IS
    BEGIN
        pkregistronivel2.pregistrarproducto(ividproducto,ivnombre,ivtipo_prod_id);
        RETURN 'No_Exception';
    EXCEPTION
        WHEN OTHERS THEN
            RETURN sqlerrm;
    END pregistrarproducto;

END pkregistronivel3;