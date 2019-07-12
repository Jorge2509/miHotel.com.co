package co.com.miHotel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.miHotel.config.JPAUtil;
import co.com.miHotel.modelo.Habitacion;

public class HabitacionDAO {

	EntityManager em = JPAUtil.conectar().createEntityManager();

	/**
	 * @author Ximena 25/05/2019 metodo para guardar una habitación en la base de
	 *         datos
	 * @param habitacion:
	 *            informacion de la habitacion que se va a guardar
	 */
	public String guardarHabitacion(Habitacion habitacion) {
		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			em.persist(habitacion);
			em.getTransaction().commit();
			System.out.println("Creado con exito");
		} catch (Exception e) {
			System.out.println("Error en guardarPersona: " + e);
			em.getTransaction().rollback();
		}

		return "listarHabitaciones.xhtml?faces-redirect=true";
	}

	/**
	 * @author Ximena 25/05/2019 metodo para actualizar una habitación en la base de
	 *         datos
	 * @param habitacion:
	 *            informacion de la habitacion que se va a actualizar
	 */
	public void actualizarHabitacion(Habitacion habitacion) {
		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			if (habitacion != null) {
				StringBuilder consulta = new StringBuilder();
				consulta.append("update Habitacion h Set h.precioMinimo=:precioMinimo ");
				consulta.append(", h.precioMaximo=:precioMaximo ");
				consulta.append(", h.estadoHabitacion=:estadoHabitacion ");
				consulta.append(" where h.idHabitacion=:id");

				Query query = em.createQuery(consulta.toString());
				query.setParameter("id", habitacion.getIdHabitacion());
				query.setParameter("precioMinimo", habitacion.getPrecioMinimo());
				query.setParameter("precioMaximo", habitacion.getPrecioMaximo());
				query.setParameter("estadoHabitacion", habitacion.getEstadoHabitacion().getIdEstadoHabitacion());
				int result = query.executeUpdate();

				if (result > 0)
					em.getTransaction().commit();
			}

		} catch (Exception e) {
			System.out.println("Error en HabitacionDAO.actualizarHabitacion(Habitacion): " + e);
			em.getTransaction().rollback();
		}
	}

	/**
	 * @author Ximena 25/05/2019 metodo para buscar una habitacion por id
	 * @param id:
	 *            id de la habitacion a guardar
	 * @return habitacion: habitacion correspondiente al id
	 */
	public Habitacion findById(Integer id) {
		Habitacion habitacion = new Habitacion();
		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			habitacion = em.find(Habitacion.class, id);
		} catch (Exception e) {
			System.out.println("Error en HabitacionDAO.findById(Integer id): " + e);
			em.getTransaction().rollback();
		}
		return habitacion;
	}

	/**
	 * @author Ximena 25/05/2019 metodo para buscar todas las habitaciones
	 * @return habitacionList: Lista de habitaciones
	 */
	public List<Habitacion> findAll() {

		List<Habitacion> habitacionList = new ArrayList<>();
		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			Query query = em.createQuery("SELECT h FROM Habitacion h");
			habitacionList = query.getResultList();
		} catch (Exception e) {
			System.out.println("Error en HabitacionDAO.findAll(): " + e);
			em.getTransaction().rollback();
		}
		return habitacionList;
	}

}
