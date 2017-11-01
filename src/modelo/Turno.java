package modelo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Turno
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int nroTurno;
	
	private Date fechaTurno;
	
	private int horaTurno;
	
	private int minutoTurno;
	
	private boolean emergencia;
	
	@ManyToOne
	private Paciente paciente;
	
	@ManyToOne
	private Odontologo odontologo;
	
	@ManyToOne
	private Radiologo radiologo;
	
	public Turno() {
		
	}

	public Turno(Date fechaTurno, int horaTurno, int minutoTurno,
			boolean emergencia, Paciente paciente, Odontologo odontologo,
			Radiologo radiologo)
	{
		super();
		this.fechaTurno = fechaTurno;
		this.horaTurno = horaTurno;
		this.minutoTurno = minutoTurno;
		this.emergencia = emergencia;
		this.paciente = paciente;
		this.odontologo = odontologo;
		this.radiologo = radiologo;
	}

	public int getNroTurno()
	{
		return nroTurno;
	}

	public void setNroTurno(int nroTurno)
	{
		this.nroTurno = nroTurno;
	}

	public Date getFechaTurno()
	{
		return fechaTurno;
	}

	public void setFechaTurno(Date fechaTurno)
	{
		this.fechaTurno = fechaTurno;
	}

	public int getHoraTurno()
	{
		return horaTurno;
	}

	public void setHoraTurno(int horaTurno)
	{
		this.horaTurno = horaTurno;
	}

	public int getMinutoTurno()
	{
		return minutoTurno;
	}

	public void setMinutoTurno(int minutoTurno)
	{
		this.minutoTurno = minutoTurno;
	}

	public boolean isEmergencia()
	{
		return emergencia;
	}

	public void setEmergencia(boolean emergencia)
	{
		this.emergencia = emergencia;
	}

	public Paciente getPaciente()
	{
		return paciente;
	}

	public void setPaciente(Paciente paciente)
	{
		this.paciente = paciente;
	}

	public Odontologo getOdontologo()
	{
		return odontologo;
	}

	public void setOdontologo(Odontologo odontologo)
	{
		this.odontologo = odontologo;
	}

	public Radiologo getRadiologo()
	{
		return radiologo;
	}

	public void setRadiologo(Radiologo radiologo)
	{
		this.radiologo = radiologo;
	}
}
