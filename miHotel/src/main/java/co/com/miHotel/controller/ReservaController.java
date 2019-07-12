package co.com.miHotel.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import co.com.miHotel.dao.HabitacionDAO;
import co.com.miHotel.dao.PersonaDao;
import co.com.miHotel.dao.ReservaDao;
import co.com.miHotel.modelo.EstadoPersona;
import co.com.miHotel.modelo.Habitacion;
import co.com.miHotel.modelo.Persona;
import co.com.miHotel.modelo.Rol;
import co.com.miHotel.modelo.TipoDocumento;

@ManagedBean(name = "reservaController")
@SessionScoped
public class ReservaController {

	private String documento;
	private List<Persona> personaList;
	private List<Habitacion> listanumHabi = new ArrayList<>();
	private ReservaDao reservaDao;
	private Persona persona = new Persona();
	private Habitacion habitacion = new Habitacion();
	private Integer tipoHabitacion;

	@PostConstruct
	public void init() {
		reservaDao = new ReservaDao();

		persona.setTipoDocumento(new TipoDocumento());
		persona.setEstadoPersona(new EstadoPersona());
		persona.setRol(new Rol());
		
	}

	// public List<String> buscarDocumento(String doc) {
	// documentos = reservaDao.documentos();
	// List<String> listadoc= new ArrayList<>();
	// for(int i=0;i<documentos.size();i++) {
	// if(documentos.get(i).contains(doc)) {
	// listadoc.add(documentos.get(i));
	// }
	// }
	//
	// return listadoc;
	//
	// }

	public void buscarPersona() {

		if (documento != null && documento != "") {
			persona = reservaDao.mostrarPersonas(documento);

			if (persona == null) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "la persona no existe!!"));

				try {

					FacesContext.getCurrentInstance().getExternalContext().redirect("registrarPersona.xhtml");

				} catch (Exception e) {
					System.out.println("no direccionado");
				}

			}

		}

	}

	// public List<String> buscarHabitacion(String numHabitacion) {
	//
	// listanumHabi = reservaDao.numHabitacion();
	// List<String> listaH= new ArrayList<>();
	// for(int i=0;i<listanumHabi.size();i++) {
	// if(listanumHabi.get(i).contains(numHabitacion)) {
	// listaH.add(listanumHabi.get(i));
	// }
	// }
	//
	// return listaH;
	//
	// }
	//
	public void habitaciones() {

		listanumHabi = reservaDao.listaHabitaciones(tipoHabitacion);

	}

	public List<Habitacion> getListanumHabi() {
		return listanumHabi;
	}

	public void setListanumHabi(List<Habitacion> listanumHabi) {
		this.listanumHabi = listanumHabi;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public List<Persona> getPersonaList() {
		return personaList;
	}

	public void setPersonaList(List<Persona> personaList) {
		this.personaList = personaList;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public ReservaDao getReservaDao() {
		return reservaDao;
	}

	public void setReservaDao(ReservaDao reservaDao) {
		this.reservaDao = reservaDao;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Integer getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(Integer tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

}
