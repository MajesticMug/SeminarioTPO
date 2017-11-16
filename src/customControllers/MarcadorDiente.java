package customControllers;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

import modelo.MarcaDiente;

public class MarcadorDiente
{
	private JLabel lblNumero;
	
	private JCheckBox centro;
	private JCheckBox arriba;
	private JCheckBox abajo;
	private JCheckBox izquierda;
	private JCheckBox derecha;
	
	/*
	 * Crea un marcador de diente en la ubicacion (x, y)
	 */
	public MarcadorDiente(int x, int y, int numero, Container container) {
		lblNumero = new JLabel(String.valueOf(numero));
		centro = new JCheckBox();
		arriba = new JCheckBox();
		abajo = new JCheckBox();
		izquierda = new JCheckBox();
		derecha = new JCheckBox();
		
		ubicarCheckboxes(x, y);
		
		container.add(lblNumero);
		container.add(centro);
		container.add(arriba);
		container.add(abajo);
		container.add(izquierda);
		container.add(derecha);
	}

	private void ubicarCheckboxes(int x, int y)
	{
		// distancia entre checkboxes TODO: fijarse si esto esta bien
		int distancia = 20;
		
		// el centro esta ubicado en el mismo punto
		
		centro.setBounds(x, y, 23, 23);
		arriba.setBounds(x, y - distancia, 23, 23);
		abajo.setBounds(x, y + distancia, 23, 23);
		derecha.setBounds(x + distancia, y, 23, 23);
		izquierda.setBounds(x - distancia, y, 23, 23);
		
		
		lblNumero.setLocation(x, y - distancia * 2);
	}
	
	public MarcaDiente getResultado() {
		return new MarcaDiente(centro.isSelected(), arriba.isSelected(), 
				abajo.isSelected(), izquierda.isSelected(), derecha.isSelected());
	}

	public JLabel getLblNumero()
	{
		return lblNumero;
	}

	public JCheckBox getCentro()
	{
		return centro;
	}

	public JCheckBox getArriba()
	{
		return arriba;
	}

	public JCheckBox getAbajo()
	{
		return abajo;
	}

	public JCheckBox getIzquierda()
	{
		return izquierda;
	}

	public JCheckBox getDerecha()
	{
		return derecha;
	}
	
	public List<Component> getComponentes() {
		List<Component> res = new ArrayList<Component>();
		res.add(lblNumero);
		res.add(centro);
		res.add(arriba);
		res.add(abajo);
		res.add(izquierda);
		res.add(derecha);
		
		return res;
	}
}
