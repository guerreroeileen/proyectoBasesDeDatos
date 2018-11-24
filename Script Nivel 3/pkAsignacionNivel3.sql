CREATE OR REPLACE PACKAGE pkAsignacionNivel3 IS

FUNCTION Fasignacionautomatica (ividsolicitud IN VARCHAR2)RETURN VARCHAR2;
FUNCTION FAsignacionIndividual (ividsolicitud IN VARCHAR2, ividFuncionario in varchar2)RETURN VARCHAR2;

end pkAsignacionNivel3;

/
CREATE OR REPLACE PACKAGE BODY pkClienteNivel3 IS

FUNCTION fasignacionautomatica(ividsolicitud IN VARCHAR2)
return varchar2
is
begin
pkAsignacionNivel2.ppasignacionautomatica(ividsolicitud );
RETURN 'No_Exception';

EXCEPTION

WHEN OTHERS THEN
RETURN SQLERRM;

end fasignacionautomatica;


FUNCTION fasignacionautomatica(ividsolicitud IN VARCHAR2, ividFuncionario in varchar2)
return varchar2
is
begin
pkAsignacionNivel2.pAsignacionIndividual(ividsolicitud, ividFuncionario );
RETURN 'No_Exception';

EXCEPTION

WHEN OTHERS THEN
RETURN SQLERRM;

end fasignacionautomatica;


end pkAsignacionNivel3;