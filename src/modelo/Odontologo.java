package modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Odontologo extends Usuario
{
	private int nroMatricula;
	
	@OneToMany(mappedBy = "odontologo")
	private List<PlanTratamiento> planesTratamiento = new ArrayList<PlanTratamiento>();	
	
	@OneToMany(mappedBy = "odontologo")
	private List<ConsentimientoTratamiento> consentimientosTratamiento = new ArrayList<ConsentimientoTratamiento>();
	
	@OneToMany(mappedBy = "odontologo")
	private List<Turno> turnos = new ArrayList<Turno>();
	
	public Odontologo() {
		
	}
	
	public Odontologo(int nroMatricula, String nombre, String apellido,
			String tipoDocumento, int nroDocumento, String domicilio,
			int telefono, char sexo, Date fechaNac, String funcion,String usuario,String contrasenia)
	{
		super(nombre, apellido, tipoDocumento, nroDocumento, domicilio,
				telefono, sexo, fechaNac, funcion,usuario,contrasenia);
		
		this.setNroMatricula(nroMatricula);
	}

	public int getNroMatricula()
	{
		return nroMatricula;
	}

	public void setNroMatricula(int nroMatricula)
	{
		this.nroMatricula = nroMatricula;
	}
	
	public List<ConsentimientoTratamiento> getConsentimientosTratamiento()
	{
		return consentimientosTratamiento;
	}

	public List<PlanTratamiento> getPlanesTratamiento()
	{
		return planesTratamiento;
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
