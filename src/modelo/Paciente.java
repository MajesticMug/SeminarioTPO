package modelo;


import java.sql.Date;
import javax.persistence.Entity;

@Entity
public class Paciente extends Usuario
{
	private String osPaciente;
	private int nroOsPaciente;
	
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
	
	
}
