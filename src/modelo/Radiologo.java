package modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Radiologo extends Usuario
{
	private int nroMatricula;
	
	@OneToMany(mappedBy = "radiologo")
	private List<Radiografia> radiografias = new ArrayList<Radiografia>();
	
	@OneToMany(mappedBy = "radiologo")
	private List<Turno> turnos = new ArrayList<Turno>();
	
	public Radiologo() {
		
	}

	public Radiologo(int nroMatricula, String nombre, String apellido,
			String tipoDocumento, int nroDocumento, String domicilio,
			int telefono, char sexo, Date fechaNac, String funcion,String usuario,String contrasenia)
	{
		super(nombre, apellido, tipoDocumento, nroDocumento, domicilio,
				telefono, sexo, fechaNac, funcion,usuario,contrasenia);
		
		this.nroMatricula = nroMatricula;
	}

	public int getNroMatricula()
	{
		return nroMatricula;
	}

	public void setNroMatricula(int nroMatricula)
	{
		this.nroMatricula = nroMatricula;
	}

	public List<Radiografia> getRadiografias()
	{
		return radiografias;
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
