package modelo;

import java.sql.Date;

public class Secretaria extends Usuario
{
	public Secretaria(String nombre, String apellido,
			String tipoDocumento, int nroDocumento, String domicilio,
			int telefono, char sexo, Date fechaNac, String funcion)
	{
		super(nombre, apellido, tipoDocumento, nroDocumento, domicilio,
				telefono, sexo, fechaNac, funcion);
		// TODO Auto-generated constructor stub
	}
}
