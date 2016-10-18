package Myutil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateUtil {
	private  SessionFactory sessionFactory=null;
	private  Session session=null;
	
	
	public HibernateUtil() {
		// TODO Auto-generated constructor stub
	
		Configuration configuration=new Configuration().configure();
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().
				applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory=configuration.buildSessionFactory(serviceRegistry);
	}
	/*Configuration configuration=new Configuration().configure();
	ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().
			applySettings(configuration.getProperties()).buildServiceRegistry();
	sessionFactory=configuration.buildSessionFactory(serviceRegistry);
	session=sessionFactory.openSession();*/
	
	public  SessionFactory getSessionFactory(){
		return 	sessionFactory;
	}
	
	public  Session getSession(){
		session=sessionFactory.openSession();
		return session;
	}
	
	public  void closeSession(){
		if(session!=null)
			session.close();	
	}
	
	public  void closeSessionFactory(){
		if(sessionFactory!=null)
			sessionFactory.close();	
	}
	
	public  void close(){
		if(session!=null)
			session.close();
		if(sessionFactory!=null)
			sessionFactory.close();	
	}

}
