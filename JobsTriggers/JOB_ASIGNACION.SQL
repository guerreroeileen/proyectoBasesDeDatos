BEGIN
    DBMS_SCHEDULER.CREATE_JOB (
            job_name => '"P09551_1_10"."ASIGNAR_SOLICITUDES"',
            schedule_name => '"P09551_1_10"."EVALUAR_SOLICITUD"',
            job_type => 'STORED_PROCEDURE',
            job_action => 'P09551_1_10.PKASIGANCIONNIVEL2.PASIGNACIONAUTOMATICA',
            number_of_arguments => 1,
            enabled => FALSE,
            auto_drop => FALSE,
            comments => '');

    DBMS_SCHEDULER.SET_ATTRIBUTE( 
             name => '"P09551_1_10"."ASIGNAR_SOLICITUDES"', 
             attribute => 'logging_level', value => DBMS_SCHEDULER.LOGGING_OFF);
  
    DBMS_SCHEDULER.enable(
             name => '"P09551_1_10"."ASIGNAR_SOLICITUDES"');
END;


BEGIN

    DBMS_SCHEDULER.SET_JOB_ARGUMENT_VALUE( 
             job_name => '"P09551_1_10"."ASIGNAR_SOLICITUDES"', 
             argument_position => 1, 
             argument_value => '');

END; 
/