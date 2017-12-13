package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;

public class BuscarPersona extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private static BuscarPersona inst = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarPersona frame = new BuscarPersona();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public static BuscarPersona getInstance(){
		if(inst == null){
			inst = new BuscarPersona();
		}
		return inst;
	}
	/**
	 * Create the frame.
	 */
	public BuscarPersona() {
		setTitle("Personas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBuscarPaciente = new JLabel("Buscar Persona");
		lblBuscarPaciente.setBounds(10, 11, 144, 14);
		contentPane.add(lblBuscarPaciente);

		textField = new JTextField();
		textField.setBounds(10, 27, 231, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JList list = new JList();
		list.setBounds(10, 72, 331, 127);
		contentPane.add(list);

		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(216, 228, 89, 23);
		contentPane.add(btnSeleccionar);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btnVolver){
					MenuPrincipal mp = MenuPrincipal.getInstance();
					mp.setVisible(true);
					inst.setVisible(false);
				}
				
			}
		});
		btnVolver.setBounds(315, 228, 89, 23);
		contentPane.add(btnVolver);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
