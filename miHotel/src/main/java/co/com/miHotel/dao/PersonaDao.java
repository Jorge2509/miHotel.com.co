package co.com.miHotel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityTransaction;
import co.com.miHotel.config.JPAUtil;

import co.com.miHotel.modelo.Persona;

public class PersonaDao {

	EntityManager em = JPAUtil.conectar().createEntityManager();
	private EntityTransaction transactionObj = em.getTransaction();
	private Persona persona;

	public String guardarPersona(Persona persona) {
		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			em.persist(persona);
			em.getTransaction().commit();
			System.out.println("Creado con exito");
		} catch (Exception e) {
			System.out.println("Error en guardarPersona: " + e);
			em.getTransaction().rollback();
		}

		return "personaView.xhtml?faces-redirect=true";
	}

	public String actualizarPersona(Persona persona) {
		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			Query queryObj = em.createQuery(
					"UPDATE Persona p SET p.primerNombre=:nameone, p.segundoNombre=:nametwo, p.telefono=:tel, p.correo=:correo, p.estadoPersona=:estado WHERE p.idPersona= :id");
			queryObj.setParameter("id", persona.getIdPersona());
			queryObj.setParameter("nameone", persona.getPrimerNombre());
			queryObj.setParameter("nametwo", persona.getSegundoNombre());
			queryObj.setParameter("tel", persona.getTelefono());
			queryObj.setParameter("correo", persona.getCorreo());
			queryObj.setParameter("estado", persona.getEstadoPersona());

			int updateCount = queryObj.executeUpdate();
			if (updateCount > 0) {
				System.out.println("persona actualizada");
			}

			transactionObj.commit();
			FacesContext.getCurrentInstance().addMessage("editarPersonaForm:personaId",
					new FacesMessage("el registro ha sido actualizado"));

		} catch (Exception e) {
			System.out.println("Error en PersonaDao.actualizarPersona(persona): " + e);
			em.getTransaction().rollback();
		}

		return "editarPersona.xhtml";
	}

	public Persona findById(Integer id) {
		Persona persona = new Persona();
		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			persona = em.find(Persona.class, id);
		} catch (Exception e) {
			System.out.println("Error en PersonaDao.findById(Integer id): " + e);
			em.getTransaction().rollback();
		}
		return persona;
	}

	public List<Persona> findAll() {
		List<Persona> personaList = new ArrayList<>();
		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			Query query = em.createQuery("SELECT p FROM Persona p");
			personaList = query.getResultList();
		} catch (Exception e) {
			System.out.println("Error en PersonaDao.findAll(): " + e);
			em.getTransaction().rollback();
		}
		return personaList;
	}

	// Método para actualizar los detalles
	public String updatePersona(Persona persona) {

		Query queryObj = em.createQuery(
				"UPDATE Persona p SET p.primerNombre=:nameone, p.segundoNombre=:nametwo, p.telefono=:tel, p.correo=:correo, p.estadoPersona=:estado WHERE p.idPersona= :id");
		queryObj.setParameter("id", persona.getIdPersona());
		queryObj.setParameter("nameone", persona.getPrimerNombre());
		queryObj.setParameter("nametwo", persona.getSegundoNombre());
		queryObj.setParameter("tel", persona.getTelefono());
		queryObj.setParameter("correo", persona.getCorreo());
		queryObj.setParameter("estado", persona.getEstadoPersona());

		int updateCount = queryObj.executeUpdate();
		if (updateCount > 0) {
			System.out.println("persona actualizada");
		}

		transactionObj.commit();
		FacesContext.getCurrentInstance().addMessage("editSchoolForm:schoolId",
				new FacesMessage("el registro ha sido actualizado"));
		return "schoolEdit.xhtml";
	}

	public Persona idPersona(int idPersona) {
		// boolean idResult = false;

		Query queryObj = em.createQuery("SELECT p FROM Persona p WHERE p.idPersona = :id");
		queryObj.setParameter("id", idPersona);
		Persona selecionarIdPersona = (Persona) queryObj.getSingleResult();
		// if(selecionarIdPersona != null) {
		// //idResult = true;
		// }
		return selecionarIdPersona;
	}
	
	
	public Persona mostrarPersonas(String numeroDocumento) {

		// List<Persona> personaList = new ArrayList<>();
		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			Query query = em.createQuery("SELECT p FROM Persona p  WHERE p.numeroDocumento =:numeroDoc");
			query.setParameter("numeroDoc", numeroDocumento);

			persona = (Persona) query.getSingleResult();
		}

		catch (Exception e) {
			persona = null;
		}

		return persona;
	}



	public String borrarPersona(int IdPersona) {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}

		Persona deletePerson = new Persona();

		deletePerson.setIdPersona(IdPersona);
		em.remove(em.merge(deletePerson));

		transactionObj.commit();
		return "personaView.xhtml?faces-redirect=true";
	}

}
