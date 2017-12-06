package vista;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Panel;

public class MenuPrincipal {
	//PRUEBA ARAM
	//Prueba Gas
	//Prueba REni
	private JFrame frmCentroOdontolgicoIntegral;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					window.frmCentroOdontolgicoIntegral.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCentroOdontolgicoIntegral = new JFrame();
		frmCentroOdontolgicoIntegral.setTitle("Centro Odontol\u00F3gico Integral");
		frmCentroOdontolgicoIntegral.setBounds(100, 100, 450, 300);
		frmCentroOdontolgicoIntegral.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCentroOdontolgicoIntegral.getContentPane().setLayout(null);
		
		JButton btnPacientes = new JButton("Pacientes");
		btnPacientes.setBounds(10, 36, 89, 23);
		frmCentroOdontolgicoIntegral.getContentPane().add(btnPacientes);
		
		JButton btnEsecialistas = new JButton("Especialistas");
		btnEsecialistas.setBounds(109, 36, 89, 23);
		frmCentroOdontolgicoIntegral.getContentPane().add(btnEsecialistas);
		
		JButton btnTurnos = new JButton("Turnos");
		btnTurnos.setBounds(204, 36, 89, 23);
		frmCentroOdontolgicoIntegral.getContentPane().add(btnTurnos);
		
		JButton btnHistoriasClnicas = new JButton("Historias Cl\u00EDnicas");
		btnHistoriasClnicas.setBounds(10, 147, 111, 23);
		frmCentroOdontolgicoIntegral.getContentPane().add(btnHistoriasClnicas);
		
		JButton btnRadiografas = new JButton("Radiograf\u00EDas");
		btnRadiografas.setBounds(123, 147, 89, 23);
		frmCentroOdontolgicoIntegral.getContentPane().add(btnRadiografas);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(215, 147, 89, 23);
		frmCentroOdontolgicoIntegral.getContentPane().add(btnBuscar);
		
		JButton btnInformacin = new JButton("Informaci\u00F3n");
		btnInformacin.setBounds(308, 147, 89, 23);
		frmCentroOdontolgicoIntegral.getContentPane().add(btnInformacin);
		
		Panel panel = new Panel();
		panel.setBounds(308, 36, 116, 82);
		frmCentroOdontolgicoIntegral.getContentPane().add(panel);
		panel.setLayout(null);
//		Graphics g;
//		ImageIcon i = new ImageIcon(getClass().getResource(name))
//		panel.add(comp).
		
		JMenuBar menuBar = new JMenuBar();
		frmCentroOdontolgicoIntegral.setJMenuBar(menuBar);
		
		JMenuItem mntmArchivo = new JMenuItem("Archivo");
		menuBar.add(mntmArchivo);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		menuBar.add(mntmAcercaDe);
	}
}
