package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pendientes extends JFrame {

	private JPanel contentPane;
	private static Pendientes inst = null; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pendientes frame = new Pendientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public static Pendientes getInstance(){
		if(inst == null){
			inst = new Pendientes();
		}
		return inst;
	}
	
	
	/**
	 * Create the frame.
	 */
	public Pendientes() {
		setTitle("Pendientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setToolTipText("Trabajos Pendientes");
		textPane.setBounds(10, 25, 482, 202);
		contentPane.add(textPane);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btnVolver){
					HistoriaClinica mp = HistoriaClinica.getInstance();
					mp.setVisible(true);
					inst.setVisible(false);
				}
			}
		});
		btnVolver.setBounds(403, 238, 89, 23);
		contentPane.add(btnVolver);
		
		JLabel lblPendientesDelPaciente = new JLabel("Pendientes del Paciente");
		lblPendientesDelPaciente.setBounds(0, 0, 147, 14);
		contentPane.add(lblPendientesDelPaciente);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(300, 238, 89, 23);
		contentPane.add(btnGuardar);
	}

}
