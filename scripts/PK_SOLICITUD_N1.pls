create or replace PACKAGE pk_solicitud_n1 IS
--[declaración de objetos públicos]
    PROCEDURE pinsertarsolictud (
        n_solicitud             VARCHAR2,
        observaciones           VARCHAR2,
        fechaasignacion         DATE,
        fechaatencion           DATE,
        causa                   VARCHAR2,
        comentariofuncionario   VARCHAR2,
        cliente_cedula          VARCHAR2,
        estado_codigo           VARCHAR2,
        funcionario_cedula      VARCHAR2,
        anomalia_id             VARCHAR2,
        tiposolicitud_id        VARCHAR2,
        producto_id             VARCHAR2
    );

    PROCEDURE pborrarsolictud (
        n_solicitud VARCHAR2
    );

    PROCEDURE pmodificarsolictud (
        n_solicitud             VARCHAR2,
        observaciones           VARCHAR2,
        fechaasignacion         DATE,
        fechaatencion           DATE,
        causa                   VARCHAR2,
        comentariofuncionario   VARCHAR2,
        cliente_cedula          VARCHAR2,
        estado_codigo           VARCHAR2,
        funcionario_cedula      VARCHAR2,
        anomalia_id             VARCHAR2,
        tiposolicitud_id        VARCHAR2,
        producto_id             VARCHAR2
    );
    FUNCTION pconsultar (
       cod_solicitud VARCHAR2
    ) RETURN SOLICITUD%ROWTYPE;

--[declaración de subprogramas]

END pk_solicitud_n1;
/
create or replace PACKAGE BODY pk_solicitud_n1 IS

--[declaración de objetos privados]
    PROCEDURE pinsertarsolictud (
        n_solicitud             VARCHAR2,
        observaciones           VARCHAR2,
        fechaasignacion         DATE,
        fechaatencion           DATE,
        causa                   VARCHAR2,
        comentariofuncionario   VARCHAR2,
        cliente_cedula          VARCHAR2,
        estado_codigo           VARCHAR2,
        funcionario_cedula      VARCHAR2,
        anomalia_id             VARCHAR2,
        tiposolicitud_id        VARCHAR2,
        producto_id             VARCHAR2
    ) IS
    BEGIN
        INSERT INTO solicitud VALUES (
            n_solicitud,
            observaciones,
            fechaasignacion,
            fechaatencion,
            causa,
            comentariofuncionario,
            cliente_cedula,
            estado_codigo,
            funcionario_cedula,
            anomalia_id,
            tiposolicitud_id,
            producto_id
        );

    END pinsertarsolictud;

    PROCEDURE pborrarsolictud (
        n_solicitud VARCHAR2
    ) IS
    BEGIN
        DELETE FROM solicitud
        WHERE
            solicitud.n_solicitud = n_solicitud;

    END pborrarsolictud;

    PROCEDURE pmodificarsolictud (
        n_solicitud             VARCHAR2,
        observaciones           VARCHAR2,
        fechaasignacion         DATE,
        fechaatencion           DATE,
        causa                   VARCHAR2,
        comentariofuncionario   VARCHAR2,
        cliente_cedula          VARCHAR2,
        estado_codigo           VARCHAR2,
        funcionario_cedula      VARCHAR2,
        anomalia_id             VARCHAR2,
        tiposolicitud_id        VARCHAR2,
        producto_id             VARCHAR2
    ) IS
    BEGIN
        UPDATE solicitud s
        SET
            s.observaciones = observaciones,
            s.fechaasignacion = fechaasignacion,
            s.fechaatencion = fechaatencion,
            s.causa = causa,
            s.comentariofuncionario = comentariofuncionario,
            s.cliente_cedula = cliente_cedula,
            s.estado_codigo = estado_codigo,
            s.funcionario_cedula = funcionario_cedula,
            s.anomalia_id = anomalia_id,
            s.tiposolicitud_id = tiposolicitud_id,
            s.producto_id = producto_id
        WHERE
            s.n_solicitud = n_solicitud;

    END pmodificarsolictud;

    FUNCTION pconsultar (
        cod_solicitud VARCHAR2
    ) RETURN SOLICITUD%ROWTYPE IS
    fila SOLICITUD%ROWTYPE;
    BEGIN
        SELECT
            * INTO fila
        FROM
            solicitud s
        WHERE
            s.n_solicitud = n_solicitud;
    return fila;
    END pconsultar;
--[definición de subprogramas]

END pk_solicitud_n1;