package test;




import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import Model.Customer;



public class test {
	@Test
	public void test()
	{
		Configuration configuration=new Configuration().configure();
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().
				applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		SchemaExport export=new SchemaExport(configuration);
		export.create(true, true);
		
	}
	
	@Test
	public void Add(){
		
		Configuration configuration=new Configuration().configure();
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().
				applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.openSession();
		Transaction transaction;
		Customer salesman=new Customer(2, "³Â´æÁ¸" ,"1000", "º¼µç");
		
		transaction=session.beginTransaction();
		
		session.save(salesman);
		
		transaction.commit();
		
		session.close();
		sessionFactory.close();
	}

	


}
