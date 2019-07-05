package co.com.miHotel.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import co.com.miHotel.dao.PersonaDao;
import co.com.miHotel.dao.ReservaDao;
import co.com.miHotel.modelo.EstadoPersona;
import co.com.miHotel.modelo.Persona;
import co.com.miHotel.modelo.Rol;
import co.com.miHotel.modelo.TipoDocumento;

@ManagedBean(name = "reservaController")
@SessionScoped
public class ReservaController {

	private String documento;
	private List<Persona> personaList;
	private List<String> documentos;
	private ReservaDao reservaDao;
	private Persona persona = new Persona();

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
			if (persona!=null && !persona.equals("")) {
				System.out.println("Persona no existe");
			}
		}

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

	public List<String> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<String> documentos) {
		this.documentos = documentos;
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

}
