package modelo;

import java.util.List;

import javax.persistence.*;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class PuntosMarcados
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_nro_marcado",nullable=false)
	private Integer Id;
	
	@ElementCollection
	private List<Integer> puntosX;
	
	@ElementCollection
	private List<Integer> puntosY;
	
	public PuntosMarcados() {
		
	}

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
