package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;

public class VentanaRegistro extends JInternalFrame {
	private JTextField textField_numero_solicitud;
	private JTextField textField_observaciones;
	private JTextField textField_causa;
	private JTextField textField_comentario_funcionario;
	private JTextField textField_cedula_cliente;
	private JTextField textField_codigo_estado;
	private JTextField textField_cedula_funcionario;
	private JTextField textField_anomalia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaRegistro() {
		setTitle("Ventana de registro de solicitudes");
		setBounds(100, 100, 450, 342);
		
		JPanel panel_Solicitud = new JPanel();
		panel_Solicitud.setBorder(new TitledBorder(null, "Datos de la solicitud", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_Solicitud, BorderLayout.NORTH);
		panel_Solicitud.setLayout(new GridLayout(6, 2, 0, 0));
		
		JLabel lblNumeroDeSolicitud = new JLabel("Numero de solicitud:");
		panel_Solicitud.add(lblNumeroDeSolicitud);
		
		textField_numero_solicitud = new JTextField();
		panel_Solicitud.add(textField_numero_solicitud);
		textField_numero_solicitud.setColumns(10);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		panel_Solicitud.add(lblObservaciones);
		
		textField_observaciones = new JTextField();
		panel_Solicitud.add(textField_observaciones);
		textField_observaciones.setColumns(10);
		
		JLabel lblCausa = new JLabel("Causa:");
		panel_Solicitud.add(lblCausa);
		
		textField_causa = new JTextField();
		panel_Solicitud.add(textField_causa);
		textField_causa.setColumns(10);
		
		JLabel lblComentarioDelFuncionario = new JLabel("Comentario del funcionario:");
		panel_Solicitud.add(lblComentarioDelFuncionario);
		
		textField_comentario_funcionario = new JTextField();
		panel_Solicitud.add(textField_comentario_funcionario);
		textField_comentario_funcionario.setColumns(10);
		
		JPanel panel_fecha_asignacion = new JPanel();
		panel_Solicitud.add(panel_fecha_asignacion);
		panel_fecha_asignacion.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblFechaAsignacin = new JLabel("Fecha asignaci\u00F3n:");
		panel_fecha_asignacion.add(lblFechaAsignacin);
		
		JPanel panel_fecha_atencion = new JPanel();
		panel_Solicitud.add(panel_fecha_atencion);
		panel_fecha_atencion.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblFechaAtencin = new JLabel("Fecha atenci\u00F3n:");
		panel_fecha_atencion.add(lblFechaAtencin);
		
		JPanel panel_relaciones_entidades = new JPanel();
		getContentPane().add(panel_relaciones_entidades, BorderLayout.CENTER);
		GridBagLayout gbl_panel_relaciones_entidades = new GridBagLayout();
		gbl_panel_relaciones_entidades.columnWidths = new int[]{283, 140, 0};
		gbl_panel_relaciones_entidades.rowHeights = new int[]{20, 20, 20, 20, 20, 0};
		gbl_panel_relaciones_entidades.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_relaciones_entidades.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_relaciones_entidades.setLayout(gbl_panel_relaciones_entidades);
		
		JPanel panel_cedula_cliente = new JPanel();
		GridBagConstraints gbc_panel_cedula_cliente = new GridBagConstraints();
		gbc_panel_cedula_cliente.fill = GridBagConstraints.BOTH;
		gbc_panel_cedula_cliente.insets = new Insets(0, 0, 5, 5);
		gbc_panel_cedula_cliente.gridx = 0;
		gbc_panel_cedula_cliente.gridy = 0;
		panel_relaciones_entidades.add(panel_cedula_cliente, gbc_panel_cedula_cliente);
		panel_cedula_cliente.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblCedulaDelCliente = new JLabel("Cedula del cliente:");
		panel_cedula_cliente.add(lblCedulaDelCliente);
		
		textField_cedula_cliente = new JTextField();
		panel_cedula_cliente.add(textField_cedula_cliente);
		textField_cedula_cliente.setColumns(10);
		
		JButton btnCrearCliente = new JButton("Crear Cliente");
		GridBagConstraints gbc_btnCrearCliente = new GridBagConstraints();
		gbc_btnCrearCliente.fill = GridBagConstraints.BOTH;
		gbc_btnCrearCliente.insets = new Insets(0, 0, 5, 0);
		gbc_btnCrearCliente.gridx = 1;
		gbc_btnCrearCliente.gridy = 0;
		panel_relaciones_entidades.add(btnCrearCliente, gbc_btnCrearCliente);
		
		JPanel panel_codigo_estado = new JPanel();
		GridBagConstraints gbc_panel_codigo_estado = new GridBagConstraints();
		gbc_panel_codigo_estado.fill = GridBagConstraints.BOTH;
		gbc_panel_codigo_estado.insets = new Insets(0, 0, 5, 5);
		gbc_panel_codigo_estado.gridx = 0;
		gbc_panel_codigo_estado.gridy = 1;
		panel_relaciones_entidades.add(panel_codigo_estado, gbc_panel_codigo_estado);
		panel_codigo_estado.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblCodigoDeEstado = new JLabel("Codigo de estado:");
		panel_codigo_estado.add(lblCodigoDeEstado);
		
		textField_codigo_estado = new JTextField();
		panel_codigo_estado.add(textField_codigo_estado);
		textField_codigo_estado.setColumns(10);
		
		JButton btnCrearEstado = new JButton("Crear Estado");
		GridBagConstraints gbc_btnCrearEstado = new GridBagConstraints();
		gbc_btnCrearEstado.fill = GridBagConstraints.BOTH;
		gbc_btnCrearEstado.insets = new Insets(0, 0, 5, 0);
		gbc_btnCrearEstado.gridx = 1;
		gbc_btnCrearEstado.gridy = 1;
		panel_relaciones_entidades.add(btnCrearEstado, gbc_btnCrearEstado);
		
		JPanel panel_funcionario_cedula = new JPanel();
		GridBagConstraints gbc_panel_funcionario_cedula = new GridBagConstraints();
		gbc_panel_funcionario_cedula.fill = GridBagConstraints.BOTH;
		gbc_panel_funcionario_cedula.insets = new Insets(0, 0, 5, 5);
		gbc_panel_funcionario_cedula.gridx = 0;
		gbc_panel_funcionario_cedula.gridy = 2;
		panel_relaciones_entidades.add(panel_funcionario_cedula, gbc_panel_funcionario_cedula);
		panel_funcionario_cedula.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblCedulaDelFuncionario = new JLabel("Cedula del funcionario:");
		panel_funcionario_cedula.add(lblCedulaDelFuncionario);
		
		textField_cedula_funcionario = new JTextField();
		panel_funcionario_cedula.add(textField_cedula_funcionario);
		textField_cedula_funcionario.setColumns(10);
		
		JButton btnCrearFuncionario = new JButton("Crear funcionario");
		GridBagConstraints gbc_btnCrearFuncionario = new GridBagConstraints();
		gbc_btnCrearFuncionario.fill = GridBagConstraints.BOTH;
		gbc_btnCrearFuncionario.insets = new Insets(0, 0, 5, 0);
		gbc_btnCrearFuncionario.gridx = 1;
		gbc_btnCrearFuncionario.gridy = 2;
		panel_relaciones_entidades.add(btnCrearFuncionario, gbc_btnCrearFuncionario);
		
		JPanel panel_anomalia = new JPanel();
		GridBagConstraints gbc_panel_anomalia = new GridBagConstraints();
		gbc_panel_anomalia.fill = GridBagConstraints.BOTH;
		gbc_panel_anomalia.insets = new Insets(0, 0, 5, 5);
		gbc_panel_anomalia.gridx = 0;
		gbc_panel_anomalia.gridy = 3;
		panel_relaciones_entidades.add(panel_anomalia, gbc_panel_anomalia);
		panel_anomalia.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblAnomalia = new JLabel("Tipo de anomalia:");
		panel_anomalia.add(lblAnomalia);
		
		textField_anomalia = new JTextField();
		panel_anomalia.add(textField_anomalia);
		textField_anomalia.setColumns(10);
		
		JButton btnCrearAnomalia = new JButton("Crear anomalia");
		GridBagConstraints gbc_btnCrearAnomalia = new GridBagConstraints();
		gbc_btnCrearAnomalia.fill = GridBagConstraints.BOTH;
		gbc_btnCrearAnomalia.insets = new Insets(0, 0, 5, 0);
		gbc_btnCrearAnomalia.gridx = 1;
		gbc_btnCrearAnomalia.gridy = 3;
		panel_relaciones_entidades.add(btnCrearAnomalia, gbc_btnCrearAnomalia);
		
		JLabel lblTipoDeSolicitud = new JLabel("Tipo de solicitud:");
		GridBagConstraints gbc_lblTipoDeSolicitud = new GridBagConstraints();
		gbc_lblTipoDeSolicitud.fill = GridBagConstraints.BOTH;
		gbc_lblTipoDeSolicitud.insets = new Insets(0, 0, 0, 5);
		gbc_lblTipoDeSolicitud.gridx = 0;
		gbc_lblTipoDeSolicitud.gridy = 4;
		panel_relaciones_entidades.add(lblTipoDeSolicitud, gbc_lblTipoDeSolicitud);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Solicitud", "Da\u00F1o", "Reclamo"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 4;
		panel_relaciones_entidades.add(comboBox, gbc_comboBox);
		
		JPanel panel_botones = new JPanel();
		getContentPane().add(panel_botones, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_botones = new GridBagLayout();
		gbl_panel_botones.columnWidths = new int[]{137, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_botones.rowHeights = new int[]{23, 0};
		gbl_panel_botones.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_botones.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_botones.setLayout(gbl_panel_botones);
		
		JButton btnRegistrar = new JButton("Registrar Solicitud");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnRegistrar = new GridBagConstraints();
		gbc_btnRegistrar.gridx = 6;
		gbc_btnRegistrar.gridy = 0;
		panel_botones.add(btnRegistrar, gbc_btnRegistrar);

	}

}
