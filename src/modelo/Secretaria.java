package modelo;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class Secretaria extends Usuario
{
	public Secretaria(String nombre, String apellido,
			String tipoDocumento, int nroDocumento, String domicilio,
			int telefono, char sexo, Date fechaNac, String funcion,String usuario,String contrasenia)
	{
		super(nombre, apellido, tipoDocumento, nroDocumento, domicilio,
				telefono, sexo, fechaNac, funcion,usuario,contrasenia);
		// TODO Auto-generated constructor stub
	}
	
	public Secretaria() {};
}
