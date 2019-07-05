package co.com.miHotel.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import co.com.miHotel.dao.PersonaDao;
import co.com.miHotel.modelo.EstadoPersona;
import co.com.miHotel.modelo.Persona;
import co.com.miHotel.modelo.Rol;
import co.com.miHotel.modelo.TipoDocumento;

@ManagedBean(name = "personaController")
@SessionScoped
public class PersonaController {

	private List<Persona> personaList;
	private PersonaDao personaDao;
	private Persona persona = new Persona();
	private String editPersonaId;
	private Persona personaEdit;

	@PostConstruct
	public void init() {
		personaDao = new PersonaDao();

		persona.setTipoDocumento(new TipoDocumento());
		persona.setEstadoPersona(new EstadoPersona());
		persona.setRol(new Rol());
		if (personaList == null || personaList.isEmpty()) {
			mostrarTodos();
		}
		
	}

	public void guardar() {
		if (persona != null) {
			personaDao.guardarPersona(persona);
			System.out.println("yujuuuuu");
//			cargarListas(persona);
//			personaList.add(persona);
			mostrarTodos();
			persona = new Persona();
		}
	}

	private void cargarListas(Persona persona2) {
		switch (persona2.getTipoDocumento().getIdTipoDocumento()) {
		case 1:
			persona.getTipoDocumento().setDescripcion("Cedula de Ciudadania");
			break;
			
		case 2:
			persona.getTipoDocumento().setDescripcion("Tarjeta de extranjeria");
			break;
		case 3:
			persona.getTipoDocumento().setDescripcion("Dni");
			break;
			
		case 4:
			persona.getTipoDocumento().setDescripcion("pasaporte");
			break;

		default:
			break;
		}
		
		switch (persona2.getRol().getIdRol()) {
		case 1:
			persona.getRol().setDescripcion("Superadmin");
			break;
			
		case 2:
			persona.getRol().setDescripcion("Administrador");
			break;
		case 3:
			persona.getRol().setDescripcion("Recepcionista");
			break;
			
		case 4:
			persona.getRol().setDescripcion("Usuario");
			break;

		default:
			break;
		}
		
		switch (persona2.getEstadoPersona().getIdEstadoPersona()) {
		case 1:
			persona.getEstadoPersona().setDescripcion("Activo");
			break;
			
		case 2:
			persona.getEstadoPersona().setDescripcion("Inactivo");
			break;
			
		default:
			break;
		}

	}

	public void mostrarTodos() {
		personaList = personaDao.findAll();
	}

	public void actualizar(Persona persona) {
        PersonaDao personaDao= new PersonaDao();
		personaDao.actualizarPersona(persona);
		persona = new Persona();
	}

	public void editarPersonaId(Integer idPersona) throws IOException {
		persona = new Persona();
		if (idPersona != null) {
			persona.getTipoDocumento();
			persona.getEstadoPersona();
			persona.setRol(new Rol());
			persona = personaDao.idPersona(idPersona);
			FacesContext.getCurrentInstance().getExternalContext().redirect("editarPersona.xhtml");
		}

	}

	public String borrarPersonaId(Integer idperson) {
		System.out.println("Borrando: " + idperson);
		return personaDao.borrarPersona(idperson);

	}

	/*********** GETTER'S & SETTER'S ********************/

	public List<Persona> getPersonaList() {
		return personaList;
	}

	public String getEditPersonaId() {
		return editPersonaId;
	}

	public void setEditPersonaId(String editPersonaId) {
		this.editPersonaId = editPersonaId;
	}

	public void setPersonaList(List<Persona> personaList) {
		this.personaList = personaList;
	}

	public PersonaDao getPersonaDao() {
		return personaDao;
	}

	public void setPersonaDao(PersonaDao personaDao) {
		this.personaDao = personaDao;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Persona getPersonaEdit() {
		return personaEdit;
	}

	public void setPersonaEdit(Persona personaEdit) {
		this.personaEdit = personaEdit;
	}

	
	/*********** GETTER'S & SETTER'S ********************/

}
