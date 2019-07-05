package co.com.miHotel.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import co.com.miHotel.dao.HabitacionDAO;
import co.com.miHotel.modelo.EstadoHabitacion;
import co.com.miHotel.modelo.Habitacion;
import co.com.miHotel.modelo.TipoHabitacion;

@ManagedBean(name = "habitacionController")
@SessionScoped
public class HabitacionController {

	private List<Habitacion> habitacionList;
	private HabitacionDAO habitacionDAO;
	private Habitacion habitacion = new Habitacion();
	private FacesContext contex = FacesContext.getCurrentInstance();
	private boolean isEdit = false;

	@PostConstruct
	public void init() {
		habitacionDAO = new HabitacionDAO();
		habitacion.setTipoHabitacion(new TipoHabitacion());
		habitacion.setEstadoHabitacion(new EstadoHabitacion());
		mostrarTodos();
	}

	public void nuevo() {
		try {
			contex.getExternalContext().redirect("mihotel/registrarHabitacion.xhtml");
		} catch (Exception e) {
			System.out.println("Me voy al carajo, no funciona esta redireccion");

		}
	}

	public void guardar() {
		if (habitacion != null) {
				habitacionDAO.guardarHabitacion(habitacion);
				System.out.println("Guardado con exito");
				habitacion = new Habitacion();
		} 
		
	}

	public void update(Integer id) {
		try {
			System.out.println("update");
			habitacion = new Habitacion();
			if (id != null) {
				habitacion.setEstadoHabitacion(new EstadoHabitacion());
				habitacion.setTipoHabitacion(new TipoHabitacion());
				habitacion = habitacionDAO.findById(id);
				isEdit = true;
				FacesContext.getCurrentInstance().getExternalContext().redirect("actualizarHabitacion.xhtml");
			}

		} catch (Exception e) {
			System.out.println("Me voy al carajo, no funciona esta redireccion");
		}
	}

	public void mostrarTodos() {
		habitacionList = habitacionDAO.findAll();
	}

	/*********** GETTER'S & SETTER'S ********************/
	public List<Habitacion> getHabitacionList() {
		return habitacionList;
	}

	public void setHabitacionList(List<Habitacion> habitacionList) {
		this.habitacionList = habitacionList;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

}
