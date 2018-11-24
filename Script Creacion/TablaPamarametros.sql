DROP TABLE parametrizacion CASCADE CONSTRAINTS;

CREATE TABLE parametrizacion
(
    Identificador NUMBER(1),
    intervaloAtencion NUMBER(20) ,
    numeroSolicitudesFuncionario NUMBER(20)
);

ALTER TABLE parametrizacion ADD CONSTRAINT parametrizacion_pk PRIMARY KEY ( Identificador );

