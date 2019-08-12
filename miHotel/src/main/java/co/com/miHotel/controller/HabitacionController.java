package co.com.miHotel.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import co.com.miHotel.dao.HabitacionDAO;
import co.com.miHotel.dao.TipoHabitacionDAO;
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
	private List<TipoHabitacion> tipoHabitacionList = new ArrayList<>();
	private TipoHabitacionDAO tipoHabitacionDao = new TipoHabitacionDAO();
	private UploadedFile file;

	@PostConstruct
	public void init() {
		habitacionDAO = new HabitacionDAO();
		habitacion.setTipoHabitacion(new TipoHabitacion());
		habitacion.setEstadoHabitacion(new EstadoHabitacion());
		tipoHabitacionList = tipoHabitacionDao.findAll();
	}

	public void guardar() {
		if (habitacion != null) {
			if (!isEdit) {
				habitacionDAO.guardarHabitacion(habitacion);
			} else {
				habitacionDAO.actualizarHabitacion(habitacion);
			}

			habitacion = new Habitacion();
		}
	}

	public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
     
    public void upload() {
        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
     
    public void handleFileUpload(FileUploadEvent event) {
    	System.out.println("Estoy aca llegue al metodoooo");
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

	// public void upload(FileUploadEvent event) {
	// try {
	// FacesMessage msg = new FacesMessage("Succesful",
	// event.getFile().getFileName() + " is uploaded.");
	// FacesContext.getCurrentInstance().addMessage(null, msg);
	// copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
	// FacesMessage message = new FacesMessage("El archivo se ha subido con
	// éxito!");
	// FacesContext.getCurrentInstance().addMessage(null, message);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// public void copyFile(String fileName, InputStream in) {
	// try {
	// String destination = "C:\\Users\\Ximena\\Pictures\\pruebas";
	// OutputStream out = new FileOutputStream(new File(destination + fileName));
	// int read = 0;
	// byte[] bytes = new byte[1024];
	// while ((read = in.read(bytes)) != -1) {
	// out.write(bytes, 0, read);
	// }
	// in.close();
	// out.flush();
	// out.close();
	// System.out.println("El archivo se ha creado con éxito!");
	//
	// DateFormat dateFormat = new SimpleDateFormat("yyyy–MM–dd HH_mm_ss");
	// Date date = new Date();
	// String ruta1 = destination + fileName;
	// String ruta2 = destination + dateFormat.format(date) + "–" + fileName;
	// System.out.println("Archivo: " + ruta1 + " Renombrado a: " + ruta2);
	// File archivo = new File(ruta1);
	// archivo.renameTo(new File(ruta2));
	// } catch (IOException e) {
	// System.out.println(e.getMessage());
	// }
	// }
	//
	// public void handleFileUpload(FileUploadEvent event) throws IOException {
	// System.out.println("Estoy en el metodo de la imagen al fin :)");
	// InputStream inputStream = null;
	// OutputStream outputStream = null;
	// try {
	// if (event.getFile().getSize() <= 0) {
	// FacesContext.getCurrentInstance().addMessage(null, new
	// FacesMessage(FacesMessage.SEVERITY_ERROR,
	// "Error:", "Ud. debe seleccionar un archivo de imagen \".png\""));
	// return;
	// }
	//
	// if (!event.getFile().getFileName().endsWith(".png")) {
	// FacesContext.getCurrentInstance().addMessage(null, new
	// FacesMessage(FacesMessage.SEVERITY_ERROR,
	// "Error:", "El archivo debe ser con extensión \".png\""));
	// return;
	// }
	//
	// if (event.getFile().getSize() > 2097152) {
	// FacesContext.getCurrentInstance().addMessage(null,
	// new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "El archivo no puede
	// ser más de 2mb"));
	// return;
	// }
	//
	// ServletContext servletContext = (ServletContext)
	// FacesContext.getCurrentInstance().getExternalContext()
	// .getContext();
	// String carpetaImagen = (String) servletContext.getRealPath("/imagen");
	// habitacion.setImagen(carpetaImagen + "/" + event.getFile().getFileName());
	// outputStream = new FileOutputStream(new File(carpetaImagen + "/" +
	// "nombre"));
	// inputStream = event.getFile().getInputstream();
	//
	// int read = 0;
	// byte[] bytes = new byte[1024];
	//
	// while ((read = inputStream.read(bytes)) != -1) {
	// outputStream.write(bytes, 0, read);
	// }
	//
	// FacesContext.getCurrentInstance().addMessage(null,
	// new FacesMessage(FacesMessage.SEVERITY_INFO, "La imagen se cargo
	// correctamente", "Correcto"));
	// } catch (
	//
	// Exception ex) {
	// FacesContext.getCurrentInstance().addMessage(null, new
	// FacesMessage(FacesMessage.SEVERITY_FATAL,
	// "Error fatal:", "Por favor contacte con su administrador " +
	// ex.getMessage()));
	// } finally {
	// if (inputStream != null) {
	// inputStream.close();
	// }
	//
	// if (outputStream != null) {
	// outputStream.close();
	// }
	// }
	// }

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

	public List<TipoHabitacion> getTipoHabitacionList() {
		return tipoHabitacionList;
	}

	public void setTipoHabitacionList(List<TipoHabitacion> tipoHabitacionList) {
		this.tipoHabitacionList = tipoHabitacionList;
	}

}
