package vista;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AltaTurno extends JFrame
{

	private JFrame frmAltaTurno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					AltaTurno window = new AltaTurno();
					window.frmAltaTurno.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AltaTurno()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmAltaTurno = new JFrame();
		frmAltaTurno.setTitle("Alta Turno");
		frmAltaTurno.setBounds(100, 100, 450, 300);
		frmAltaTurno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		frmAltaTurno.setContentPane(contentPane);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(158, 126, 97, 20);
		contentPane.add(dateChooser);
		
		JComboBox hora = new JComboBox();
		hora.setModel(new DefaultComboBoxModel(new Integer[] {10, 11, 12, 13, 14, 15, 16, 17}));
		hora.setBounds(158, 155, 97, 22);
		contentPane.add(hora);
		
		JComboBox minutos = new JComboBox();
		minutos.setModel(new DefaultComboBoxModel(new Integer[] {0, 30}));
		minutos.setBounds(158, 188, 97, 22);
		contentPane.add(minutos);
		
		JLabel lblAltaTurno = new JLabel("Alta Turno");
		lblAltaTurno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAltaTurno.setBounds(176, 11, 79, 20);
		contentPane.add(lblAltaTurno);
		
		JLabel lblProfesional = new JLabel("Profesional");
		lblProfesional.setBounds(43, 52, 66, 14);
		contentPane.add(lblProfesional);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(43, 87, 46, 14);
		contentPane.add(lblPaciente);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(43, 126, 46, 14);
		contentPane.add(lblDia);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(43, 159, 46, 14);
		contentPane.add(lblHora);
		
		JLabel lblMinuto = new JLabel("Minuto");
		lblMinuto.setBounds(43, 189, 46, 14);
		contentPane.add(lblMinuto);
		
		JComboBox comboBoxProfesional = new JComboBox();
		comboBoxProfesional.setBounds(158, 48, 97, 22);
		contentPane.add(comboBoxProfesional);
		
		JComboBox comboBoxPaciente = new JComboBox();
		comboBoxPaciente.setBounds(158, 83, 97, 22);
		contentPane.add(comboBoxPaciente);
		
		JButton btnAceptar_1 = new JButton("Aceptar");
		btnAceptar_1.setBounds(164, 239, 91, 23);
		contentPane.add(btnAceptar_1);
		btnAceptar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = dateChooser.getDate();
				//int prueba = (int) hora.getSelectedItem();
				date.setHours((int) hora.getSelectedItem());
				date.setMinutes((int) minutos.getSelectedItem());
				System.out.println("DATE CHOOSER "+date.toString());
			}
		});
	}
}
