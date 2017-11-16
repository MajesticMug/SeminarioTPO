package modelo;

public class MarcaDiente
{
	private Boolean centro = false;
	private Boolean arriba = false;
	private Boolean abajo = false;
	private Boolean izquierda = false;
	private Boolean derecha = false;
	
	public MarcaDiente(Boolean centro, Boolean arriba, Boolean abajo,
			Boolean izquierda, Boolean derecha)
	{
		super();
		this.centro = centro;
		this.arriba = arriba;
		this.abajo = abajo;
		this.izquierda = izquierda;
		this.derecha = derecha;
	}

	public Boolean getCentro()
	{
		return centro;
	}

	public void setCentro(Boolean centro)
	{
		this.centro = centro;
	}

	public Boolean getArriba()
	{
		return arriba;
	}

	public void setArriba(Boolean arriba)
	{
		this.arriba = arriba;
	}

	public Boolean getAbajo()
	{
		return abajo;
	}

	public void setAbajo(Boolean abajo)
	{
		this.abajo = abajo;
	}

	public Boolean getIzquierda()
	{
		return izquierda;
	}

	public void setIzquierda(Boolean izquierda)
	{
		this.izquierda = izquierda;
	}

	public Boolean getDerecha()
	{
		return derecha;
	}

	public void setDerecha(Boolean derecha)
	{
		this.derecha = derecha;
	}
}
