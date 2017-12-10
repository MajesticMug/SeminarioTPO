package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import modelo.*;
import persistencia.*;
import utils.HibernateUtil;
import vista.BuscarPersona;

public class Sistema
{
	private List<Paciente> pacientes;
	private List<Odontologo> odontologos;
	private List<Radiologo> radiologos;
	private static Sistema inst = null;
	
	public static Sistema getInstance(){
		if(inst == null){
			inst = new Sistema();
		}
		return inst;
	}
	
	public Sistema() {
		pacientes = PacienteDAO.getInstancia().findAll();
		odontologos = OdontologoDAO.getInstancia().findAll();
		radiologos = RadiologoDAO.getInstancia().findAll();
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
		return pacientes;
	}

	public List<Odontologo> getOdontologos() {
		return odontologos;
	}

	public List<Radiologo> getRadiologos() {
		return radiologos;
	}

	public Paciente buscarPaciente (int dni){
		Paciente paciente= null;
		Integer i = 0;


		while ( i < pacientes.size()){

			if (pacientes.get(i).getNroDocumento() == dni ){
				return paciente;
			}
			i++;
		}

		return paciente;
	}
}
