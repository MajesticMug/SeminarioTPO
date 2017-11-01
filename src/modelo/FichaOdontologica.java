package modelo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FichaOdontologica
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int nroFichaOdontologica;
	private Date fechaCreacionFicha;
	private Date fechaModificacionFicha;
	
	@ManyToOne
	private Paciente paciente;
	
	private String observaciones;
	
	@ManyToOne
	private HistoriaClinica historiaClinica;
	
	public FichaOdontologica() {
		
	}

	public FichaOdontologica(Date fechaCreacionFicha,
			Date fechaModificacionFicha, Paciente paciente,
			String observaciones, HistoriaClinica historiaClinica)
	{
		super();
		this.fechaCreacionFicha = fechaCreacionFicha;
		this.fechaModificacionFicha = fechaModificacionFicha;
		this.paciente = paciente;
		this.observaciones = observaciones;
		this.historiaClinica = historiaClinica;
	}

	public Date getFechaCreacionFicha()
	{
		return fechaCreacionFicha;
	}

	public void setFechaCreacionFicha(Date fechaCreacionFicha)
	{
		this.fechaCreacionFicha = fechaCreacionFicha;
	}

	public Date getFechaModificacionFicha()
	{
		return fechaModificacionFicha;
	}

	public void setFechaModificacionFicha(Date fechaModificacionFicha)
	{
		this.fechaModificacionFicha = fechaModificacionFicha;
	}

	public Paciente getPaciente()
	{
		return paciente;
	}

	public void setPaciente(Paciente paciente)
	{
		this.paciente = paciente;
	}

	public String getObservaciones()
	{
		return observaciones;
	}

	public void setObservaciones(String observaciones)
	{
		this.observaciones = observaciones;
	}

	public int getNroFichaOdontologica()
	{
		return nroFichaOdontologica;
	}

	public HistoriaClinica getHistoriaClinica()
	{
		return historiaClinica;
	}

	public void setHistoriaClinica(HistoriaClinica historiaClinica)
	{
		this.historiaClinica = historiaClinica;
	}
	
	
}
