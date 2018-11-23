package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class VentanaConsultas extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldConsulta_Funcionario;
	private JTextField textField_consulta_cliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConsultas frame = new VentanaConsultas();
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
	public VentanaConsultas() {
		setTitle("Consultas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_superior = new JPanel();
		/**
		 * Aqui en esta parte agrego el borde superior y se configura los layouts
		 */
		panel_superior.setBorder(new TitledBorder(null, "Busquedas a realizar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_superior, BorderLayout.NORTH);
		GridBagLayout gbl_panel_superior = new GridBagLayout();
		gbl_panel_superior.columnWidths = new int[] {141, 203, 86, 0};
		gbl_panel_superior.rowHeights = new int[] {10, 10, 10, 10, 0};
		gbl_panel_superior.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_superior.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_superior.setLayout(gbl_panel_superior);
		
		/**
		 * Se aqui en adelante se agregan los elementos del panel superior como labels y cuadros de texto para las busquedas
		 */
		
		JLabel lblConsultaDeSolicitudes = new JLabel("Consulta de solicitudes asignadas por funcionario:");
		GridBagConstraints gbc_lblConsultaDeSolicitudes = new GridBagConstraints();
		gbc_lblConsultaDeSolicitudes.fill = GridBagConstraints.BOTH;
		gbc_lblConsultaDeSolicitudes.insets = new Insets(0, 0, 5, 5);
		gbc_lblConsultaDeSolicitudes.gridx = 0;
		gbc_lblConsultaDeSolicitudes.gridy = 0;
		panel_superior.add(lblConsultaDeSolicitudes, gbc_lblConsultaDeSolicitudes);
		
		textFieldConsulta_Funcionario = new JTextField();
		GridBagConstraints gbc_textFieldConsulta_Funcionario = new GridBagConstraints();
		gbc_textFieldConsulta_Funcionario.fill = GridBagConstraints.BOTH;
		gbc_textFieldConsulta_Funcionario.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldConsulta_Funcionario.gridx = 1;
		gbc_textFieldConsulta_Funcionario.gridy = 0;
		panel_superior.add(textFieldConsulta_Funcionario, gbc_textFieldConsulta_Funcionario);
		textFieldConsulta_Funcionario.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnConsultar = new GridBagConstraints();
		gbc_btnConsultar.fill = GridBagConstraints.BOTH;
		gbc_btnConsultar.insets = new Insets(0, 0, 5, 0);
		gbc_btnConsultar.gridx = 2;
		gbc_btnConsultar.gridy = 0;
		panel_superior.add(btnConsultar, gbc_btnConsultar);
		
		JLabel lblConsultaDeSolicitudes_1 = new JLabel("Consulta de solicitudes por estado:");
		GridBagConstraints gbc_lblConsultaDeSolicitudes_1 = new GridBagConstraints();
		gbc_lblConsultaDeSolicitudes_1.fill = GridBagConstraints.BOTH;
		gbc_lblConsultaDeSolicitudes_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblConsultaDeSolicitudes_1.gridx = 0;
		gbc_lblConsultaDeSolicitudes_1.gridy = 1;
		panel_superior.add(lblConsultaDeSolicitudes_1, gbc_lblConsultaDeSolicitudes_1);
		
		JComboBox comboBox_tipo_estado = new JComboBox();
		comboBox_tipo_estado.setModel(new DefaultComboBoxModel(new String[] {"Asignada", "Pendiente"}));
		GridBagConstraints gbc_comboBox_tipo_estado = new GridBagConstraints();
		gbc_comboBox_tipo_estado.fill = GridBagConstraints.BOTH;
		gbc_comboBox_tipo_estado.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_tipo_estado.gridx = 1;
		gbc_comboBox_tipo_estado.gridy = 1;
		panel_superior.add(comboBox_tipo_estado, gbc_comboBox_tipo_estado);
		
		JButton btnConsultar_1 = new JButton("Consultar");
		btnConsultar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnConsultar_1 = new GridBagConstraints();
		gbc_btnConsultar_1.fill = GridBagConstraints.BOTH;
		gbc_btnConsultar_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnConsultar_1.gridx = 2;
		gbc_btnConsultar_1.gridy = 1;
		panel_superior.add(btnConsultar_1, gbc_btnConsultar_1);
		
		JLabel lblConsultaDeSolicitudes_2 = new JLabel("Consulta de solicitudes por tipo:");
		GridBagConstraints gbc_lblConsultaDeSolicitudes_2 = new GridBagConstraints();
		gbc_lblConsultaDeSolicitudes_2.fill = GridBagConstraints.BOTH;
		gbc_lblConsultaDeSolicitudes_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblConsultaDeSolicitudes_2.gridx = 0;
		gbc_lblConsultaDeSolicitudes_2.gridy = 2;
		panel_superior.add(lblConsultaDeSolicitudes_2, gbc_lblConsultaDeSolicitudes_2);
		
		JComboBox comboBox_Tipo_Solicitud = new JComboBox();
		comboBox_Tipo_Solicitud.setModel(new DefaultComboBoxModel(new String[] {"Solicitud", "Da\u00F1o", "Reclamo"}));
		GridBagConstraints gbc_comboBox_Tipo_Solicitud = new GridBagConstraints();
		gbc_comboBox_Tipo_Solicitud.fill = GridBagConstraints.BOTH;
		gbc_comboBox_Tipo_Solicitud.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_Tipo_Solicitud.gridx = 1;
		gbc_comboBox_Tipo_Solicitud.gridy = 2;
		panel_superior.add(comboBox_Tipo_Solicitud, gbc_comboBox_Tipo_Solicitud);
		
		JButton btnConsultar_2 = new JButton("Consultar");
		btnConsultar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnConsultar_2 = new GridBagConstraints();
		gbc_btnConsultar_2.fill = GridBagConstraints.BOTH;
		gbc_btnConsultar_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnConsultar_2.gridx = 2;
		gbc_btnConsultar_2.gridy = 2;
		panel_superior.add(btnConsultar_2, gbc_btnConsultar_2);
		
		JLabel lblConsultasDeProductos = new JLabel("Consultas de productos por clientes:");
		GridBagConstraints gbc_lblConsultasDeProductos = new GridBagConstraints();
		gbc_lblConsultasDeProductos.fill = GridBagConstraints.BOTH;
		gbc_lblConsultasDeProductos.insets = new Insets(0, 0, 0, 5);
		gbc_lblConsultasDeProductos.gridx = 0;
		gbc_lblConsultasDeProductos.gridy = 3;
		panel_superior.add(lblConsultasDeProductos, gbc_lblConsultasDeProductos);
		
		textField_consulta_cliente = new JTextField();
		GridBagConstraints gbc_textField_consulta_cliente = new GridBagConstraints();
		gbc_textField_consulta_cliente.fill = GridBagConstraints.BOTH;
		gbc_textField_consulta_cliente.insets = new Insets(0, 0, 0, 5);
		gbc_textField_consulta_cliente.gridx = 1;
		gbc_textField_consulta_cliente.gridy = 3;
		panel_superior.add(textField_consulta_cliente, gbc_textField_consulta_cliente);
		textField_consulta_cliente.setColumns(10);
		
		JButton btnConsultar_3 = new JButton("Consultar");
		btnConsultar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnConsultar_3 = new GridBagConstraints();
		gbc_btnConsultar_3.fill = GridBagConstraints.BOTH;
		gbc_btnConsultar_3.gridx = 2;
		gbc_btnConsultar_3.gridy = 3;
		panel_superior.add(btnConsultar_3, gbc_btnConsultar_3);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setToolTipText("\r\n");
		contentPane.add(panel, BorderLayout.CENTER);
		
		/**
		 * En esta lista se agregan los resultados de las busquedas
		 */
		
		JList list_Consultas = new JList();
		panel.add(list_Consultas);
	}

}
