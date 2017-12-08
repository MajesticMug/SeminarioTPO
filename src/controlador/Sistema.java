package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import modelo.*;
import persistencia.*;
import utils.HibernateUtil;

public class Sistema
{
	private static Sistema instancia;
	public static Sistema getInstancia() {
		if (instancia == null) {
			instancia = new Sistema();
		}
		return instancia;
	}
	
	private Sistema() {
		
	}
	
	/*
	 * Test
	 */
	public static void main(String[] args) {
		Sistema sis = new Sistema();
		
		System.out.println("Los pacientes son:\n");
		
		for (Paciente p : sis.getPacientes()) {
			System.out.println(p.getNombre() + " " + p.getApellido() + "\n");
			System.out.println("Cantidad de fichas Fichas: " + p.getFichasOdontologicas().size() + "\n");
		}
	}

	public List<Paciente> getPacientes() {
		return PacienteDAO.getInstancia().findAll();
	}

	public List<Odontologo> getOdontologos() {
		return OdontologoDAO.getInstancia().findAll();
	}

	public List<Radiologo> getRadiologos() {
		return RadiologoDAO.getInstancia().findAll();
	}

	public void nuevoPaciente(Paciente p)
	{
		PacienteDAO.getInstancia().save(p);
	}

	public void actualizarPaciente(Paciente p)
	{
		PacienteDAO.getInstancia().update(p);		
	}
}
