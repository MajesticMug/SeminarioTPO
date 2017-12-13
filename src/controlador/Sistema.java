package controlador;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import modelo.*;
import persistencia.*;
import utils.HibernateUtil;
import vista.BuscarPersona;
import vista.Radiografias;
import vista.Turnos;

public class Sistema
{
	private List<Paciente>   pacientes;
	private List<Odontologo> odontologos;
	private List<Radiologo>  radiologos;
	private List<Turno>      turnos;
	private List<FichaOdontologica> fichasOdontologicas;
	private List<HistoriaClinica> historiasClinicas;
	private List<Radiografia> radiografias;
	
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
		turnos = TurnosDAO.getInstancia().findAll();
		fichasOdontologicas = FichasOdontologicasDAO.getInstancia().findAll();
		historiasClinicas = HistoriaClinicaDAO.getInstancia().findAll();
		radiografias = RadiografiaDAO.getInstancia().findAll();
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

	public List<FichaOdontologica> getFichasOdontologicas() {
		return fichasOdontologicas;
	}

	public List<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}
	
	

	public List<HistoriaClinica> getHistoriasClinicas() {
		return historiasClinicas;
	}

	public List<Radiografia> getRadiografias() {
		return radiografias;
	}

	public void setHistoriasClinicas(List<HistoriaClinica> historiasClinicas) {
		this.historiasClinicas = historiasClinicas;
	}

	public Paciente buscarPaciente (int dni){
		Paciente pac =null;
		Integer i = 0;
		while ( i < this.pacientes.size()){

			if (this.pacientes.get(i).getNroDocumento() == dni ){
				return this.pacientes.get(i);
			}
			i++;
		}
		return pac;
	}
//	Se convierte la visualización de turnos en el turno 
	public Turno buscarTurnos (String turno){
//		FORMATO: turno = "31370003 - Juan Hernandez - 09/12/2012 - 12hs";
		String parts[] = turno.split(" - ");
		int dniParts = Integer.parseInt(parts[0]);
		int i = 0;
		while (i<this.turnos.size()){
//			String dni = Integer.toString(this.turnos.get(i).getPaciente().getNroDocumento());
			
			int dni = this.turnos.get(i).getPaciente().getNroDocumento();
//			if ( dni == parts[0]){
			if ( dni == dniParts){
				return this.turnos.get(i);
			}
			i++;
		}
		
		Turno turnoNull = null;
		return turnoNull;
		
	}
	public void agregarHistoriaClinica(HistoriaClinica h){
		HistoriaClinicaDAO.getInstancia().save(h);
		this.historiasClinicas.add(h);
	}
	public void agregarPaciente(Paciente p){
		PacienteDAO.getInstancia().save(p);
		this.pacientes.add(p);
	}
	
	public void eliminarPaciente(Paciente p){
		int index = 0;
		while (index < this.pacientes.size()){
			if (this.pacientes.get(index).getNroDocumento() == p.getNroDocumento()){
				PacienteDAO.getInstancia().remove(p);
				this.pacientes.remove(index);
			}
		}
	}
	
	public Odontologo buscarOdontologo (int dni){
		Odontologo odonto= null;
		Integer i = 0;
		while ( i < this.odontologos.size()){

			if (this.odontologos.get(i).getNroDocumento() == dni ){
				return this.odontologos.get(i);
			}
			i++;
		}
		return odonto;
	}
	
	public Radiologo buscarRadiologo (int dni){
		Radiologo rad= null;
		Integer i = 0;
		while ( i < this.radiologos.size()){

			if (this.radiologos.get(i).getNroDocumento() == dni ){
				return this.radiologos.get(i);
			}
			i++;
		}
		return rad;
	}
	
	public void agregarOdontologo (Odontologo o){
		OdontologoDAO.getInstancia().save(o);
		this.odontologos.add(o);
	}
	
	public void eliminarOdontologo (Odontologo odont){
		int index = 0;
		while (index < this.odontologos.size()){
			if (this.odontologos.get(index).getNroDocumento() == odont.getNroDocumento()){
				this.odontologos.remove(index);
			}
			index++;
		}
		
	}
	
	public void agregarRadiologo (Radiologo r){
		this.radiologos.add(r);
	}
	
	public void eliminarRadiologo(Radiologo rad){
		int index = 0;
		while (index < this.radiologos.size()){
			if (this.radiologos.get(index).getNroDocumento() == rad.getNroDocumento()){
				this.radiologos.remove(index);
			}
			index++;
		}
	}
	
	public void agregarTurno(Turno t){
		TurnosDAO.getInstancia().save(t);
		this.turnos.add(t);
	}
	
	public void eliminarTurno (Turno turno){
		int index = 0;
		while (index < this.turnos.size()){
			if (   this.turnos.get(index).getFechaTurno() == turno.getFechaTurno()
			    && this.turnos.get(index).getHoraTurno()  == turno.getHoraTurno()){
				TurnosDAO.getInstancia().remove(turno);
				this.turnos.remove(index);
			}
			index++;
		}
		
	}

	// VALIDAR USUARIO
	public boolean validarUsuario (String usuario, String contrasenia){
		
		return UsuarioDAO.getInstancia().validarUsuario(usuario, contrasenia);
		
	}
	
	// RECUPERAR TODOS LOS PACIENTES
	public List<Paciente> recuperarPacientes(){
		return this.pacientes;
	}
	
	// RECUPERAR TODOS LOS ESPECIALISTAS
	public List<Odontologo> recuperarOdontologos(){
		return this.odontologos;
	}
	
	public List<Radiologo> recuperarRadiologos(){
		return this.radiologos;
	}
	
	// RECUPERAR TURNOS
	public List<Turno> recuperarTurnos(){
		return this.turnos;
	}

	public void agregarFichaOdontologica(modelo.FichaOdontologica ficha) {
		FichasOdontologicasDAO.getInstancia().save(ficha);
		getFichasOdontologicas().add(ficha);		
	}
	
	public List<HistoriaClinica> recuperarHistoriasClinicas(){
		return this.historiasClinicas;
	}
}
