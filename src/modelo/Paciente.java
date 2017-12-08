package modelo;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Paciente extends Usuario
{
	private String osPaciente;
	private int nroOsPaciente;
	
	@OneToOne
	private HistoriaClinica historiaClinica;

	@OneToMany(mappedBy = "paciente")
	private List<FichaOdontologica> fichasOdontologicas = new ArrayList<FichaOdontologica>();
	
	@OneToMany(mappedBy = "paciente")
	private List<PlanTratamiento> planesTratamiento = new ArrayList<PlanTratamiento>();	
	
	@OneToMany(mappedBy = "paciente")
	private List<ConsentimientoTratamiento> consentimientosTratamiento = new ArrayList<ConsentimientoTratamiento>();
	
	@OneToMany(mappedBy = "paciente")
	private List<Radiografia> radiografias = new ArrayList<Radiografia>();
	
	@OneToMany(mappedBy = "paciente")
	private List<Turno> turnos = new ArrayList<Turno>();

	public Paciente() {
		super();
	}

	public Paciente(String osPaciente, int nroOsPaciente, String nombre, String apellido, String tipoDocumento,
			int nroDocumento, String domicilio, int telefono, char sexo,
			Date fechaNac, String funcion)
	{
		super(nombre, apellido, tipoDocumento, nroDocumento, domicilio, telefono, sexo,
				fechaNac, funcion);
		
		this.osPaciente = osPaciente;
		this.nroOsPaciente = nroOsPaciente;
	}
	
	@Override
	public String toString()
	{
		return getNroDocumento() + " - " + getApellido() + ", " + getNombre();
	}
	
	@Override
	public boolean equals(Object p)
	{
		if (p instanceof Paciente) {
			return this.getUsuarioId() == ((Paciente) p).getUsuarioId();
		}
		return super.equals(p);
	}
	
	public HistoriaClinica getHistoriaClinica()
	{
		return historiaClinica;
	}

	public void setHistoriaClinica(HistoriaClinica historiaClinica)
	{
		this.historiaClinica = historiaClinica;
	}

	public List<Radiografia> getRadiografias()
	{
		return radiografias;
	}

	public List<ConsentimientoTratamiento> getConsentimientosTratamiento()
	{
		return consentimientosTratamiento;
	}

	public List<FichaOdontologica> getFichasOdontologicas()
	{
		return fichasOdontologicas;
	}
	
	public List<PlanTratamiento> getPlanesTratamiento()
	{
		return planesTratamiento;
	}

	public String getOsPaciente()
	{
		return osPaciente;
	}

	public void setOsPaciente(String osPaciente)
	{
		this.osPaciente = osPaciente;
	}

	public int getNroOsPaciente()
	{
		return nroOsPaciente;
	}

	public void setNroOsPaciente(int nroOsPaciente)
	{
		this.nroOsPaciente = nroOsPaciente;
	}

	public List<Turno> getTurnos()
	{
		return turnos;
	}

	public void setTurnos(List<Turno> turnos)
	{
		this.turnos = turnos;
	}
}
