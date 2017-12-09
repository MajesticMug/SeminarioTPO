package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;

import java.awt.GridBagLayout;

import javax.swing.JTextField;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controlador.Sistema;
import modelo.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JRadioButton;

public class VentanaEspecialistas
{
	private JFrame frame;
	private JComboBox<Odontologo> cmbOdontologos;
	private JButton btnActualizar;
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
	private JLabel lblOdontologos;
	private JLabel lblRadilogos;
	private JComboBox<Radiologo> cmbRadiologos;
	private JLabel lblNroMatrcula;
	private JTextField txtNromatricula;
	
	// odontologo o radiologo
	private JLabel lblTipo;
	private JRadioButton rdbtnOdontologo;
	private JRadioButton rdbtnRadiologo;

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
					VentanaEspecialistas window = new VentanaEspecialistas();
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
	public VentanaEspecialistas()
	{		
		initialize();
		
		cargarDatos();
		
		this.frame.setVisible(true);
	}

	private void cargarDatos()
	{
		cargarOdontologos();
		cargarRadiologos();
	}

	private void cargarRadiologos()
	{
		cmbRadiologos.removeAllItems();
		
		Radiologo itemSeleccioneOdontologo = new Radiologo() {
			@Override
			public String toString()
			{
				return getNombre();
			}
		};
		
		itemSeleccioneOdontologo.setNroDocumento(-1);
		itemSeleccioneOdontologo.setNombre("Seleccione un Radiólogo");
		cmbRadiologos.addItem(itemSeleccioneOdontologo);
		
		for (Radiologo o : Sistema.getInstancia().getRadiologos())
		{
			cmbRadiologos.addItem(o);
		}
	}

