package test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Model.Salesman;

public class Salesmantest {
	
	private SessionFactory sessionFactory;
	private Session session;
	private org.hibernate.Transaction transaction;
	
	@Before
	public void init()
	{
		
		Configuration config =new Configuration().configure();
		
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		
		session=sessionFactory.openSession();
		
		transaction= session.beginTransaction();
		
	}
	
	@After
	public void destroy()
	{
		transaction.commit();
		session.close();
		sessionFactory.close();
		
	}
	
	/*@Test
	public void testTable() {
		new SchemaExport(new Configuration().configure()).create(true,true);
	}
	*/
	@Test
	public void testSalesman()
	{
		Salesman s = new Salesman(2,"chen","1000","nan","2000-1-1","110","hangdian","2001-1-1");
		session.save(s);
		//session.getTransaction().commit();
		
	}
	
	@Test
	public void testGetSalesman()
	{
		Salesman s = (Salesman) session.get(Salesman.class, 1);
		System.out.println(s);
		//session.getTransaction().commit();
		
	}
	
	@Test
	public void testLoadSalesman()
	{
		Salesman s = (Salesman) session.load(Salesman.class, 1);
		System.out.println(s);
		//session.getTransaction().commit();
		
	}
	
	
	@Test
	public void testUpdateSalesman()
	{
		Salesman s = (Salesman) session.get(Salesman.class, 1);
		s.setName("chencunlaing");
		session.update(s);
		System.out.println(s);
		//session.getTransaction().commit();
		
	}
	
	@Test
	public void testDeleteSalesman()
	{
		
		Salesman s = (Salesman) session.get(Salesman.class, 1);
		session.delete(s);
		System.out.println(s);
		//session.getTransaction().commit();
		
	}
	
	
	
	

}
