package co.com.miHotel.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
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
	private InputStream inputStream = null;
	private OutputStream outputStream = null;
	private String imagenPreliminar = null;
	
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

	public void handleFileUpload(FileUploadEvent event) throws IOException {
		try {
			if (event.getFile().getSize() <= 0) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error:", "Ud. debe seleccionar un archivo de imagen \".png\""));
				return;
			}

			if (!event.getFile().getFileName().endsWith(".png")) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error:", "El archivo debe ser con extensión \".png\""));
				return;
			}

			if (event.getFile().getSize() > 2097152) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "El archivo no puede ser más de 2mb"));
				return;
			}

			ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
					.getContext();
			String carpetaImagen = (String) servletContext.getRealPath("/resources/images");
			outputStream = new FileOutputStream(new File(carpetaImagen + "/" + event.getFile().getFileName()));
			inputStream = event.getFile().getInputstream();

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			
			habitacion.setImagen("images/" + event.getFile().getFileName());
			imagenPreliminar = habitacion.getImagen();
			
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "La imagen se cargo correctamente", "Correcto"));
		} catch (Exception ex) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
					"Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}

			if (outputStream != null) {
				outputStream.close();
			}
		}
	}

	 private static BufferedImage resizeImage(BufferedImage originalImage, int type) {
	        BufferedImage resizedImage = new BufferedImage(200, 200, type);//set width and height of image
	        Graphics2D g = resizedImage.createGraphics();
	        g.drawImage(originalImage, 0, 0, 200, 200, null);
	        g.dispose();
	 
	        return resizedImage;
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

	public List<TipoHabitacion> getTipoHabitacionList() {
		return tipoHabitacionList;
	}

	public void setTipoHabitacionList(List<TipoHabitacion> tipoHabitacionList) {
		this.tipoHabitacionList = tipoHabitacionList;
	}

	public boolean isEdit() {
		return isEdit;
	}

	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public OutputStream getOutputStream() {
		return outputStream;
	}

	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	public String getImagenPreliminar() {
		if (StringUtils.isBlank(imagenPreliminar)) {
			imagenPreliminar = "images/camara.png";
		}
		return imagenPreliminar;
	}

	public void setImagenPreliminar(String imagenPreliminar) {
		this.imagenPreliminar = imagenPreliminar;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

}
