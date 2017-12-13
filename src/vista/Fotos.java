package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JList;

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
		setTitle("Fotos");
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
		panel.setBounds(335, 61, 145, 102);
		contentPane.add(panel);

		
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
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser;
				String dire = null;

				/*Creamos el objeto*/
				fileChooser=new JFileChooser();
				/*llamamos el metodo que permite cargar la ventana*/
				fileChooser.showOpenDialog(fileChooser);
				/*abrimos el archivo seleccionado*/ 			
				File abre = fileChooser.getSelectedFile();
				//Se asigna mismo nombre al txt
				dire  = abre.getPath();
				System.out.println(dire);
			}
		});
		btnAgregar.setBounds(244, 228, 89, 23);
		
		
		contentPane.add(btnAgregar);

		JList list = new JList();
		DefaultListModel<String> modeloList = new DefaultListModel();
		modeloList.addElement("/resources/img/fotoBocaPaciente1.jpg");
		modeloList.addElement("/resources/img/fotoBocaPaciente2.jpg");
		modeloList.addElement("/resources/img/fotoBocaPaciente3.jpg");
		list.setModel(modeloList);
		list.setBounds(10, 47, 307, 166);
		contentPane.add(list);
		
		JButton btnActualizar = new JButton("Visualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected = (String) list.getSelectedValue();
				panel.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource(selected)));
			}
		});
		btnActualizar.setBounds(355, 174, 100, 23);
		contentPane.add(btnActualizar);
		
	}
}
