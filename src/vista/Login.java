package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	private static Login inst=null;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtContrasea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static Login getInstance(){
		if(inst==null){
			inst = new Login();
		}
		return inst;
	}
	
	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menu = new MenuPrincipal();
			
			}
		});
		btnAceptar.setBounds(155, 185, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(250, 185, 89, 23);
		contentPane.add(btnCancelar);
		
		txtUsuario = new JTextField();
		txtUsuario.setText("Usuario");
		txtUsuario.setBounds(70, 67, 189, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContrasea = new JTextField();
		txtContrasea.setText("Contrase\u00F1a");
		txtContrasea.setBounds(70, 90, 189, 20);
		contentPane.add(txtContrasea);
		txtContrasea.setColumns(10);


		JPanelConFondo panelImagen = new JPanelConFondo();
		panelImagen.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/resources/img/Login.jpg")));
		panelImagen.setBounds(269, 48, 89, 79);
		panelImagen.setLayout(null);
		contentPane.add(panelImagen);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setBounds(30, 48, 46, 14);
		contentPane.add(lblLogin);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(70, 121, 199, 2);
		contentPane.add(separator);
		
		JCheckBox chckbxOlvideMiContrasea = new JCheckBox("Olvide mi contrase\u00F1a");
		chckbxOlvideMiContrasea.setBounds(70, 121, 189, 23);
		contentPane.add(chckbxOlvideMiContrasea);
		
		JCheckBox chckbxRegistrarNuevoUsuario = new JCheckBox("Registrar Nuevo Usuario");
		chckbxRegistrarNuevoUsuario.setBounds(70, 139, 189, 23);
		contentPane.add(chckbxRegistrarNuevoUsuario);
		
	}
}
