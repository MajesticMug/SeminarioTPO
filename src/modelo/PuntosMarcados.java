package modelo;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class PuntosMarcados
{
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	@ElementCollection
	private List<Integer> puntosX;
	
	@ElementCollection
	private List<Integer> puntosY;

	public PuntosMarcados(List<Integer> puntosX, List<Integer> puntosY)
	{
		super();
		this.puntosX = puntosX;
		this.puntosY = puntosY;
	}

	public List<Integer> getPuntosX()
	{
		return puntosX;
	}

	public void setPuntosX(List<Integer> puntosX)
	{
		this.puntosX = puntosX;
	}

	public List<Integer> getPuntosY()
	{
		return puntosY;
	}

	public void setPuntosY(List<Integer> puntosY)
	{
		this.puntosY = puntosY;
	}

	public int getId()
	{
		return Id;
	}
}
