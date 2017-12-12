package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Sistema;
import modelo.Odontologo;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class AdministrarEspecialistas extends JFrame {

	private JPanel contentPane;
	private static AdministrarEspecialistas inst = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministrarEspecialistas frame = new AdministrarEspecialistas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public static AdministrarEspecialistas getInstance(){
		if(inst == null){
			inst = new AdministrarEspecialistas();
		}
		return inst;
	}
	
	
	/**
	 * Create the frame.
	 */
	public AdministrarEspecialistas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPacientes = new JLabel("Listado de Especialistas");
		lblPacientes.setBounds(10, 11, 190, 14);
		contentPane.add(lblPacientes);
		
		JList list = new JList();
		list.setBounds(20, 36, 287, 179);
		DefaultListModel<String> modeloList = new DefaultListModel();
//		List<Odontologo> listaEspecialistas = Sistema.getInstance().getOdontologos();
//		int i = 0;
//		while (i < listaEspecialistas.size()){
//			modeloList.addElement(listaEspecialistas.get(i).getNombre() +' '+ listaEspecialistas.get(i).getApellido());
//		}
		modeloList.addElement("Especialista 1");
		modeloList.addElement("Especialista 2");
		modeloList.addElement("Especialista 3");
		list.setModel(modeloList);
		contentPane.add(list);
		
		JButton btnAdministrar = new JButton("Administrar");
		btnAdministrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnAdministrar){
					Especialistas o = Especialistas.getInstance();
					o.setVisible(true);
					inst.setVisible(false);
				}	
				
			}
		});
		btnAdministrar.setBounds(174, 226, 118, 23);
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
