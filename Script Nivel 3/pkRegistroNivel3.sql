CREATE OR REPLACE PACKAGE pkRegistroNivel3 IS

FUNCTION pRegistrarFuncionario(ivCedula IN VARCHAR2, ivNombre IN VARCHAR2, ivDireccion IN VARCHAR2,  ivTelefono IN VARCHAR2, ivFechaNacimiento IN DATE) RETURN VARCHAR2;
FUNCTION pRegistrarEstado (ivCodigo IN VARCHAR2, ivNombre IN VARCHAR2) RETURN VARCHAR2; 
FUNCTION pRegistrarCliente(ivCedula VARCHAR2, ivNombre VARCHAR2, ivFechaNacimiento VARCHAR2, ivDireccion VARCHAR, ivTelefono VARCHAR2)RETURN VARCHAR2;
FUNCTION pRegistrarAnomalia(ivNombre IN VARCHAR2, ivId IN VARCHAR2) RETURN VARCHAR2;
FUNCTION pRegistrarProducto(ivIdProducto IN VARCHAR2, ivNombre IN VARCHAR2, ivTipo_prod_id IN VARCHAR2)RETURN VARCHAR2;
end pkClienteNivel3;
PROCEDURE pRSolicitud(ividSolicitud IN VARCHAR2, ivcedula IN VARCHAR2,ivobservacion IN VARCHAR2,ivtipoSolicitud IN VARCHAR2, ividProducto IN VARCHAR2, );

/

CREATE OR REPLACE PACKAGE BODY pkRegistroNivel3 IS

PROCEDURE pRSolicitud(ividSolicitud IN VARCHAR2, ivcedula IN VARCHAR2,ivobservacion IN VARCHAR2,ivtipoSolicitud IN VARCHAR2, ividProducto IN VARCHAR2)
RETURN VARCHAR2
IS

BEGIN

pkRegistroNivel2.pRSolicitud(ividSolicitud, ivcedula ,ivobservacion,ivtipoSolicitud, ividProducto);
RETURN 'No_Exception';

EXCEPTION

WHEN OTHERS THEN
   RETURN SQLERRM;

END pRegistrarFuncionario;


END pRSolicitud;


FUNCTION pRegistrarFuncionario(ivCedula IN VARCHAR2, ivNombre IN VARCHAR2, ivDireccion IN VARCHAR2, ivTelefono IN VARCHAR2, ivFechaNacimiento IN DATE)
RETURN VARCHAR2
IS

BEGIN

pkRegistroNivel2.pRegistrarFuncionario(ivCedula , ivNombre , ivDireccion , ivTelefono , ivFechaNacimiento);
RETURN 'No_Exception';

EXCEPTION

WHEN OTHERS THEN
   RETURN SQLERRM;

END pRegistrarFuncionario;



FUNCTION pRegistrarEstado (ivCodigo IN VARCHAR2, ivNombre IN VARCHAR2) 
RETURN VARCHAR2
IS

BEGIN

pkRegistroNivel2.pRegistrarEstado(ivCodigo , ivNombre);
RETURN 'No_Exception';

EXCEPTION

WHEN OTHERS THEN
   RETURN SQLERRM;

END pRegistrarEstado;



FUNCTION pRegistrarCliente(ivCedula VARCHAR2, ivNombre VARCHAR2, ivFechaNacimiento VARCHAR2, ivDireccion VARCHAR, ivTelefono VARCHAR2)
RETURN VARCHAR2
IS

BEGIN

pkRegistroNivel2.pRegistrarCliente(ivCedula , ivNombre , ivFechaNacimiento , ivDireccion , ivTelefono);
RETURN 'No_Exception';

EXCEPTION

WHEN OTHERS THEN
   RETURN SQLERRM;

END pRegistrarCliente;

FUNCTION pRegistrarAnomalia(ivNombre IN VARCHAR2, ivId IN VARCHAR2)
RETURN VARCHAR2
IS

BEGIN

pkRegistroNivel2.pResgistrarAnomalia(vNombre , ivId);
RETURN'No_Exception';

EXCEPTION

WHEN OTHERS THEN
RETURN SQLERRM;

END pRegistrarAnomalia;

FUNCTION pRegistrarProducto(ivIdProducto IN VARCHAR2, ivNombre IN VARCHAR2, ivTipo_prod_id IN VARCHAR2)
return varchar2
is
begin
pkRegistroNivel2.pRegistrarProducti(ivIdProducto , ivNombre , ivTipo_prod_id );
RETURN'No_Exception';

EXCEPTION

WHEN OTHERS THEN
RETURN SQLERRM;

end pRegistrarProducto;
end pkClienteNivel3;