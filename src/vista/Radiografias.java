package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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

	public static Radiografias getInstance(){
		if(inst == null){
			inst = new Radiografias();
		}
		return inst;
	}
	
	/**
	 * Create the frame.
	 */
	public Radiografias() {
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
		txtPaciente.setText("Ernesto Bonacua");
		txtPaciente.setBounds(80, 8, 229, 20);
		contentPane.add(txtPaciente);
		txtPaciente.setColumns(10);

		JList list = new JList();
		list.setBounds(21, 47, 229, 144);
		contentPane.add(list);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(111, 228, 89, 23);
		contentPane.add(btnAceptar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(210, 228, 89, 23);
		contentPane.add(btnEliminar);

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
		btnVolver.setBounds(309, 228, 89, 23);
		contentPane.add(btnVolver);

		JPanelConFondo panelRadiografia = new JPanelConFondo();
		panelRadiografia.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/resources/img/Radiografias1.jpg")));
		panelRadiografia.setBounds(260, 51, 164, 100);
		contentPane.add(panelRadiografia);
		panelRadiografia.setLayout(null); 
	}}
