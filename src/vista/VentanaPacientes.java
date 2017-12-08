package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;

import java.awt.GridBagLayout;

import javax.swing.JTextField;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controlador.Sistema;
import modelo.*;
import modelo.FichaOdontologica;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class VentanaPacientes
{
	private JFrame frame;
	private JComboBox<Paciente> cmbPacientes;
	private JComboBox<modelo.FichaOdontologica> cmbFichas;
	private JComboBox<Radiografia> cmbRadiografias;
	private JButton btnVerficha;
	private JButton btnVerradiografia;
	private JButton btnGuardar;
	private JButton btnNuevo;
	private JButton btnSalir;
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTipodocumento;
	private JTextField txtNrodocumento;
	private JTextField txtDomicilio;
	private JTextField txtTelefono;
	private JTextField txtSexo;
	private JTextField txtFechanacimiento;
	private JTextField txtObrasocial;
	private JTextField txtNroobrasocial;

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
					VentanaPacientes window = new VentanaPacientes();
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
	public VentanaPacientes()
	{		
		initialize();
		
		cargarDatos();
		
		this.frame.setVisible(true);
	}

	private void cargarDatos()
	{
		cargarPacientes();
	}

	private void cargarPacientes()
	{
		cmbPacientes.removeAllItems();
		
		Paciente itemSeleccionePaciente = new Paciente() {
			@Override
			public String toString()
			{
				return getNombre();
			}
		};
		
		itemSeleccionePaciente.setNroDocumento(-1);
		itemSeleccionePaciente.setNombre("Seleccione un Paciente");
		cmbPacientes.addItem(itemSeleccionePaciente);
		
		for (Paciente p : Sistema.getInstancia().getPacientes())
		{
			cmbPacientes.addItem(p);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		cmbPacientes = new JComboBox<Paciente>();
		cmbPacientes.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				cargarDatosPaciente((Paciente)cmbPacientes.getSelectedItem());
			}
		});
		
		GridBagConstraints gbc_cmbPacientes = new GridBagConstraints();
		gbc_cmbPacientes.insets = new Insets(0, 0, 5, 5);
		gbc_cmbPacientes.fill = GridBagConstraints.VERTICAL;
		gbc_cmbPacientes.gridx = 1;
		gbc_cmbPacientes.gridy = 0;
		frame.getContentPane().add(cmbPacientes, gbc_cmbPacientes);
		
		JLabel lblId = new JLabel("Id");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		frame.getContentPane().add(lblId, gbc_lblId);
		
		txtId = new JTextField();
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.insets = new Insets(0, 0, 5, 5);
		gbc_txtId.gridx = 1;
		gbc_txtId.gridy = 1;
		frame.getContentPane().add(txtId, gbc_txtId);
		txtId.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 2;
		frame.getContentPane().add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 2;
		frame.getContentPane().add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.EAST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 0;
		gbc_lblApellido.gridy = 3;
		frame.getContentPane().add(lblApellido, gbc_lblApellido);
		
		txtApellido = new JTextField();
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellido.gridx = 1;
		gbc_txtApellido.gridy = 3;
		frame.getContentPane().add(txtApellido, gbc_txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblTipoDocumento = new JLabel("Tipo Documento");
		GridBagConstraints gbc_lblTipoDocumento = new GridBagConstraints();
		gbc_lblTipoDocumento.anchor = GridBagConstraints.EAST;
		gbc_lblTipoDocumento.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoDocumento.gridx = 0;
		gbc_lblTipoDocumento.gridy = 4;
		frame.getContentPane().add(lblTipoDocumento, gbc_lblTipoDocumento);
		
		txtTipodocumento = new JTextField();
		GridBagConstraints gbc_txtTipodocumento = new GridBagConstraints();
		gbc_txtTipodocumento.insets = new Insets(0, 0, 5, 5);
		gbc_txtTipodocumento.gridx = 1;
		gbc_txtTipodocumento.gridy = 4;
		frame.getContentPane().add(txtTipodocumento, gbc_txtTipodocumento);
		txtTipodocumento.setColumns(10);
		
		JLabel lblNroDocumento = new JLabel("Nro Documento");
		GridBagConstraints gbc_lblNroDocumento = new GridBagConstraints();
		gbc_lblNroDocumento.anchor = GridBagConstraints.EAST;
		gbc_lblNroDocumento.insets = new Insets(0, 0, 5, 5);
		gbc_lblNroDocumento.gridx = 0;
		gbc_lblNroDocumento.gridy = 5;
		frame.getContentPane().add(lblNroDocumento, gbc_lblNroDocumento);
		
		txtNrodocumento = new JTextField();
		GridBagConstraints gbc_txtNrodocumento = new GridBagConstraints();
		gbc_txtNrodocumento.insets = new Insets(0, 0, 5, 5);
		gbc_txtNrodocumento.gridx = 1;
		gbc_txtNrodocumento.gridy = 5;
		frame.getContentPane().add(txtNrodocumento, gbc_txtNrodocumento);
		txtNrodocumento.setColumns(10);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		GridBagConstraints gbc_lblDomicilio = new GridBagConstraints();
		gbc_lblDomicilio.anchor = GridBagConstraints.EAST;
		gbc_lblDomicilio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDomicilio.gridx = 0;
		gbc_lblDomicilio.gridy = 6;
		frame.getContentPane().add(lblDomicilio, gbc_lblDomicilio);
		
		txtDomicilio = new JTextField();
		GridBagConstraints gbc_txtDomicilio = new GridBagConstraints();
		gbc_txtDomicilio.insets = new Insets(0, 0, 5, 5);
		gbc_txtDomicilio.gridx = 1;
		gbc_txtDomicilio.gridy = 6;
		frame.getContentPane().add(txtDomicilio, gbc_txtDomicilio);
		txtDomicilio.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 0;
		gbc_lblTelefono.gridy = 7;
		frame.getContentPane().add(lblTelefono, gbc_lblTelefono);
		
		txtTelefono = new JTextField();
		GridBagConstraints gbc_txtTelefono = new GridBagConstraints();
		gbc_txtTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefono.gridx = 1;
		gbc_txtTelefono.gridy = 7;
		frame.getContentPane().add(txtTelefono, gbc_txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo");
		GridBagConstraints gbc_lblSexo = new GridBagConstraints();
		gbc_lblSexo.anchor = GridBagConstraints.EAST;
		gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSexo.gridx = 0;
		gbc_lblSexo.gridy = 8;
		frame.getContentPane().add(lblSexo, gbc_lblSexo);
		
		txtSexo = new JTextField();
		GridBagConstraints gbc_txtSexo = new GridBagConstraints();
		gbc_txtSexo.insets = new Insets(0, 0, 5, 5);
		gbc_txtSexo.gridx = 1;
		gbc_txtSexo.gridy = 8;
		frame.getContentPane().add(txtSexo, gbc_txtSexo);
		txtSexo.setColumns(10);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		GridBagConstraints gbc_lblFechaNacimiento = new GridBagConstraints();
		gbc_lblFechaNacimiento.anchor = GridBagConstraints.EAST;
		gbc_lblFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaNacimiento.gridx = 0;
		gbc_lblFechaNacimiento.gridy = 9;
		frame.getContentPane().add(lblFechaNacimiento, gbc_lblFechaNacimiento);
		
		txtFechanacimiento = new JTextField();
		GridBagConstraints gbc_txtFechanacimiento = new GridBagConstraints();
		gbc_txtFechanacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_txtFechanacimiento.gridx = 1;
		gbc_txtFechanacimiento.gridy = 9;
		frame.getContentPane().add(txtFechanacimiento, gbc_txtFechanacimiento);
		txtFechanacimiento.setColumns(10);
		
		JLabel lblObraSocial = new JLabel("Obra social");
		GridBagConstraints gbc_lblObraSocial = new GridBagConstraints();
		gbc_lblObraSocial.anchor = GridBagConstraints.EAST;
		gbc_lblObraSocial.insets = new Insets(0, 0, 5, 5);
		gbc_lblObraSocial.gridx = 0;
		gbc_lblObraSocial.gridy = 10;
		frame.getContentPane().add(lblObraSocial, gbc_lblObraSocial);
		
		txtObrasocial = new JTextField();
		GridBagConstraints gbc_txtObrasocial = new GridBagConstraints();
		gbc_txtObrasocial.insets = new Insets(0, 0, 5, 5);
		gbc_txtObrasocial.gridx = 1;
		gbc_txtObrasocial.gridy = 10;
		frame.getContentPane().add(txtObrasocial, gbc_txtObrasocial);
		txtObrasocial.setColumns(10);
		
		JLabel lblNroObraSocial = new JLabel("Nro Obra Social");
		GridBagConstraints gbc_lblNroObraSocial = new GridBagConstraints();
		gbc_lblNroObraSocial.anchor = GridBagConstraints.EAST;
		gbc_lblNroObraSocial.insets = new Insets(0, 0, 5, 5);
		gbc_lblNroObraSocial.gridx = 0;
		gbc_lblNroObraSocial.gridy = 11;
		frame.getContentPane().add(lblNroObraSocial, gbc_lblNroObraSocial);
		
		txtNroobrasocial = new JTextField();
		GridBagConstraints gbc_txtNroobrasocial = new GridBagConstraints();
		gbc_txtNroobrasocial.insets = new Insets(0, 0, 5, 5);
		gbc_txtNroobrasocial.gridx = 1;
		gbc_txtNroobrasocial.gridy = 11;
		frame.getContentPane().add(txtNroobrasocial, gbc_txtNroobrasocial);
		txtNroobrasocial.setColumns(10);
		
		JLabel lblFichas = new JLabel("Fichas");
		GridBagConstraints gbc_lblFichas = new GridBagConstraints();
		gbc_lblFichas.anchor = GridBagConstraints.EAST;
		gbc_lblFichas.insets = new Insets(0, 0, 5, 5);
		gbc_lblFichas.gridx = 0;
		gbc_lblFichas.gridy = 12;
		frame.getContentPane().add(lblFichas, gbc_lblFichas);
		
		cmbFichas = new JComboBox<FichaOdontologica>();
		GridBagConstraints gbc_cmbFichas = new GridBagConstraints();
		gbc_cmbFichas.anchor = GridBagConstraints.SOUTH;
		gbc_cmbFichas.insets = new Insets(0, 0, 5, 5);
		gbc_cmbFichas.gridx = 1;
		gbc_cmbFichas.gridy = 12;
		frame.getContentPane().add(cmbFichas, gbc_cmbFichas);
		
		btnVerficha = new JButton("Ver");
		GridBagConstraints gbc_btnVerficha = new GridBagConstraints();
		gbc_btnVerficha.insets = new Insets(0, 0, 5, 0);
		gbc_btnVerficha.gridx = 2;
		gbc_btnVerficha.gridy = 12;
		frame.getContentPane().add(btnVerficha, gbc_btnVerficha);
		
		JLabel lblRadiografias = new JLabel("Radiografias");
		GridBagConstraints gbc_lblRadiografias = new GridBagConstraints();
		gbc_lblRadiografias.anchor = GridBagConstraints.EAST;
		gbc_lblRadiografias.insets = new Insets(0, 0, 5, 5);
		gbc_lblRadiografias.gridx = 0;
		gbc_lblRadiografias.gridy = 13;
		frame.getContentPane().add(lblRadiografias, gbc_lblRadiografias);
		
		cmbRadiografias = new JComboBox<Radiografia>();
		GridBagConstraints gbc_cmbRadiografias = new GridBagConstraints();
		gbc_cmbRadiografias.insets = new Insets(0, 0, 5, 5);
		gbc_cmbRadiografias.gridx = 1;
		gbc_cmbRadiografias.gridy = 13;
		frame.getContentPane().add(cmbRadiografias, gbc_cmbRadiografias);
		
		btnVerradiografia = new JButton("Ver");
		GridBagConstraints gbc_btnVerradiografia = new GridBagConstraints();
		gbc_btnVerradiografia.insets = new Insets(0, 0, 5, 0);
		gbc_btnVerradiografia.gridx = 2;
		gbc_btnVerradiografia.gridy = 13;
		frame.getContentPane().add(btnVerradiografia, gbc_btnVerradiografia);
		
		JPanel panelEspacio1 = new JPanel();
		GridBagConstraints gbc_panelEspacio1 = new GridBagConstraints();
		gbc_panelEspacio1.insets = new Insets(0, 0, 5, 5);
		gbc_panelEspacio1.fill = GridBagConstraints.BOTH;
		gbc_panelEspacio1.gridx = 0;
		gbc_panelEspacio1.gridy = 14;
		frame.getContentPane().add(panelEspacio1, gbc_panelEspacio1);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizarPaciente();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 15;
		frame.getContentPane().add(btnGuardar, gbc_btnGuardar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevoPaciente();
			}
		});
		GridBagConstraints gbc_btnNuevo = new GridBagConstraints();
		gbc_btnNuevo.insets = new Insets(0, 0, 0, 5);
		gbc_btnNuevo.gridx = 1;
		gbc_btnNuevo.gridy = 15;
		frame.getContentPane().add(btnNuevo, gbc_btnNuevo);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.gridx = 2;
		gbc_btnSalir.gridy = 15;
		frame.getContentPane().add(btnSalir, gbc_btnSalir);
	}

	protected void actualizarPaciente()
	{
		Paciente p = getPacienteFromFields();
		
		boolean existe = false;
		
		for (Paciente pacienteEnSistema : Sistema.getInstancia().getPacientes())
		{
			if (pacienteEnSistema.equals(p)) {
				existe = true;
			}
		}
		
		if (!existe) {
			JOptionPane.showMessageDialog(frame, "El paciente con Id: " + p.getUsuarioId() + " no existe.");
		}
		else {
			Sistema.getInstancia().actualizarPaciente(p);
			
			cargarPacientes();			
		}		
	}

	protected void nuevoPaciente()
	{	
		Paciente p = getPacienteFromFields();
		
		for (Paciente enSistema : Sistema.getInstancia().getPacientes())
		{
			if (p.equals(enSistema)) {
				JOptionPane.showMessageDialog(frame, "El paciente con Id: " + p.getUsuarioId() + " ya existe.");
				return;
			}
		}
		
		Sistema.getInstancia().nuevoPaciente(p);
		
		cargarPacientes();
	}

	private Paciente getPacienteFromFields()
	{
		int nroObraSocial = txtNroobrasocial.getText().isEmpty() ? 0 : Integer.valueOf(txtNroobrasocial.getText());
		int nroDocumento = txtNrodocumento.getText().isEmpty() ? 0 : Integer.valueOf(txtNrodocumento.getText());
		int telefono = txtTelefono.getText().isEmpty() ? 0 : Integer.valueOf(txtTelefono.getText());

		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date date = null;
		Date fechaNac = null;
		try
		{
			date = df.parse(txtFechanacimiento.getText());
			fechaNac = new Date(date.getTime());
		} catch (ParseException e)
		{
			
		}
		
		
		Paciente p = new Paciente(txtObrasocial.getText(), nroObraSocial, txtNombre.getText(), 
				txtApellido.getText(), txtTipodocumento.getText(), nroDocumento, 
				txtDomicilio.getText(), telefono, txtSexo.getText().charAt(0), 
				fechaNac, "");
		
		if (!txtId.getText().isEmpty()) {
			p.setUsuarioId(Integer.valueOf(txtId.getText()));
		}
		
		return p;
	}

	protected void cargarDatosPaciente(Paciente p)
	{
		if (p != null && p.getNroDocumento() != -1) {
			txtId.setText(String.valueOf(p.getUsuarioId()));
			txtNombre.setText(p.getNombre());
			txtApellido.setText(p.getApellido());
			txtTipodocumento.setText(p.getTipoDocumento());
			txtNrodocumento.setText(String.valueOf(p.getNroDocumento()));
			txtDomicilio.setText(p.getDomicilio());
			txtTelefono.setText(String.valueOf(p.getTelefono()));
			txtSexo.setText(String.valueOf(p.getSexo()));
			txtFechanacimiento.setText(p.getFechaNac() != null ? p.getFechaNac().toString() : "");
			txtObrasocial.setText(p.getOsPaciente());
			txtNroobrasocial.setText(String.valueOf(p.getNroOsPaciente()));
			
			cargarFichasPaciente(p);
			cargarRadiografiasPaciente(p);			
		}
	}

	private void cargarRadiografiasPaciente(Paciente p)
	{
		cmbRadiografias.removeAllItems();
		
		for (Radiografia r : p.getRadiografias())
		{
			cmbRadiografias.addItem(r);
		}
	}

	private void cargarFichasPaciente(Paciente p)
	{
		cmbFichas.removeAllItems();
		
		for (modelo.FichaOdontologica ficha : p.getFichasOdontologicas())
		{
			cmbFichas.addItem(ficha);
		}
	}
}
