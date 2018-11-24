create or replace PACKAGE pkatencionnivel2 AS
    PROCEDURE patendersolicitud (
        cedfun       funcionario.cedula%TYPE,
        codsoli      solicitud.n_solicitud%TYPE,
        comentario   solicitud.comentariofuncionario%TYPE,
        estado       solicitud.estado_codigo%TYPE
    );

    PROCEDURE psolicitudnuevoproducto (
        codsoli      solicitud.n_solicitud%TYPE,
        comentario   solicitud.comentariofuncionario%TYPE,
        estado       solicitud.estado_codigo%TYPE
    );

    PROCEDURE psolicitudretiro (
        codsoli      solicitud.n_solicitud%TYPE,
        comentario   solicitud.comentariofuncionario%TYPE,
        estado       solicitud.estado_codigo%TYPE
    );

    PROCEDURE psolicituddanoreclamo (
        codsoli      solicitud.n_solicitud%TYPE,
        comentario   solicitud.comentariofuncionario%TYPE,
        estado       solicitud.estado_codigo%TYPE
    );

    PROCEDURE pevaluarsolicitudes (
        comentario VARCHAR2
    );


END pkatencionnivel2;
/
create or replace PACKAGE BODY pkatencionnivel2 AS

    PROCEDURE patendersolicitud (
        cedfun       funcionario.cedula%TYPE,
        codsoli      solicitud.n_solicitud%TYPE,
        comentario   solicitud.comentariofuncionario%TYPE,
        estado       solicitud.estado_codigo%TYPE
    ) IS
        soli    solicitud%rowtype;
        tsoli   tiposolicitud%rowtype;
        tip     solicitud.tiposolicitud_id%TYPE; 
    BEGIN
        soli := pksolicitudn1.fconsultar(codsoli);
        IF soli.funcionario_cedula = cedfun THEN
            tip := soli.tiposolicitud_id;
            tsoli := pktiposolicitudn1.fconsultar(tip);
            CASE tsoli.nombre
                WHEN 'retiro' THEN
                    psolicitudretiro(codsoli, comentario, estado);
                WHEN 'nuevoproducto' THEN
                    psolicitudnuevoproducto(codsoli, comentario, estado);
                WHEN 'danos' THEN
                    psolicituddanoreclamo(codsoli, comentario, estado);
                WHEN 'reclamos' THEN
                    psolicituddanoreclamo(codsoli, comentario, estado);
            END CASE;

        ELSE
            raise_application_error(-20001, 'el funcionario no tiene permiso');
        END IF;

    EXCEPTION
        WHEN OTHERS THEN
            raise_application_error(-20001, 'Verifique los datos');
    END patendersolicitud;

    PROCEDURE psolicitudnuevoproducto (
        codsoli      solicitud.n_solicitud%TYPE,
        comentario   solicitud.comentariofuncionario%TYPE,
        estado       solicitud.estado_codigo%TYPE
    ) IS
        solici   solicitud%rowtype;
        fecha    DATE;
    BEGIN
        solici := pksolicitudn1.fconsultar(codsoli);
        fecha := add_months(SYSDATE, 1);
        pkclienteproducton1.pinsertar(solici.cliente_cedula, solici.producto_id, fecha, NULL);
        pksolicitudn1.pmodificarsolicitudestado(solici.n_solicitud, estado);
        pksolicitudn1.pmodificarsolicitudatencion(solici.n_solicitud, SYSDATE);
        pksolicitudn1.pmodificarsolicitudcomentario(solici.n_solicitud, comentario);
    EXCEPTION
        WHEN OTHERS THEN
            RAISE;
            ROLLBACK;
    END psolicitudnuevoproducto;

    PROCEDURE psolicitudretiro (
        codsoli      solicitud.n_solicitud%TYPE,
        comentario   solicitud.comentariofuncionario%TYPE,
        estado       solicitud.estado_codigo%TYPE
    ) IS
        clientepro   clientexproducto%rowtype;
        solici       solicitud%rowtype;
        fecha        DATE;
    BEGIN
        fecha := SYSDATE;
        solici := pksolicitudn1.fconsultar(codsoli);
        clientepro := pkclienteproducton1.fconsultar(solici.cliente_cedula, solici.producto_id);
        pkclienteproducton1.pmodificarfechafin(solici.cliente_cedula, solici.producto_id, fecha);
        pksolicitudn1.pmodificarsolicitudcomentario(solici.n_solicitud, comentario);
        pksolicitudn1.pmodificarsolicitudestado(solici.n_solicitud, estado);
        pksolicitudn1.pmodificarsolicitudatencion(solici.n_solicitud, SYSDATE);
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
    END psolicitudretiro;

    PROCEDURE psolicituddanoreclamo (
        codsoli      solicitud.n_solicitud%TYPE,
        comentario   solicitud.comentariofuncionario%TYPE,
        estado       solicitud.estado_codigo%TYPE
    ) IS
        solici   solicitud%rowtype;
    BEGIN
        solici := pksolicitudn1.fconsultar(codsoli);
        pksolicitudn1.pmodificarsolicitudcomentario(solici.n_solicitud, comentario);
        pksolicitudn1.pmodificarsolicitudestado(solici.n_solicitud, estado);
        pksolicitudn1.pmodificarsolicitudatencion(solici.n_solicitud, SYSDATE);
    END psolicituddanoreclamo;

    PROCEDURE pevaluarsolicitudes IS
        cod_solicitud   solicitud.n_solicitud%TYPE;
        comentario solicitud.comentariofuncionario%TYPE;
    BEGIN
    comentario := 'Generado automaticamente por el sistema';
        WHILE cod_solicitud != '-1' LOOP
            cod_solicitud := pksolicitudn1.fsolicitudvencida('1');
            pkatencionnivel2.psolicituddanoreclamo(cod_solicitud, comentario, '2');
        END LOOP;

        WHILE cod_solicitud != '-1' LOOP
            cod_solicitud := pksolicitudn1.fsolicitudvencida('3');
            pkatencionnivel2.psolicituddanoreclamo(cod_solicitud, comentario, '2');
        END LOOP;

    END pevaluarsolicitudes;

END pkatencionnivel2;