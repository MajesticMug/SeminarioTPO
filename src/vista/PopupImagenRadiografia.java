package vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Radiografia;

public class PopupImagenRadiografia extends JFrame
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7398271644643032564L;
	
	private Radiografia radiografia;
	
	private BufferedImage imagen;

	/**
	 * Create the application.
	 */
	public PopupImagenRadiografia(Radiografia radiografia)
	{
		this.radiografia = radiografia;
		
		try
		{
			this.imagen = ImageIO.read(new ByteArrayInputStream(this.radiografia.getImagen()));
			
			initialize();
		} catch (IOException e)
		{
			JOptionPane.showMessageDialog(this, "No se pudo obtener la imagen.\n" + e);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{		
		setBounds(100, 100, imagen.getWidth() + 20, imagen.getHeight() + 40);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(imagen, 10, 30, this);
	}
}
