package co.com.miHotel.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;


import co.com.miHotel.dao.HabitacionDAO;
import co.com.miHotel.dao.PersonaDao;
import co.com.miHotel.dao.ReservaDao;
import co.com.miHotel.modelo.EstadoPersona;
import co.com.miHotel.modelo.Habitacion;
import co.com.miHotel.modelo.Persona;
import co.com.miHotel.modelo.Reserva;
import co.com.miHotel.modelo.Rol;
import co.com.miHotel.modelo.TipoDocumento;

@ManagedBean(name = "reservaController")
@SessionScoped
public class ReservaController {

	private String documento;
	private List<Persona> personaList;
	private List<Habitacion> listanumHabi = new ArrayList<>();
	private ReservaDao reservaDao;
	private Persona persona;
	private Habitacion habitacion = new Habitacion();
	private Integer tipoHabitacion;
	private List<String> listaH = new ArrayList<>();
	private Reserva reserva = new Reserva();
	private Date checkIn;
	private Date checkOut;

	@PostConstruct
	public void init() {
		persona = new Persona();
		reservaDao = new ReservaDao();

		persona.setTipoDocumento(new TipoDocumento());
		persona.setEstadoPersona(new EstadoPersona());
		persona.setRol(new Rol());

	}

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

	public void numeroHabitacion() {
		listaH = reservaDao.numerosHabitacion(tipoHabitacion);

	}

	public void autocompletarDatosHabitacion(SelectEvent event) {

		habitacion = reservaDao.autocompletarHabitacion(event.getObject().toString());
	}

	public void guardarReserva() {

		if (reserva != null) {
			
			reserva.setPersona(persona);
			reserva.setHabitacion(habitacion);
			reserva.setCheckIn(new Timestamp(checkIn.getTime()));
			reserva.setCheckOut(new Timestamp(checkOut.getTime()));
			reservaDao.guardarReserva(reserva);
			reserva = new Reserva();
		}
	}
	
	

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public List<Habitacion> getListanumHabi() {
		return listanumHabi;
	}

	public void setListanumHabi(List<Habitacion> listanumHabi) {
		this.listanumHabi = listanumHabi;
	}

	public List<String> getListaH() {
		return listaH;
	}

	public void setListaH(List<String> listaH) {
		this.listaH = listaH;
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

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

}
