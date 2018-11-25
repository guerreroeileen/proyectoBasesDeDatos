package vista;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewGestionarDatos {

    @FXML
    private Label labNombClientCrear;

    @FXML
    private Label labCedulaClientCrear;

    @FXML
    private Label labFechaNaciClientCrear;

    @FXML
    private Label labDirClientCrear;

    @FXML
    private Label labTelClientCrear;

    @FXML
    private TextField txtNombClientCrear;

    @FXML
    private TextField txtCedulaClientCrear;

    @FXML
    private TextField txtFechaNaciClientCrear;

    @FXML
    private TextField txtDirClientCrear;

    @FXML
    private TextField txtTelClientCrear;

    @FXML
    private Button butAgregarClient;

    @FXML
    private Label labCodTiProductoCrear;

    @FXML
    private TextField txtCodTiProductoCrear;

    @FXML
    private Button butAgregarTiProducto;

    @FXML
    private Label labDescTiProductoCrear;

    @FXML
    private TextField txtDescTiProductoCrear;

    @FXML
    private Label labNombFuncCrear;

    @FXML
    private Label labCedulaFuncCrear;

    @FXML
    private Label labFechaNaciFuncCrear;

    @FXML
    private Label labDirFuncCrear;

    @FXML
    private Label labTelFuncCrear;

    @FXML
    private TextField txtNombFuncCrear;

    @FXML
    private TextField txtCedulaFuncCrear;

    @FXML
    private TextField txtFechaNaciFuncCrear;

    @FXML
    private TextField txtDirFuncCrear;

    @FXML
    private TextField txtTelFuncCrear;

    @FXML
    private Button butAgregarFunc;

    @FXML
    private Label labCodTiSolicitudCrear;

    @FXML
    private TextField txtCodTiSolicitudCrear;

    @FXML
    private Button butAgregarTiSolicitud;

    @FXML
    private Label labDecTiSolicitudCrear;

    @FXML
    private TextField txtDecTiSolicitudCrear;

    @FXML
    private Label labNombClientMod;

    @FXML
    private Label labCedulaClientMod;

    @FXML
    private Label labFechaNaciClientMod;

    @FXML
    private Label labDirClientMod;

    @FXML
    private Label labTelClientMod;

    @FXML
    private TextField txtNombClientMod;

    @FXML
    private TextField txtCedulaClientMod;

    @FXML
    private TextField txtFechaNaciClientMod;

    @FXML
    private TextField txtDirClientMod;

    @FXML
    private TextField txtTelClientMod;

    @FXML
    private Button butModClient;

    @FXML
    private Button butBuscarClientAct;

    @FXML
    private Label labCodTiProductoMod;

    @FXML
    private TextField txtCodTiProductoMod;

    @FXML
    private Button butModTiProducto;

    @FXML
    private Label labDescTiProductoMod;

    @FXML
    private TextField txtDescTiProductoMod;

    @FXML
    private Button butBuscarTiProductAct;

    @FXML
    private Label labNombFuncMod;

    @FXML
    private Label labCedulaFuncMod;

    @FXML
    private Label labFechaNaciFuncMod;

    @FXML
    private Label labDirFuncMod;

    @FXML
    private Label labTelFuncMod;

    @FXML
    private TextField txtNombFuncMod;

    @FXML
    private TextField txtCedulaFuncMod;

    @FXML
    private TextField txtFechaNaciFuncMod;

    @FXML
    private TextField txtDirFuncMod;

    @FXML
    private TextField txtTelFuncMod;

    @FXML
    private Button butModFunc;

    @FXML
    private Button butBuscarFuncAct;

    @FXML
    private Label labCodTiSolicitudMod;

    @FXML
    private TextField txtCodTiSolicitudMod;

    @FXML
    private Button butModTiSolicitud;

    @FXML
    private Label labDecTiSolicitudMod;

    @FXML
    private TextField txtDecTiSolicitudMod;

    @FXML
    private Button butBuscarTiSolicAct;

    @FXML
    private Label labNombClientBorrar;

    @FXML
    private Label labCedulaClientBorrar;

    @FXML
    private Label labFechaNaciClientBorrar;

    @FXML
    private Label labDirClientBorrar;

    @FXML
    private Label labTelClientBorrar;

    @FXML
    private TextField txtNombClientBorrar;

    @FXML
    private TextField txtCedulaClientBorrar;

    @FXML
    private TextField txtFechaNaciClientBorrar;

    @FXML
    private TextField txtDirClientBorrar;

    @FXML
    private TextField txtTelClientBorrar;

    @FXML
    private Button butBorrarClient;

    @FXML
    private Button butBuscarClientElim;

    @FXML
    private Label labCodTiProductoBorrar;

    @FXML
    private TextField txtCodTiProductoBorrar;

    @FXML
    private Button butBorrarTiProducto;

    @FXML
    private Label labDescTiProductoBorrar;

    @FXML
    private TextField txtDescTiProductoBorrar;

    @FXML
    private Button butBuscarTiProductElim;

    @FXML
    private Label labNombFuncBorrar;

    @FXML
    private Label labCedulaFuncBorrar;

    @FXML
    private Label labFechaNaciFuncBorrar;

    @FXML
    private Label labDirFuncBorrar;

    @FXML
    private Label labTelFuncBorrar;

    @FXML
    private TextField txtNombFuncBorrar;

    @FXML
    private TextField txtCedulaFuncBorrar;

    @FXML
    private TextField txtFechaNaciFuncBorrar;

    @FXML
    private TextField txtDirFuncBorrar;

    @FXML
    private TextField txtTelFuncBorrar;

    @FXML
    private Button butBorrarFunc;

    @FXML
    private Button butBuscarFuncElim;

    @FXML
    private Label labCodTiSolicitudBorrar;

    @FXML
    private TextField txtCodTiSolicitudBorrar;

    @FXML
    private Button butBorrarTiSolicitud;

    @FXML
    private Label labDecTiSolicitudBorrar;

    @FXML
    private TextField txtDecTiSolicitudBorrar;

    @FXML
    private Button butBuscarTiSolicElim;

	public TextField getTxtNombClientCrear() {
		return txtNombClientCrear;
	}

	public void setTxtNombClientCrear(TextField txtNombClientCrear) {
		this.txtNombClientCrear = txtNombClientCrear;
	}

	public TextField getTxtCedulaClientCrear() {
		return txtCedulaClientCrear;
	}

	public void setTxtCedulaClientCrear(TextField txtCedulaClientCrear) {
		this.txtCedulaClientCrear = txtCedulaClientCrear;
	}

	public TextField getTxtFechaNaciClientCrear() {
		return txtFechaNaciClientCrear;
	}

	public void setTxtFechaNaciClientCrear(TextField txtFechaNaciClientCrear) {
		this.txtFechaNaciClientCrear = txtFechaNaciClientCrear;
	}

	public TextField getTxtDirClientCrear() {
		return txtDirClientCrear;
	}

	public void setTxtDirClientCrear(TextField txtDirClientCrear) {
		this.txtDirClientCrear = txtDirClientCrear;
	}

	public TextField getTxtTelClientCrear() {
		return txtTelClientCrear;
	}

	public void setTxtTelClientCrear(TextField txtTelClientCrear) {
		this.txtTelClientCrear = txtTelClientCrear;
	}

	public TextField getTxtCodTiProductoCrear() {
		return txtCodTiProductoCrear;
	}

	public void setTxtCodTiProductoCrear(TextField txtCodTiProductoCrear) {
		this.txtCodTiProductoCrear = txtCodTiProductoCrear;
	}

	public TextField getTxtDescTiProductoCrear() {
		return txtDescTiProductoCrear;
	}

	public void setTxtDescTiProductoCrear(TextField txtDescTiProductoCrear) {
		this.txtDescTiProductoCrear = txtDescTiProductoCrear;
	}

	public TextField getTxtNombFuncCrear() {
		return txtNombFuncCrear;
	}

	public void setTxtNombFuncCrear(TextField txtNombFuncCrear) {
		this.txtNombFuncCrear = txtNombFuncCrear;
	}

	public TextField getTxtCedulaFuncCrear() {
		return txtCedulaFuncCrear;
	}

	public void setTxtCedulaFuncCrear(TextField txtCedulaFuncCrear) {
		this.txtCedulaFuncCrear = txtCedulaFuncCrear;
	}

	public TextField getTxtFechaNaciFuncCrear() {
		return txtFechaNaciFuncCrear;
	}

	public void setTxtFechaNaciFuncCrear(TextField txtFechaNaciFuncCrear) {
		this.txtFechaNaciFuncCrear = txtFechaNaciFuncCrear;
	}

	public TextField getTxtDirFuncCrear() {
		return txtDirFuncCrear;
	}

	public void setTxtDirFuncCrear(TextField txtDirFuncCrear) {
		this.txtDirFuncCrear = txtDirFuncCrear;
	}

	public TextField getTxtTelFuncCrear() {
		return txtTelFuncCrear;
	}

	public void setTxtTelFuncCrear(TextField txtTelFuncCrear) {
		this.txtTelFuncCrear = txtTelFuncCrear;
	}

	public TextField getTxtCodTiSolicitudCrear() {
		return txtCodTiSolicitudCrear;
	}

	public void setTxtCodTiSolicitudCrear(TextField txtCodTiSolicitudCrear) {
		this.txtCodTiSolicitudCrear = txtCodTiSolicitudCrear;
	}

	public TextField getTxtDecTiSolicitudCrear() {
		return txtDecTiSolicitudCrear;
	}

	public void setTxtDecTiSolicitudCrear(TextField txtDecTiSolicitudCrear) {
		this.txtDecTiSolicitudCrear = txtDecTiSolicitudCrear;
	}

	public TextField getTxtNombClientMod() {
		return txtNombClientMod;
	}

	public void setTxtNombClientMod(TextField txtNombClientMod) {
		this.txtNombClientMod = txtNombClientMod;
	}

	public TextField getTxtCedulaClientMod() {
		return txtCedulaClientMod;
	}

	public void setTxtCedulaClientMod(TextField txtCedulaClientMod) {
		this.txtCedulaClientMod = txtCedulaClientMod;
	}

	public TextField getTxtFechaNaciClientMod() {
		return txtFechaNaciClientMod;
	}

	public void setTxtFechaNaciClientMod(TextField txtFechaNaciClientMod) {
		this.txtFechaNaciClientMod = txtFechaNaciClientMod;
	}

	public TextField getTxtDirClientMod() {
		return txtDirClientMod;
	}

	public void setTxtDirClientMod(TextField txtDirClientMod) {
		this.txtDirClientMod = txtDirClientMod;
	}

	public TextField getTxtTelClientMod() {
		return txtTelClientMod;
	}

	public void setTxtTelClientMod(TextField txtTelClientMod) {
		this.txtTelClientMod = txtTelClientMod;
	}

	public TextField getTxtCodTiProductoMod() {
		return txtCodTiProductoMod;
	}

	public void setTxtCodTiProductoMod(TextField txtCodTiProductoMod) {
		this.txtCodTiProductoMod = txtCodTiProductoMod;
	}

	public TextField getTxtDescTiProductoMod() {
		return txtDescTiProductoMod;
	}

	public void setTxtDescTiProductoMod(TextField txtDescTiProductoMod) {
		this.txtDescTiProductoMod = txtDescTiProductoMod;
	}

	public TextField getTxtNombFuncMod() {
		return txtNombFuncMod;
	}

	public void setTxtNombFuncMod(TextField txtNombFuncMod) {
		this.txtNombFuncMod = txtNombFuncMod;
	}

	public TextField getTxtCedulaFuncMod() {
		return txtCedulaFuncMod;
	}

	public void setTxtCedulaFuncMod(TextField txtCedulaFuncMod) {
		this.txtCedulaFuncMod = txtCedulaFuncMod;
	}

	public TextField getTxtFechaNaciFuncMod() {
		return txtFechaNaciFuncMod;
	}

	public void setTxtFechaNaciFuncMod(TextField txtFechaNaciFuncMod) {
		this.txtFechaNaciFuncMod = txtFechaNaciFuncMod;
	}

	public TextField getTxtDirFuncMod() {
		return txtDirFuncMod;
	}

	public void setTxtDirFuncMod(TextField txtDirFuncMod) {
		this.txtDirFuncMod = txtDirFuncMod;
	}

	public TextField getTxtTelFuncMod() {
		return txtTelFuncMod;
	}

	public void setTxtTelFuncMod(TextField txtTelFuncMod) {
		this.txtTelFuncMod = txtTelFuncMod;
	}

	public TextField getTxtCodTiSolicitudMod() {
		return txtCodTiSolicitudMod;
	}

	public void setTxtCodTiSolicitudMod(TextField txtCodTiSolicitudMod) {
		this.txtCodTiSolicitudMod = txtCodTiSolicitudMod;
	}

	public TextField getTxtDecTiSolicitudMod() {
		return txtDecTiSolicitudMod;
	}

	public void setTxtDecTiSolicitudMod(TextField txtDecTiSolicitudMod) {
		this.txtDecTiSolicitudMod = txtDecTiSolicitudMod;
	}

	public TextField getTxtNombClientBorrar() {
		return txtNombClientBorrar;
	}

	public void setTxtNombClientBorrar(TextField txtNombClientBorrar) {
		this.txtNombClientBorrar = txtNombClientBorrar;
	}

	public TextField getTxtCedulaClientBorrar() {
		return txtCedulaClientBorrar;
	}

	public void setTxtCedulaClientBorrar(TextField txtCedulaClientBorrar) {
		this.txtCedulaClientBorrar = txtCedulaClientBorrar;
	}

	public TextField getTxtFechaNaciClientBorrar() {
		return txtFechaNaciClientBorrar;
	}

	public void setTxtFechaNaciClientBorrar(TextField txtFechaNaciClientBorrar) {
		this.txtFechaNaciClientBorrar = txtFechaNaciClientBorrar;
	}

	public TextField getTxtDirClientBorrar() {
		return txtDirClientBorrar;
	}

	public void setTxtDirClientBorrar(TextField txtDirClientBorrar) {
		this.txtDirClientBorrar = txtDirClientBorrar;
	}

	public TextField getTxtTelClientBorrar() {
		return txtTelClientBorrar;
	}

	public void setTxtTelClientBorrar(TextField txtTelClientBorrar) {
		this.txtTelClientBorrar = txtTelClientBorrar;
	}

	public TextField getTxtCodTiProductoBorrar() {
		return txtCodTiProductoBorrar;
	}

	public void setTxtCodTiProductoBorrar(TextField txtCodTiProductoBorrar) {
		this.txtCodTiProductoBorrar = txtCodTiProductoBorrar;
	}

	public TextField getTxtDescTiProductoBorrar() {
		return txtDescTiProductoBorrar;
	}

	public void setTxtDescTiProductoBorrar(TextField txtDescTiProductoBorrar) {
		this.txtDescTiProductoBorrar = txtDescTiProductoBorrar;
	}

	public TextField getTxtNombFuncBorrar() {
		return txtNombFuncBorrar;
	}

	public void setTxtNombFuncBorrar(TextField txtNombFuncBorrar) {
		this.txtNombFuncBorrar = txtNombFuncBorrar;
	}

	public TextField getTxtCedulaFuncBorrar() {
		return txtCedulaFuncBorrar;
	}

	public void setTxtCedulaFuncBorrar(TextField txtCedulaFuncBorrar) {
		this.txtCedulaFuncBorrar = txtCedulaFuncBorrar;
	}

	public TextField getTxtFechaNaciFuncBorrar() {
		return txtFechaNaciFuncBorrar;
	}

	public void setTxtFechaNaciFuncBorrar(TextField txtFechaNaciFuncBorrar) {
		this.txtFechaNaciFuncBorrar = txtFechaNaciFuncBorrar;
	}

	public TextField getTxtDirFuncBorrar() {
		return txtDirFuncBorrar;
	}

	public void setTxtDirFuncBorrar(TextField txtDirFuncBorrar) {
		this.txtDirFuncBorrar = txtDirFuncBorrar;
	}

	public TextField getTxtTelFuncBorrar() {
		return txtTelFuncBorrar;
	}

	public void setTxtTelFuncBorrar(TextField txtTelFuncBorrar) {
		this.txtTelFuncBorrar = txtTelFuncBorrar;
	}

	public TextField getTxtCodTiSolicitudBorrar() {
		return txtCodTiSolicitudBorrar;
	}

	public void setTxtCodTiSolicitudBorrar(TextField txtCodTiSolicitudBorrar) {
		this.txtCodTiSolicitudBorrar = txtCodTiSolicitudBorrar;
	}

	public TextField getTxtDecTiSolicitudBorrar() {
		return txtDecTiSolicitudBorrar;
	}

	public void setTxtDecTiSolicitudBorrar(TextField txtDecTiSolicitudBorrar) {
		this.txtDecTiSolicitudBorrar = txtDecTiSolicitudBorrar;
	}

	public Button getButAgregarClient() {
		return butAgregarClient;
	}

	public Button getButAgregarTiProducto() {
		return butAgregarTiProducto;
	}

	public Button getButAgregarFunc() {
		return butAgregarFunc;
	}

	public Button getButAgregarTiSolicitud() {
		return butAgregarTiSolicitud;
	}

	public Button getButModClient() {
		return butModClient;
	}

	public Button getButBuscarClientAct() {
		return butBuscarClientAct;
	}

	public Button getButModTiProducto() {
		return butModTiProducto;
	}

	public Button getButBuscarTiProductAct() {
		return butBuscarTiProductAct;
	}

	public Button getButModFunc() {
		return butModFunc;
	}

	public Button getButBuscarFuncAct() {
		return butBuscarFuncAct;
	}

	public Button getButModTiSolicitud() {
		return butModTiSolicitud;
	}

	public Button getButBuscarTiSolicAct() {
		return butBuscarTiSolicAct;
	}

	public Button getButBorrarClient() {
		return butBorrarClient;
	}

	public Button getButBuscarClientElim() {
		return butBuscarClientElim;
	}

	public Button getButBorrarTiProducto() {
		return butBorrarTiProducto;
	}

	public Button getButBuscarTiProductElim() {
		return butBuscarTiProductElim;
	}

	public Button getButBorrarFunc() {
		return butBorrarFunc;
	}

	public Button getButBuscarFuncElim() {
		return butBuscarFuncElim;
	}

	public Button getButBorrarTiSolicitud() {
		return butBorrarTiSolicitud;
	}

	public Button getButBuscarTiSolicElim() {
		return butBuscarTiSolicElim;
	}
    
    

}
