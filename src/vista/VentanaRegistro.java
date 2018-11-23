package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class VentanaRegistro extends JInternalFrame {
	private JTextField textField_numero_solicitud;
	private JTextField textField_observaciones;
	private JTextField textField_causa;
	private JTextField textField_comentario_funcionario;

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
		setTitle("Ventana de registro");
		setBounds(100, 100, 450, 300);
		
		JPanel panel_Solicitud = new JPanel();
		panel_Solicitud.setBorder(new TitledBorder(null, "Datos de la solicitud", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_Solicitud, BorderLayout.CENTER);
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

	}

}
