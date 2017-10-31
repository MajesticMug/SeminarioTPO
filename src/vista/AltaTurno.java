package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class AltaTurno
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
		frmAltaTurno.getContentPane().setLayout(null);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(10, 11, 46, 14);
		frmAltaTurno.getContentPane().add(lblFecha);
	}
}
