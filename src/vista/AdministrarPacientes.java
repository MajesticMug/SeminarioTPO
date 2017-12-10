package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdministrarPacientes extends JFrame {

	private JPanel contentPane;
	private static AdministrarPacientes inst = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministrarPacientes frame = new AdministrarPacientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	public static AdministrarPacientes getInstance(){
		if(inst == null){
			inst = new AdministrarPacientes();
		}
		return inst;
	}
	
	
	/**
	 * Create the frame.
	 */
	public AdministrarPacientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPacientes = new JLabel("Listado de Pacientes");
		lblPacientes.setBounds(10, 11, 190, 14);
		contentPane.add(lblPacientes);
		
		JList list = new JList();
		list.setBounds(20, 36, 287, 179);
		DefaultListModel<String> modeloList = new DefaultListModel();
		modeloList.addElement("Paciente 1");
		modeloList.addElement("Paciente 2");
		modeloList.addElement("Paciente 3");
		list.setModel(modeloList);
		contentPane.add(list);
		
		JButton btnAdministrar = new JButton("Administrar");
		btnAdministrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnAdministrar){
					Pacientes o = Pacientes.getInstance();
					o.setVisible(true);
					inst.setVisible(false);
				}	
			}
		});
		btnAdministrar.setBounds(173, 226, 119, 23);
		contentPane.add(btnAdministrar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnVolver){
					MenuPrincipal o = MenuPrincipal.getInstance();
					o.setVisible(true);
					inst.setVisible(false);
				}
				
			}
		});
		btnVolver.setBounds(302, 226, 89, 23);
		contentPane.add(btnVolver);
	}
}