DECLARE
    frequency_interval   NUMBER;
    frequency            VARCHAR2;
    set                  frecuency := 'FREQ=DAILY;';
BEGIN
    SELECT
        into   frequency_interval
    FROM
        parametrizacion
    WHERE
        id = '1';

    frequency := concat(frequency, frequency_interval);
END;
BEGIN
dbms_scheduler.create_job (
   job_name           =>  'evaluar_solicitudes',
   job_type           =>  'STORED_PROCEDURE',
   job_action         =>  'P09551_1_10.PKATENCIONNIVEL2.PEVALUARSOLICITUDES',
   start_date         =>  '24-NOV-201811.16.00AMAmerica/Bogota',
   repeat_interval    =>  frequency, /* every other day */
   end_date           =>  '24-NOV-201811.18.00AMAmerica/Bogota',
   comments           =>  'Se encarga de atender solicitudes que pasen el tiempo limite');
END;
/