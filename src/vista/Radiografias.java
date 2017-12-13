package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Sistema;
import modelo.Paciente;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class Radiografias extends JFrame {

	private JPanel contentPane;
	private JTextField txtPaciente;
	private static Radiografias inst = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Radiografias frame = new Radiografias();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static Radiografias getInstance(int dniPaciente){
		if(inst == null){
			inst = new Radiografias(dniPaciente);
		}
		return inst;
	}
	
	/**
	 * Create the frame.
	 */
	public Radiografias(int dniPaciente) {
		Paciente pac = Sistema.getInstance().buscarPaciente(dniPaciente);
		setTitle("Radiograf\u00EDas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRadiografas = new JLabel("Radiograf\u00EDas ");
		lblRadiografas.setBounds(10, 11, 91, 14);
		contentPane.add(lblRadiografas);

		txtPaciente = new JTextField();
		txtPaciente.setEditable(false);
		//txtPaciente.setText("Ernesto Bonacua");
		txtPaciente.setText(pac.toString());
		txtPaciente.setBounds(80, 8, 229, 20);
		contentPane.add(txtPaciente);
		txtPaciente.setColumns(10);

		JList list = new JList();
		list.setBounds(21, 47, 229, 144);
		DefaultListModel<String> modeloList = new DefaultListModel();
		modeloList.addElement("/resources/img/Radiografias1.jpg");
		modeloList.addElement("/resources/img/Radiografias2.jpg");
		modeloList.addElement("/resources/img/Radiografias3.jpg");
		modeloList.addElement("/resources/img/Radiografias4.jpg");
		list.setModel(modeloList);
		contentPane.add(list);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		btnAgregar.setBounds(111, 228, 89, 23);
		contentPane.add(btnAgregar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnEliminar.setBounds(210, 228, 89, 23);
		contentPane.add(btnEliminar);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnVolver){
					HistoriaClinica mp = HistoriaClinica.getInstance(dniPaciente);
					mp.setVisible(true);
					inst.setVisible(false);
				}
			}
		});
		btnVolver.setBounds(309, 228, 89, 23);
		contentPane.add(btnVolver);

		JPanelConFondo panelRadiografia = new JPanelConFondo();
		panelRadiografia.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/resources/img/Radiografias1.jpg")));
		panelRadiografia.setBounds(260, 51, 164, 100);
		contentPane.add(panelRadiografia);
		panelRadiografia.setLayout(null); 

		JButton btnRefresh = new JButton("Visualizar");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected = (String) list.getSelectedValue();
				panelRadiografia.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource(selected)));
			}
		});
		btnRefresh.setBounds(294, 162, 104, 23);
		contentPane.add(btnRefresh);
	}

	public Radiografias() {
		// TODO Auto-generated constructor stub
	}}
