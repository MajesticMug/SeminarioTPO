package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Sistema;
import modelo.Odontologo;
import modelo.Paciente;
import modelo.Radiologo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pacientes extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTipoDni;
	private JTextField txtNmero;
	private JTextField txtDireccin;
	private JTextField txtTelfono;
	private static Pacientes inst = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pacientes frame = new Pacientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static Pacientes getInstance(){
		if(inst == null){
			inst = new Pacientes();
		}
		return inst;
	}


	/**
	 * Create the frame.
	 */
	public Pacientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 518, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAgregarNuevoPaciente = new JLabel("Agregar Nuevo Paciente");
		lblAgregarNuevoPaciente.setBounds(10, 11, 214, 14);
		contentPane.add(lblAgregarNuevoPaciente);

		txtNombre = new JTextField();
		txtNombre.setToolTipText("Nombre");
		txtNombre.setText("Nombre");
		txtNombre.setBounds(10, 36, 214, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setToolTipText("Apellido");
		txtApellido.setText("Apellido");
		txtApellido.setBounds(10, 61, 214, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);

		txtTipoDni = new JTextField();
		txtTipoDni.setToolTipText("Tipo DNI");
		txtTipoDni.setText("Tipo DNI");
		txtTipoDni.setBounds(10, 85, 86, 20);
		contentPane.add(txtTipoDni);
		txtTipoDni.setColumns(10);

		txtNmero = new JTextField();
		txtNmero.setToolTipText("N\u00FAmero");
		txtNmero.setText("N\u00FAmero");
		txtNmero.setBounds(101, 86, 123, 20);
		contentPane.add(txtNmero);
		txtNmero.setColumns(10);

		txtDireccin = new JTextField();
		txtDireccin.setToolTipText("Direcci\u00F3n");
		txtDireccin.setText("Direcci\u00F3n");
		txtDireccin.setBounds(10, 108, 214, 20);
		contentPane.add(txtDireccin);
		txtDireccin.setColumns(10);

		txtTelfono = new JTextField();
		txtTelfono.setToolTipText("Tel\u00E9fono");
		txtTelfono.setText("Tel\u00E9fono");
		txtTelfono.setBounds(10, 128, 214, 20);
		contentPane.add(txtTelfono);
		txtTelfono.setColumns(10);

		JTextPane textPane = new JTextPane();
		textPane.setToolTipText("Detalle del Paciente");
		textPane.setBounds(10, 170, 291, 81);
		contentPane.add(textPane);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Paciente p = null;

				p.setApellido(txtApellido.getText());
				p.setApellido(txtNombre.getText());
				p.setTipoDocumento(txtTipoDni.getText());
				p.setNroDocumento( Integer.parseInt(txtNmero.getText()));
				p.setDomicilio(txtDireccin.getText());
				p.setTelefono(Integer.parseInt(txtTelfono.getText()));

				Sistema.getInstance().agregarPaciente(p);

			}
		});
		btnAgregar.setBounds(322, 159, 89, 23);
		contentPane.add(btnAgregar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Paciente pac = Sistema.getInstance().buscarPaciente(Integer.parseInt(txtNmero.getText()));
				if (pac == null){ Sistema.getInstance().eliminarPaciente(pac);}
				
			}
		});
		
		btnEliminar.setBounds(322, 193, 89, 23);
		contentPane.add(btnEliminar);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnVolver){
					AdministrarPacientes t = AdministrarPacientes.getInstance();
					t.setVisible(true);
					inst.setVisible(false);
				}
			}
		});
		btnVolver.setBounds(322, 228, 89, 23);
		contentPane.add(btnVolver);

		JPanelConFondo panelImagen = new JPanelConFondo();
		panelImagen.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/resources/img/Paciente1.jpg")));
		panelImagen.setBounds(265, 34, 123, 114);
		panelImagen.setLayout(null);
		contentPane.add(panelImagen);



	}

}
