package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class HistoriaClinica
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int nroHistoriaClinica;
	
	private String observaciones;
	
	@OneToOne
	private Paciente paciente;
	
	@OneToMany(mappedBy = "historiaClinica")
	private List<Radiografia> radiografias = new ArrayList<Radiografia>();
	
	@OneToMany(mappedBy = "historiaClinica")
	private List<ConsentimientoTratamiento> consentimientosTratamiento = new ArrayList<ConsentimientoTratamiento>();
	
	@OneToMany(mappedBy = "historiaClinica")
	private List<PlanTratamiento> planesTratamiento = new ArrayList<PlanTratamiento>();
	
	@OneToMany(mappedBy = "historiaClinica")
	private List<FichaOdontologica> fichasOdontologicas = new ArrayList<FichaOdontologica>();
	
	public HistoriaClinica() {
		
	}

	public HistoriaClinica(String observaciones, Paciente paciente)
	{
		super();
		this.observaciones = observaciones;
		this.paciente = paciente;
	}

	public HistoriaClinica(String observaciones, Paciente paciente,
			List<Radiografia> radiografias,
			List<ConsentimientoTratamiento> consentimientosTratamiento,
			List<PlanTratamiento> planesTratamiento,
			List<FichaOdontologica> fichasOdontologicas)
	{
		super();
		this.observaciones = observaciones;
		this.paciente = paciente;
		this.radiografias = radiografias;
		this.consentimientosTratamiento = consentimientosTratamiento;
		this.planesTratamiento = planesTratamiento;
		this.fichasOdontologicas = fichasOdontologicas;
	}
	
	public String toString() {
		return getNroHistoriaClinica() + " - " + getPaciente().getApellido() + ", " + getPaciente().getNombre();
	}

	
	public int getNroHistoriaClinica()
	{
		return nroHistoriaClinica;
	}

	public void setNroHistoriaClinica(int nroHistoriaClinica)
	{
		this.nroHistoriaClinica = nroHistoriaClinica;
	}

	public String getObservaciones()
	{
		return observaciones;
	}

	public void setObservaciones(String observaciones)
	{
		this.observaciones = observaciones;
	}

	public Paciente getPaciente()
	{
		return paciente;
	}

	public void setPaciente(Paciente paciente)
	{
		this.paciente = paciente;
	}

	public List<ConsentimientoTratamiento> getConsentimientosTratamiento()
	{
		return consentimientosTratamiento;
	}

	public void setConsentimientosTratamiento(
			List<ConsentimientoTratamiento> consentimientosTratamiento)
	{
		this.consentimientosTratamiento = consentimientosTratamiento;
	}

	public List<Radiografia> getRadiografias()
	{
		return radiografias;
	}

	public List<PlanTratamiento> getPlanesTratamiento()
	{
		return planesTratamiento;
	}

	public List<FichaOdontologica> getFichasOdontologicas()
	{
		return fichasOdontologicas;
	}
}
