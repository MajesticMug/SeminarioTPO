package modelo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Usuario
{
	@Id
	private int usuarioId;	
	private String nombre;
	private String apellido;
	private String tipoDocumento;
	private int nroDocumento;
	private String domicilio;
	private int telefono;
	private char sexo;
	private Date fechaNac;
	private String funcion;
	
	public Usuario() { 
		
	}
	
	public Usuario(String nombre, String apellido,
			String tipoDocumento, int nroDocumento, String domicilio,
			int telefono, char sexo, Date fechaNac, String funcion)
	{
		this.usuarioId = usuarioId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.sexo = sexo;
		this.fechaNac = fechaNac;
		this.funcion = funcion;
	}
	
	
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public String getApellido()
	{
		return apellido;
	}
	public void setApellido(String apellido)
	{
		this.apellido = apellido;
	}
	public String getTipoDocumento()
	{
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento)
	{
		this.tipoDocumento = tipoDocumento;
	}
	public int getNroDocumento()
	{
		return nroDocumento;
	}
	public void setNroDocumento(int nroDocumento)
	{
		this.nroDocumento = nroDocumento;
	}
	public String getDomicilio()
	{
		return domicilio;
	}
	public void setDomicilio(String domicilio)
	{
		this.domicilio = domicilio;
	}
	public int getTelefono()
	{
		return telefono;
	}
	public void setTelefono(int telefono)
	{
		this.telefono = telefono;
	}
	public char getSexo()
	{
		return sexo;
	}
	public void setSexo(char sexo)
	{
		this.sexo = sexo;
	}
	public Date getFechaNac()
	{
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac)
	{
		this.fechaNac = fechaNac;
	}
	public String getFuncion()
	{
		return funcion;
	}
	public void setFuncion(String funcion)
	{
		this.funcion = funcion;
	}
	public int getUsuarioId()
	{
		return usuarioId;
	}
}
