CREATE OR REPLACE PACKAGE pkClienteNivel3 IS

PROCEDURE fConsultarCliente(ivCedula IN VARCHAR2,  ovNombre out VARCHAR2, ovFechaNacimiento out VARCHAR2, ovDireccion out VARCHAR, ovTelefono out VARCHAR2, ovException out VARCHAR2); 

PROCEDURE pRegistrarCliente(ivCedula VARCHAR2, ivNombre VARCHAR2, ivFechaNacimiento VARCHAR2, ivDireccion VARCHAR, ivTelefono VARCHAR2, ovException out VARCHAR2);

PROCEDURE pModificarCliente(ivCedula IN VARCHAR2, ivNombre IN VARCHAR2, ivFechaNacimiento IN VARCHAR2, ivDireccion IN VARCHAR2, ivtTelefono IN VARCHAR2, ovException out VARCHAR2);

PROCEDURE pEliminarCliente(ivCedula IN VARCHAR2, ovException out VARCHAR2);


end pkClienteNivel3;


CREATE OR REPLACE PACKAGE BODY pkClienteNivel3 IS

PROCEDURE fConsultarCliente(ivCedula IN VARCHAR2,  ovNombre out VARCHAR2, ovFechaNacimiento out VARCHAR2, ovDireccion out VARCHAR, telefono out VARCHAR2, ovException out VARCHAR2)

IS
ovCliente CLIENTE%rowtype;

BEGIN

ovCliente := pkClienteNivel2.fConsultarCliente(ivCedula);
ovNombre := ovCliente.nombre;
ovFechaNacimiento := ovCliente.fechaNacimiento;
ovDireccion := ovCliente.direccion;
ovTelefono := ovCliente.telefono;
ovException := 'No_Exception';

EXCEPTION

WHEN OTHERS THEN
    ovException := SQLERRM;
    
END fConsultarCliente;

PROCEDURE pRegistrarCliente(ivCedula VARCHAR2, ivNombre VARCHAR2, ivFechaNacimiento VARCHAR2, ivDireccion VARCHAR, ivTelefono VARCHAR2, ovException out VARCHAR2)

IS

BEGIN

pkClienteNivel2.pRegistrarCliente(ivCedula , ivNombre , ivFechaNacimiento , ivDireccion , ivTelefono);
ovException := 'No_Exception';

EXCEPTION

WHEN OTHERS THEN
    ovException := SQLERRM;

END pRegistrarCliente;

PROCEDURE pModificarCliente(ivCedula IN VARCHAR2, ivNombre IN VARCHAR2, ivFechaNacimiento IN VARCHAR2, ivDireccion IN VARCHAR2, ivtTelefono IN VARCHAR2, ovException out VARCHAR2)

IS

BEGIN

pkClienteNivel2.pModificarCliente(ivCedula, ivNombre , ivFechaNacimiento , ivDireccion , ivtTelefono );
ovException := 'No_Exception';

EXCEPTION

WHEN OTHERS THEN
    ovException := SQLERRM;
    


END pModificarCliente;

PROCEDURE pEliminarCliente(ivCedula IN VARCHAR2, ovException out VARCHAR2)

IS

BEGIN
pkClienteNivel2.pEliminarCliente(ivCedula);
ovException := 'No_Exception';

EXCEPTION

WHEN OTHERS THEN
    ovException := SQLERRM;

END pEliminarCliente;


end pkClienteNivel3;