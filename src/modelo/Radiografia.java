package modelo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Radiografia
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int nroRadiografia;
	
	private Date fechaRadiografia;
	
	@ManyToOne
	private Paciente paciente;
	
	@ManyToOne
	private Radiologo radiologo;
	
	@ManyToOne
	private HistoriaClinica historiaClinica;
	
	@Lob
	private byte[] imagen;
	
	public Radiografia() {
		
	}

	public Radiografia(Date fechaRadiografia, Paciente paciente,
			Radiologo radiologo)
	{
		super();
		this.fechaRadiografia = fechaRadiografia;
		this.paciente = paciente;
		this.radiologo = radiologo;
	}
	
	@Override
	public String toString()
	{
		return getNroRadiografia() + (getFechaRadiografia() != null ? " - " + getFechaRadiografia().toString() : "");
	}
	
	@Override
	public boolean equals(Object p)
	{
		if (p instanceof Paciente) {
			return this.getNroRadiografia() == ((Radiografia) p).getNroRadiografia();
		}
		return super.equals(p);
	}

	public int getNroRadiografia()
	{
		return nroRadiografia;
	}

	public void setNroRadiografia(int nroRadiografia)
	{
		this.nroRadiografia = nroRadiografia;
	}

	public Date getFechaRadiografia()
	{
		return fechaRadiografia;
	}

	public void setFechaRadiografia(Date fechaRadiografia)
	{
		this.fechaRadiografia = fechaRadiografia;
	}

	public Paciente getPaciente()
	{
		return paciente;
	}

	public void setPaciente(Paciente paciente)
	{
		this.paciente = paciente;
	}

	public Radiologo getRadiologo()
	{
		return radiologo;
	}

	public void setRadiologo(Radiologo radiologo)
	{
		this.radiologo = radiologo;
	}

	public HistoriaClinica getHistoriaClinica()
	{
		return historiaClinica;
	}

	public void setHistoriaClinica(HistoriaClinica historiaClinica)
	{
		this.historiaClinica = historiaClinica;
	}

	public byte[] getImagen()
	{
		return imagen;
	}

	public void setImagen(byte[] imagen)
	{
		this.imagen = imagen;
	}
}
