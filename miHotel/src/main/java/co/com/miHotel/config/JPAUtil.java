package co.com.miHotel.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class JPAUtil {
	private static final String PERSISTENCE_NAME = "persistence";
	private static EntityManagerFactory factory;
//	 private static Configuration configuration;
//	 private static SessionFactory sessionFactory;
    

	public static EntityManagerFactory conectar() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
		}
		return factory;
	}

	public static void desconectar() {
		if (factory != null) {
			factory.close();
		}
	}
	
//	static {
//		  configuration = new Configuration()
//		    .configure("/miHotel/src/main/resources/META-INF/persistence.xml");
//		  sessionFactory = configuration.buildSessionFactory();
//		 }
//
//		 public static Session getSession() {
//		  Session session = null;
//		  if (sessionFactory != null) {
//		   session = sessionFactory.openSession();
//		  }
//		  return session;
//		 }
	
	
}
