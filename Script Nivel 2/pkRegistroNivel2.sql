CREATE OR REPLACE PACKAGE pkregistronivel2 AS
    PROCEDURE pregistrarestado (
        ivcodigo   IN VARCHAR2,
        ivnombre   IN VARCHAR2
    );

    PROCEDURE pregistrarfuncionario (
        ivcedula            IN VARCHAR2,
        ivnombre            IN VARCHAR2,
        ivdireccion         IN VARCHAR2,
        ivtelefono          IN VARCHAR2,
        ivfechanacimiento   IN DATE
    );

    PROCEDURE pregistraranomalia (
        ivnombre   IN VARCHAR2,
        ivid       IN VARCHAR2
    );

    PROCEDURE pregistrarcliente (
        ivcedula            IN VARCHAR2,
        ivnombre            IN VARCHAR2,
        ivfechanacimiento   IN VARCHAR2,
        ivdireccion         IN VARCHAR,
        ivtelefono          IN VARCHAR2
    );

    PROCEDURE pregistrarproducto (
        ividproducto     IN VARCHAR2,
        ivnombre         IN VARCHAR2,
        ivtipo_prod_id   IN VARCHAR2
    );

    PROCEDURE prsolicitud (
        idsolicitud     IN VARCHAR2,
        cedula          IN VARCHAR2,
        observacion     IN VARCHAR2,
        tiposolicitud   IN VARCHAR2,
        idproducto      IN VARCHAR2
    );

END pkregistronivel2;
/

CREATE OR REPLACE PACKAGE BODY pkregistronivel2 AS

    PROCEDURE pregistrarfuncionario (
        ivcedula            IN VARCHAR2,
        ivnombre            IN VARCHAR2,
        ivdireccion         IN VARCHAR2,
        ivtelefono          IN VARCHAR2,
        ivfechanacimiento   IN DATE
    ) IS
    BEGIN
        pkfuncionarionivel1.pinsertar(ivcedula,ivnombre,ivdireccion,ivtelefono,ivfechanacimiento);
    EXCEPTION
        WHEN OTHERS THEN
            raise_application_error(-20001,'Error al insertar en la tabla Funcionario' || sqlcode);
    END pregistrarfuncionario;

    PROCEDURE pregistrarestado (
        ivcodigo   IN VARCHAR2,
        ivnombre   IN VARCHAR2
    ) IS
    BEGIN
        pkestadonivel1.pinsertar(ivcodigo,ivnombre);
    EXCEPTION
        WHEN OTHERS THEN
            raise_application_error(-20001,'Error al insertar en la tabla Funcionario' || sqlcode);
    END pregistrarestado;

    PROCEDURE pregistrarproducto (
        ividproducto     IN VARCHAR2,
        ivnombre         IN VARCHAR2,
        ivtipo_prod_id   IN VARCHAR2
    ) IS
    BEGIN
        pkproductonivel1.pinsertar(ividproducto,ivnombre,ivtipo_prod_id);
    EXCEPTION
        WHEN OTHERS THEN
            raise_application_error(-20000,'Error al insertar en la tabla Producto' || sqlcode);
    END pregistrarproducto;

    PROCEDURE pregistraranomalia (
        ivnombre   IN VARCHAR2,
        ivid       IN VARCHAR2
    ) IS
    BEGIN
    -- Utiliza el metodo de insertar del nivel 1 correspondiente a anomalia para insertarla
        pkanomalianivel1.pinsertar(ivnombre,ivid);
    EXCEPTION
        WHEN dup_val_on_index THEN
            raise_application_error(-20001,'El id esta duplicado.');
        WHEN OTHERS THEN
            raise_application_error(-20001,'Error'
                                            || sqlerrm
                                            || sqlcode);
    END pregistraranomalia;

    PROCEDURE pregistrarcliente (
        ivcedula            IN VARCHAR2,
        ivnombre            IN VARCHAR2,
        ivfechanacimiento   IN VARCHAR2,
        ivdireccion         IN VARCHAR,
        ivtelefono          IN VARCHAR2
    ) IS
    BEGIN
        pkclientenivel1.pinsertar(ivcedula,ivnombre,ivfechanacimiento,ivdireccion,ivtelefono);
    EXCEPTION
    -- copie las mismas excepciones de la capa 1
        WHEN dup_val_on_index THEN
            raise_application_error(-20001,'El id esta duplicado.');
        WHEN OTHERS THEN
            raise_application_error(-20001,'Unknown Error'
                                            || sqlerrm
                                            || sqlcode);
    END pregistrarcliente;

    PROCEDURE prsolicitud (
        tipoproducto     VARCHAR2,
        cedula           VARCHAR2,
        observacion      VARCHAR2,
        tiposolicitud    VARCHAR2,
        idproducto       VARCHAR2,
        ivcausa          VARCHAR2,
        nombreanomalia   VARCHAR2
    ) IS

        fechaasignacion         DATE;
        fechaatencion           DATE;
        estadocodigo            VARCHAR2;
        funcionariocedula       VARCHAR2;
        comentariofuncionario   VARCHAR2;
        cliente                 cliente%rowtype;
        numerosolicitud         solicitud.n_solicitud%TYPE;
        tiposolici              VARCHAR2;
    BEGIN
-- tienen que ver donde va ese metodo creado por jaiver y kevin
        numerosolicitud := sequence_id_solicitud.nextval;
        fechaasignacion := SYSDATE;
        estadocodigo := 'En_espera';
        fechaatencion := NULL;
        funcionariocedula := NULL;
        anomaliaid := nombreanomalia;
        comentariofuncionario := NULL;
        cliente := pkclientenivel1.fconsultar(cedula);
        tiposolici := pktiposolicitudn1.fconsultar(tiposolicitud);
        CASE tiposolici.nombre
            WHEN 'nuevoproducto' THEN
                causa := NULL;
                anomaliaid := NULL;
                pk_solicitud_n1.pinsertar(numerosolicitud,observacion,fechaasignacion,fechatencion,causa,comentariofuncionario,cedula
               ,estadocodigo,funcionariocedula,anomaliaid,tiposolici,idproducto);

            WHEN 'retiro' THEN
                anomaliaid := NULL;
                observacion := NULL;
                pk_solicitud_n1.pinsertar(numerosolicitud,observacion,fechaasignacion,fechatencion,causa,comentariofuncionario,cedula
               ,estadocodigo,funcionariocedula,anomaliaid,tiposolici,idproducto);

            WHEN 'danos' THEN
                causa := NULL;
                pk_solicitud_n1.pinsertar(numerosolicitud,observacion,fechaasignacion,fechatencion,causa,comentariofuncionario,cedula
               ,estadocodigo,funcionariocedula,anomaliaid,tiposolici,idproducto);

            WHEN 'reclamos' THEN
                causa := NULL;
                anomaliaid := NULL;
                pk_solicitud_n1.pinsertar(numerosolicitud,observacion,fechaasignacion,fechatencion,causa,comentariofuncionario,cedula
               ,estadocodigo,funcionariocedula,anomaliaid,tiposolici,idproducto);

            WHEN 'modificacion' THEN
                pk_solicitud_n1.pinsertar(numerosolicitud,observacion,fechaasignacion,fechatencion,causa,comentariofuncionario,cedula
               ,estadocodigo,funcionariocedula,anomaliaid,tiposolici,idproducto);
        END CASE;

    EXCEPTION
        WHEN other THEN
            raise_application_error(-20201,' no esta registrado');
    END prsolicitud;

END pkregistronivel2;