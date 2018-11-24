CREATE OR REPLACE PACKAGE pkClienteNivel3 IS

FUNCTION pRegistrarCliente(ivCedula VARCHAR2, ivNombre VARCHAR2, ivFechaNacimiento VARCHAR2, ivDireccion VARCHAR, ivTelefono VARCHAR2)RETURN VARCHAR2;
FUNCTION pRegistrarAnomalia(ivNombre IN VARCHAR2, ivId IN VARCHAR2) RETURN VARCHAR2;
FUNCTION pRegistrarProducto(ivIdProducto IN VARCHAR2, ivNombre IN VARCHAR2, ivTipo_prod_id IN VARCHAR2)RETURN VARCHAR2;
end pkClienteNivel3;


CREATE OR REPLACE PACKAGE BODY pkClienteNivel3 IS

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