package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridBagLayout;
import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import persistencia.RadiografiaDAO;
import excepciones.ArchivoException;
import utils.ArchivoUtils;
import utils.HibernateUtil;
import modelo.Radiografia;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.Date;

public class GuardarImagenTest
{

	private JFrame frame;
	private JTextField txtRuta;
	
	private JFileChooser fc;
	private JButton btnGuardar;

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
					GuardarImagenTest window = new GuardarImagenTest();
					window.frame.setVisible(true);
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
	public GuardarImagenTest()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		txtRuta = new JTextField();
		txtRuta.setText("Ruta");
		GridBagConstraints gbc_txtRuta = new GridBagConstraints();
		gbc_txtRuta.insets = new Insets(0, 0, 5, 5);
		gbc_txtRuta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRuta.gridx = 6;
		gbc_txtRuta.gridy = 4;
		frame.getContentPane().add(txtRuta, gbc_txtRuta);
		txtRuta.setColumns(10);
		
		final JButton btnSeleccionarArchivo = new JButton("Seleccionar");
		fc = new JFileChooser();
		fc.setCurrentDirectory(new File("C:/"));
		fc.setDialogTitle("Radiografia");
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		btnSeleccionarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// showSaveDialog abre la ventana de seleccionar el archivo
				// APPROVE_OPTION significa que puso aceptar
				if (fc.showSaveDialog(btnSeleccionarArchivo) == JFileChooser.APPROVE_OPTION) {
					txtRuta.setText(fc.getSelectedFile().getAbsolutePath());
				}
			}
		});
		GridBagConstraints gbc_btnSeleccionar = new GridBagConstraints();
		gbc_btnSeleccionar.insets = new Insets(0, 0, 5, 0);
		gbc_btnSeleccionar.gridx = 7;
		gbc_btnSeleccionar.gridy = 4;
		frame.getContentPane().add(btnSeleccionarArchivo, gbc_btnSeleccionar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				guardarRadiografia();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridx = 7;
		gbc_btnGuardar.gridy = 8;
		frame.getContentPane().add(btnGuardar, gbc_btnGuardar);
	}


	private void guardarRadiografia()
	{		
		try
		{
			Date fecha = new Date(new java.util.Date().getTime());
			
			Radiografia rad = new Radiografia(fecha, null, null);
			
			rad.setImagen(ArchivoUtils.getArchivoArray(txtRuta.getText()));
			
			new RadiografiaDAO().save(rad);
			
			PopupImagenRadiografia popup = new PopupImagenRadiografia(rad);
			popup.setVisible(true);
		} catch (ArchivoException e)
		{
			JOptionPane.showMessageDialog(frame, "No se pudo leer el archivo.\n\n" + e);
		}
	}

}
