package modelo;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class Odontologo extends Usuario
{
	private int nroMatricula;
	
	public Odontologo() {
		
	}
	
	public Odontologo(int nroMatricula, String nombre, String apellido,
			String tipoDocumento, int nroDocumento, String domicilio,
			int telefono, char sexo, Date fechaNac, String funcion)
	{
		super(nombre, apellido, tipoDocumento, nroDocumento, domicilio,
				telefono, sexo, fechaNac, funcion);
		
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
}
