package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Sistema;
import modelo.ConsentimientoTratamiento;
import modelo.FichaOdontologica;
import modelo.Paciente;
import modelo.PlanTratamiento;
import modelo.Radiografia;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class AltaHistoriaClinica extends JFrame {

	private JPanel contentPane;
	private static AltaHistoriaClinica inst = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaHistoriaClinica frame = new AltaHistoriaClinica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static AltaHistoriaClinica getInstance(){
		if(inst == null){
			inst = new AltaHistoriaClinica();
		}
		return inst;
	}
	/**
	 * Create the frame.
	 */
	public AltaHistoriaClinica() {
		setTitle("Alta de Historia Cl\u00EDnica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnVolver){
					BuscarHistoriaClinica mp = BuscarHistoriaClinica.getInstance();
					mp.setVisible(true);
					inst.setVisible(false);
				}
				
			}
		});
		btnVolver.setBounds(403, 232, 89, 23);
		contentPane.add(btnVolver);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String observaciones = null;
				Paciente paciente = null;
				List<Radiografia> radiografias = null;
				List<ConsentimientoTratamiento> consentimientosTratamiento = null;
				List<PlanTratamiento> planesTratamiento = null;
				List<FichaOdontologica> fichasOdontologicas = null;
			
				modelo.HistoriaClinica hist = new modelo.HistoriaClinica(observaciones, paciente, radiografias, consentimientosTratamiento, planesTratamiento, fichasOdontologicas);
				
				if(e.getSource()==btnAceptar){
					Sistema.getInstance().agregarHistoriaClinica(hist);
				}
			}
		});
		btnAceptar.setBounds(304, 232, 89, 23);
		contentPane.add(btnAceptar);
		
		JLabel lblNuevaHistoriaClnica = new JLabel("Nueva Historia Cl\u00EDnica");
		lblNuevaHistoriaClnica.setBounds(10, 11, 237, 14);
		contentPane.add(lblNuevaHistoriaClnica);
		
		JComboBox comboBox = new JComboBox();
		for (Paciente p : Sistema.getInstance().recuperarPacientes()) {
			comboBox.addItem(p);
		}
		comboBox.setBounds(144, 36, 183, 23);
		contentPane.add(comboBox);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(20, 36, 114, 14);
		contentPane.add(lblPaciente);
		
		JTextPane textPane = new JTextPane();
		textPane.setToolTipText("Observaciones");
		textPane.setBounds(10, 137, 352, 84);
		contentPane.add(textPane);
		
		JButton btnRadiografas = new JButton("Radiograf\u00EDas");
		btnRadiografas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btnRadiografas){
					RadiografiasAltaHC mp = RadiografiasAltaHC.getInstance();
					mp.setVisible(true);
					inst.setVisible(false);
				}
			}
		});
		btnRadiografas.setBounds(10, 73, 114, 23);
		contentPane.add(btnRadiografas);
		
		JButton btnConsentimientos = new JButton("Consentimientos");
		btnConsentimientos.setBounds(194, 73, 153, 23);
		contentPane.add(btnConsentimientos);
		
		JButton btnPlanesDeTratamiento = new JButton("Planes de Tratamiento");
		btnPlanesDeTratamiento.setBounds(10, 103, 168, 23);
		contentPane.add(btnPlanesDeTratamiento);
		
		JButton btnFichaOdontolgica = new JButton("Ficha Odontol\u00F3gica");
		btnFichaOdontolgica.setBounds(194, 103, 168, 23);
		contentPane.add(btnFichaOdontolgica);
	}
}
