package utfpr.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import utfpr.curso.Curso;
import utfpr.usuario.Usuario;

public class HibernateManager {
	
	private Configuration configuration;
	private ServiceRegistry serviceRegistry;
	private SessionFactory sessionFactory;
	private Session sharedSession;
	
	private static final HibernateManager instance = new HibernateManager();
	
	public static HibernateManager getInstance() { 
		return instance; 
	}

	private HibernateManager() { 

	}
	
	public SessionFactory getSessionFactory() { 
		return sessionFactory; 
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) { 
		this.sessionFactory = sessionFactory; 
	}
	
	public Session getSharedSession() { 
		return sharedSession; 
	}
	
	public void start() throws Exception {
		try {
			this.configuration = new Configuration().configure("hibernate.cfg.xml");
			this.configuration.addAnnotatedClass(Usuario.class);
			this.configuration.addAnnotatedClass(Curso.class);
			this.serviceRegistry = new StandardServiceRegistryBuilder().
									applySettings(configuration.getProperties()).build();
			this.sessionFactory = this.configuration.buildSessionFactory(serviceRegistry);
			this.sharedSession = this.openSession();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void close() throws Exception {
		try {
			if (this.sharedSession != null) 
				this.sharedSession.close();
			if (this.sessionFactory != null) 
				this.sessionFactory.close();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Session openSession() throws Exception {
		try {
			if (this.sessionFactory == null) {
				this.start();
			}
			return this.sessionFactory.openSession();
		} catch (Exception e) {
			throw e;
		}
	}
	
}