package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cronologia extends JFrame {

	private JPanel contentPane;

	private static Cronologia inst = null; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cronologia frame = new Cronologia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static Cronologia getInstance(){
		if(inst == null){
			inst = new Cronologia();
		}
		return inst;
	}
	
	/**
	 * Create the frame.
	 */
	public Cronologia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 11, 46, 14);
		contentPane.add(label);
		
		JLabel lblCronologiaDeAtencin = new JLabel("Cronologia de Atenci\u00F3n");
		lblCronologiaDeAtencin.setBounds(0, 0, 209, 14);
		contentPane.add(lblCronologiaDeAtencin);
		
		JTextPane textPane = new JTextPane();
		textPane.setToolTipText("Cronolog\u00EDa\r\n");
		textPane.setBounds(10, 25, 355, 205);
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
		btnVolver.setBounds(335, 241, 89, 23);
		contentPane.add(btnVolver);
	}

}
