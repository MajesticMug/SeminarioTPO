package modelo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class PlanTratamiento
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int nroTratamiento;
	private Date fechaCreacionPlanTratamiento;
	private String detallePlanTratamiento;
	private boolean activo;
	
	@ManyToOne
	private Paciente paciente;
	
	@ManyToOne
	private Odontologo odontologo;
	
	@OneToOne
	private ConsentimientoTratamiento consentimientoTratamiento;
	
	@ManyToOne
	private HistoriaClinica historiaClinica;
	
	public PlanTratamiento() {
		
	}	

	public PlanTratamiento(Date fechaCreacionPlanTratamiento,
			String detallePlanTratamiento, boolean activo, Paciente paciente,
			Odontologo odontologo,
			ConsentimientoTratamiento consentimientoTratamiento,
			HistoriaClinica historiaClinica)
	{
		super();
		this.fechaCreacionPlanTratamiento = fechaCreacionPlanTratamiento;
		this.detallePlanTratamiento = detallePlanTratamiento;
		this.activo = activo;
		this.paciente = paciente;
		this.odontologo = odontologo;
		this.consentimientoTratamiento = consentimientoTratamiento;
		this.historiaClinica = historiaClinica;
	}

	public ConsentimientoTratamiento getConsentimientoTratamiento()
	{
		return consentimientoTratamiento;
	}

	public void setConsentimientoTratamiento(
			ConsentimientoTratamiento consentimientoTratamiento)
	{
		this.consentimientoTratamiento = consentimientoTratamiento;
	}

	public int getNroTratamiento()
	{
		return nroTratamiento;
	}

	public void setNroTratamiento(int nroTratamiento)
	{
		this.nroTratamiento = nroTratamiento;
	}

	public Date getFechaCreacionPlanTratamiento()
	{
		return fechaCreacionPlanTratamiento;
	}

	public void setFechaCreacionPlanTratamiento(Date fechaCreacionPlanTratamiento)
	{
		this.fechaCreacionPlanTratamiento = fechaCreacionPlanTratamiento;
	}

	public String getDetallePlanTratamiento()
	{
		return detallePlanTratamiento;
	}

	public void setDetallePlanTratamiento(String detallePlanTratamiento)
	{
		this.detallePlanTratamiento = detallePlanTratamiento;
	}

	public boolean isActivo()
	{
		return activo;
	}

	public void setActivo(boolean activo)
	{
		this.activo = activo;
	}

	public Paciente getPaciente()
	{
		return paciente;
	}

	public void setPaciente(Paciente paciente)
	{
		this.paciente = paciente;
	}

	public Odontologo getOdontologo()
	{
		return odontologo;
	}

	public void setOdontologo(Odontologo odontologo)
	{
		this.odontologo = odontologo;
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
