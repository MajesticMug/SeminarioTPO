package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ConsentimientoTratamiento
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int nroConsentimiento;
	
	private String observaciones;
	
	@ManyToOne
	private Paciente paciente;
	
	@ManyToOne
	private Odontologo odontologo;
	
	@OneToOne
	private PlanTratamiento planTratamiento;
	
	@ManyToOne
	private HistoriaClinica historiaClinica;
	
	public ConsentimientoTratamiento() {
		
	}
	
	public ConsentimientoTratamiento(String observaciones, Paciente paciente,
			Odontologo odontologo, PlanTratamiento planTratamiento,
			HistoriaClinica historiaClinica)
	{
		super();
		this.observaciones = observaciones;
		this.paciente = paciente;
		this.odontologo = odontologo;
		this.planTratamiento = planTratamiento;
		this.historiaClinica = historiaClinica;
	}
	

	public String getObservaciones()
	{
		return observaciones;
	}

	public void setObservaciones(String observaciones)
	{
		this.observaciones = observaciones;
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
