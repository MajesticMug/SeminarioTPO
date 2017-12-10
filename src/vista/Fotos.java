package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fotos extends JFrame {

	private JPanel contentPane;
	private JTextField txtPaciente;
	private static Fotos inst = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fotos frame = new Fotos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static Fotos getInstance(){
		if(inst == null){
			inst = new Fotos();
		}
		return inst;
	}
	
	/**
	 * Create the frame.
	 */
	public Fotos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblFotosPaciente = new JLabel("Fotos Paciente");
		lblFotosPaciente.setBounds(10, 11, 114, 14);
		contentPane.add(lblFotosPaciente);
		
		txtPaciente = new JTextField();
		txtPaciente.setText("Ernesto Bonacua");
		txtPaciente.setEditable(false);
		txtPaciente.setBounds(134, 8, 200, 20);
		contentPane.add(txtPaciente);
		txtPaciente.setColumns(10);
		
		JPanelConFondo panel = new JPanelConFondo();
		panel.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/resources/img/fotoBocaPaciente1.jpg")));
		panel.setBounds(10, 45, 124, 82);
		contentPane.add(panel);
		
		JPanelConFondo panel_1 = new JPanelConFondo();
		panel_1.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/resources/img/fotoBocaPaciente2.jpg")));
		panel_1.setBounds(144, 45, 151, 77);
		contentPane.add(panel_1);
		
		JPanelConFondo panel_2 = new JPanelConFondo();
		panel_2.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/resources/img/fotoBocaPaciente3.jpg")));
		panel_2.setBounds(10, 138, 141, 93);
		contentPane.add(panel_2);

		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnVolver){
					HistoriaClinica t = HistoriaClinica.getInstance();
					t.setVisible(true);
					inst.setVisible(false);
				}
			}
		});
		btnVolver.setBounds(335, 228, 89, 23);
		contentPane.add(btnVolver);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(335, 194, 89, 23);
		contentPane.add(btnAgregar);
	}

}