	private void cargarOdontologos()
	{
		cmbOdontologos.removeAllItems();
		
		Odontologo itemSeleccioneOdontologo = new Odontologo() {
			@Override
			public String toString()
			{
				return getNombre();
			}
		};
		
		itemSeleccioneOdontologo.setNroDocumento(-1);
		itemSeleccioneOdontologo.setNombre("Seleccione un Odontólogo");
		cmbOdontologos.addItem(itemSeleccioneOdontologo);
		
		for (Odontologo o : Sistema.getInstancia().getOdontologos())
		{
			cmbOdontologos.addItem(o);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		cmbOdontologos = new JComboBox<Odontologo>();
		cmbOdontologos.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				rdbtnOdontologo.setSelected(true);
				cargarDatosEspecialista((Odontologo)cmbOdontologos.getSelectedItem());
			}
		});
		
		lblOdontologos = new JLabel("Odont\u00F3logos");
		GridBagConstraints gbc_lblOdontologos = new GridBagConstraints();
		gbc_lblOdontologos.insets = new Insets(0, 0, 5, 5);
		gbc_lblOdontologos.gridx = 0;
		gbc_lblOdontologos.gridy = 0;
		frame.getContentPane().add(lblOdontologos, gbc_lblOdontologos);
		
		lblRadilogos = new JLabel("Radi\u00F3logos");
		GridBagConstraints gbc_lblRadilogos = new GridBagConstraints();
		gbc_lblRadilogos.insets = new Insets(0, 0, 5, 0);
		gbc_lblRadilogos.gridx = 2;
		gbc_lblRadilogos.gridy = 0;
		frame.getContentPane().add(lblRadilogos, gbc_lblRadilogos);
		
		GridBagConstraints gbc_cmbOdontologos = new GridBagConstraints();
		gbc_cmbOdontologos.insets = new Insets(0, 0, 5, 5);
		gbc_cmbOdontologos.fill = GridBagConstraints.VERTICAL;
		gbc_cmbOdontologos.gridx = 0;
		gbc_cmbOdontologos.gridy = 1;
		frame.getContentPane().add(cmbOdontologos, gbc_cmbOdontologos);
		
		cmbRadiologos = new JComboBox<Radiologo>();
		cmbRadiologos.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				rdbtnRadiologo.setSelected(true);
				cargarDatosEspecialista((Radiologo)cmbRadiologos.getSelectedItem());
			}
		});
		
		GridBagConstraints gbc_cmbRadiologos = new GridBagConstraints();
		gbc_cmbRadiologos.insets = new Insets(0, 0, 5, 0);
		gbc_cmbRadiologos.gridx = 2;
		gbc_cmbRadiologos.gridy = 1;
		frame.getContentPane().add(cmbRadiologos, gbc_cmbRadiologos);
		
		JLabel lblId = new JLabel("Id");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 2;
		frame.getContentPane().add(lblId, gbc_lblId);
		
		txtId = new JTextField();
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.insets = new Insets(0, 0, 5, 5);
		gbc_txtId.gridx = 1;
		gbc_txtId.gridy = 2;
		frame.getContentPane().add(txtId, gbc_txtId);
		txtId.setColumns(10);
		
		lblNroMatrcula = new JLabel("Nro Matr\u00EDcula");
		GridBagConstraints gbc_lblNroMatrcula = new GridBagConstraints();
		gbc_lblNroMatrcula.anchor = GridBagConstraints.EAST;
		gbc_lblNroMatrcula.insets = new Insets(0, 0, 5, 5);
		gbc_lblNroMatrcula.gridx = 0;
		gbc_lblNroMatrcula.gridy = 3;
		frame.getContentPane().add(lblNroMatrcula, gbc_lblNroMatrcula);
		
		txtNromatricula = new JTextField();
		GridBagConstraints gbc_txtNromatricula = new GridBagConstraints();
		gbc_txtNromatricula.insets = new Insets(0, 0, 5, 5);
		gbc_txtNromatricula.gridx = 1;
		gbc_txtNromatricula.gridy = 3;
		frame.getContentPane().add(txtNromatricula, gbc_txtNromatricula);
		txtNromatricula.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 4;
		frame.getContentPane().add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 4;
		frame.getContentPane().add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.EAST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 0;
		gbc_lblApellido.gridy = 5;
		frame.getContentPane().add(lblApellido, gbc_lblApellido);
		
		txtApellido = new JTextField();
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellido.gridx = 1;
		gbc_txtApellido.gridy = 5;
		frame.getContentPane().add(txtApellido, gbc_txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblTipoDocumento = new JLabel("Tipo Documento");
		GridBagConstraints gbc_lblTipoDocumento = new GridBagConstraints();
		gbc_lblTipoDocumento.anchor = GridBagConstraints.EAST;
		gbc_lblTipoDocumento.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoDocumento.gridx = 0;
		gbc_lblTipoDocumento.gridy = 6;
		frame.getContentPane().add(lblTipoDocumento, gbc_lblTipoDocumento);
		
		txtTipodocumento = new JTextField();
		GridBagConstraints gbc_txtTipodocumento = new GridBagConstraints();
		gbc_txtTipodocumento.insets = new Insets(0, 0, 5, 5);
		gbc_txtTipodocumento.gridx = 1;
		gbc_txtTipodocumento.gridy = 6;
		frame.getContentPane().add(txtTipodocumento, gbc_txtTipodocumento);
		txtTipodocumento.setColumns(10);
		
		JLabel lblNroDocumento = new JLabel("Nro Documento");
		GridBagConstraints gbc_lblNroDocumento = new GridBagConstraints();
		gbc_lblNroDocumento.anchor = GridBagConstraints.EAST;
		gbc_lblNroDocumento.insets = new Insets(0, 0, 5, 5);
		gbc_lblNroDocumento.gridx = 0;
		gbc_lblNroDocumento.gridy = 7;
		frame.getContentPane().add(lblNroDocumento, gbc_lblNroDocumento);
		
		txtNrodocumento = new JTextField();
		GridBagConstraints gbc_txtNrodocumento = new GridBagConstraints();
		gbc_txtNrodocumento.insets = new Insets(0, 0, 5, 5);
		gbc_txtNrodocumento.gridx = 1;
		gbc_txtNrodocumento.gridy = 7;
		frame.getContentPane().add(txtNrodocumento, gbc_txtNrodocumento);
		txtNrodocumento.setColumns(10);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		GridBagConstraints gbc_lblDomicilio = new GridBagConstraints();
		gbc_lblDomicilio.anchor = GridBagConstraints.EAST;
		gbc_lblDomicilio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDomicilio.gridx = 0;
		gbc_lblDomicilio.gridy = 8;
		frame.getContentPane().add(lblDomicilio, gbc_lblDomicilio);
		
		txtDomicilio = new JTextField();
		GridBagConstraints gbc_txtDomicilio = new GridBagConstraints();
		gbc_txtDomicilio.insets = new Insets(0, 0, 5, 5);
		gbc_txtDomicilio.gridx = 1;
		gbc_txtDomicilio.gridy = 8;
		frame.getContentPane().add(txtDomicilio, gbc_txtDomicilio);
		txtDomicilio.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 0;
		gbc_lblTelefono.gridy = 9;
		frame.getContentPane().add(lblTelefono, gbc_lblTelefono);
		
		txtTelefono = new JTextField();
		GridBagConstraints gbc_txtTelefono = new GridBagConstraints();
		gbc_txtTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefono.gridx = 1;
		gbc_txtTelefono.gridy = 9;
		frame.getContentPane().add(txtTelefono, gbc_txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo");
		GridBagConstraints gbc_lblSexo = new GridBagConstraints();
		gbc_lblSexo.anchor = GridBagConstraints.EAST;
		gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSexo.gridx = 0;
		gbc_lblSexo.gridy = 10;
		frame.getContentPane().add(lblSexo, gbc_lblSexo);
		
		txtSexo = new JTextField();
		GridBagConstraints gbc_txtSexo = new GridBagConstraints();
		gbc_txtSexo.insets = new Insets(0, 0, 5, 5);
		gbc_txtSexo.gridx = 1;
		gbc_txtSexo.gridy = 10;
		frame.getContentPane().add(txtSexo, gbc_txtSexo);
		txtSexo.setColumns(10);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		GridBagConstraints gbc_lblFechaNacimiento = new GridBagConstraints();
		gbc_lblFechaNacimiento.anchor = GridBagConstraints.EAST;
		gbc_lblFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaNacimiento.gridx = 0;
		gbc_lblFechaNacimiento.gridy = 11;
		frame.getContentPane().add(lblFechaNacimiento, gbc_lblFechaNacimiento);
		
		txtFechanacimiento = new JTextField();
		GridBagConstraints gbc_txtFechanacimiento = new GridBagConstraints();
		gbc_txtFechanacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_txtFechanacimiento.gridx = 1;
		gbc_txtFechanacimiento.gridy = 11;
		frame.getContentPane().add(txtFechanacimiento, gbc_txtFechanacimiento);
		txtFechanacimiento.setColumns(10);
		
		lblTipo = new JLabel("Tipo");
		GridBagConstraints gbc_lblTipo = new GridBagConstraints();
		gbc_lblTipo.anchor = GridBagConstraints.EAST;
		gbc_lblTipo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipo.gridx = 0;
		gbc_lblTipo.gridy = 12;
		frame.getContentPane().add(lblTipo, gbc_lblTipo);
		
		rdbtnOdontologo = new JRadioButton("Odontologo");
		rdbtnOdontologo.setSelected(true);
		GridBagConstraints gbc_rdbtnOdontologo = new GridBagConstraints();
		gbc_rdbtnOdontologo.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnOdontologo.gridx = 1;
		gbc_rdbtnOdontologo.gridy = 12;
		frame.getContentPane().add(rdbtnOdontologo, gbc_rdbtnOdontologo);
		
		rdbtnRadiologo = new JRadioButton("Radiologo");
		GridBagConstraints gbc_rdbtnRadiologo = new GridBagConstraints();
		gbc_rdbtnRadiologo.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnRadiologo.gridx = 2;
		gbc_rdbtnRadiologo.gridy = 12;
		frame.getContentPane().add(rdbtnRadiologo, gbc_rdbtnRadiologo);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnOdontologo);
		group.add(rdbtnRadiologo);
		
		JPanel panelEspacio1 = new JPanel();
		GridBagConstraints gbc_panelEspacio1 = new GridBagConstraints();
		gbc_panelEspacio1.insets = new Insets(0, 0, 5, 5);
		gbc_panelEspacio1.fill = GridBagConstraints.BOTH;
		gbc_panelEspacio1.gridx = 0;
		gbc_panelEspacio1.gridy = 16;
		frame.getContentPane().add(panelEspacio1, gbc_panelEspacio1);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizarOdontologo();
			}
		});
		GridBagConstraints gbc_btnActualizar = new GridBagConstraints();
		gbc_btnActualizar.insets = new Insets(0, 0, 0, 5);
		gbc_btnActualizar.gridx = 0;
		gbc_btnActualizar.gridy = 17;
		frame.getContentPane().add(btnActualizar, gbc_btnActualizar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnOdontologo.isSelected())
					nuevoOdontologo();
				else if (rdbtnRadiologo.isSelected())
					nuevoRadiologo();
			}
		});
		GridBagConstraints gbc_btnNuevo = new GridBagConstraints();
		gbc_btnNuevo.insets = new Insets(0, 0, 0, 5);
		gbc_btnNuevo.gridx = 1;
		gbc_btnNuevo.gridy = 17;
		frame.getContentPane().add(btnNuevo, gbc_btnNuevo);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.gridx = 2;
		gbc_btnSalir.gridy = 17;
		frame.getContentPane().add(btnSalir, gbc_btnSalir);
	}

	protected void actualizarOdontologo()
	{
		Odontologo o = getOdontologoFromFields();
		
		boolean existe = false;
		
		for (Odontologo enSistema : Sistema.getInstancia().getOdontologos())
		{
			if (enSistema.equals(o)) {
				existe = true;
			}
		}
		
		if (!existe) {
			JOptionPane.showMessageDialog(frame, "El odontologo con Id: " + o.getUsuarioId() + " no existe.");
		}
		else {
			Sistema.getInstancia().actualizarOdontologo(o);
			
			cargarOdontologos();			
		}		
	}

	protected void nuevoOdontologo()
	{	
		Odontologo o = getOdontologoFromFields();
		
		for (Odontologo enSistema : Sistema.getInstancia().getOdontologos())
		{
			if (o.equals(enSistema)) {
				JOptionPane.showMessageDialog(frame, "El odontólogo con Id: " + o.getUsuarioId() + " ya existe.");
				return;
			}
		}
		
		Sistema.getInstancia().nuevoOdontologo(o);
		
		cargarOdontologos();
	}
	
	protected void nuevoRadiologo()
	{
		Radiologo r = getRadiologoFromFields();
		
		for (Radiologo enSistema : Sistema.getInstancia().getRadiologos())
		{
			if (r.equals(enSistema)) {
				JOptionPane.showMessageDialog(frame, "El radiólogo con Id: " + r.getUsuarioId() + " ya existe.");
				return;
			}
		}
		
		Sistema.getInstancia().nuevoRadiologo(r);
		
		cargarRadiologos();
	}
	
	private Radiologo getRadiologoFromFields()
	{
		int nroMatricula = txtNromatricula.getText().isEmpty() ? 0 : Integer.valueOf(txtNromatricula.getText());
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
		
		Radiologo r = new Radiologo(nroMatricula, txtNombre.getText(), 
				txtApellido.getText(), txtTipodocumento.getText(), nroDocumento, 
				txtDomicilio.getText(), telefono, txtSexo.getText().charAt(0), 
				fechaNac, "");
		
		if (!txtId.getText().isEmpty()) {
			r.setUsuarioId(Integer.valueOf(txtId.getText()));
		}
		
		return r;
	}

	private Odontologo getOdontologoFromFields()
	{
		int nroMatricula = txtNromatricula.getText().isEmpty() ? 0 : Integer.valueOf(txtNromatricula.getText());
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
		
		Odontologo o = new Odontologo(nroMatricula, txtNombre.getText(), 
				txtApellido.getText(), txtTipodocumento.getText(), nroDocumento, 
				txtDomicilio.getText(), telefono, txtSexo.getText().charAt(0), 
				fechaNac, "");
		
		if (!txtId.getText().isEmpty()) {
			o.setUsuarioId(Integer.valueOf(txtId.getText()));
		}
		
		return o;
	}

	protected void cargarDatosEspecialista(Usuario u)
	{
		if (u != null && u.getNroDocumento() != -1) {
			txtId.setText(String.valueOf(u.getUsuarioId()));
			
			if (u instanceof Odontologo)
				txtNromatricula.setText(String.valueOf(((Odontologo)u).getNroMatricula()));
			else if (u instanceof Radiologo)
				txtNromatricula.setText(String.valueOf(((Radiologo)u).getNroMatricula()));
				
			txtNombre.setText(u.getNombre());
			txtApellido.setText(u.getApellido());
			txtTipodocumento.setText(u.getTipoDocumento());
			txtNrodocumento.setText(String.valueOf(u.getNroDocumento()));
			txtDomicilio.setText(u.getDomicilio());
			txtTelefono.setText(String.valueOf(u.getTelefono()));
			txtSexo.setText(String.valueOf(u.getSexo()));
			txtFechanacimiento.setText(u.getFechaNac() != null ? u.getFechaNac().toString() : "");		
		}
	}
}
