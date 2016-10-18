package Operate;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import Model.Salesman;
import Myutil.HibernateUtil;

public class SalesmanOperate {
	private Session session;
	private SessionFactory sessionFactory;
	private Transaction transaction;
	//HibernateUtil hibernateUtil=new HibernateUtil();
	
	@Test
	public void Add(Salesman salesman){//Salesman salesman
		HibernateUtil hibernateUtil=new HibernateUtil();
		
		session=hibernateUtil.getSession();
		
		//Salesman salesman=new Salesman("1002", "范宝文" ,"男","1996-1-1","15957111222","杭电",new Date().toString());
		
		transaction=session.beginTransaction();
		
		session.save(salesman);
		
		transaction.commit();
		
		hibernateUtil.close();
	}
	
	@Test
	public void Remove(int id){
		
		
		HibernateUtil hibernateUtil=new HibernateUtil();
		
		session=hibernateUtil.getSession();
		
		Salesman salesman;//=new Salesman(1,"1000", "陈存粮" ,"男","1996-1-1","15957111222","杭电",new Date().toString());
		
		transaction=session.beginTransaction();
		salesman=(Salesman) session.get(Salesman.class,id);
		//System.out.println(salesman.toString());
		
		session.delete(salesman);
		
		transaction.commit();
		
		hibernateUtil.close();
	}
	
	@Test
	public void Update(int id,Salesman salesman){//,Salesman salesman
		Salesman tempsalesman=null;
		
		//id = 1;
		HibernateUtil hibernateUtil=new HibernateUtil();
		
		session=hibernateUtil.getSession();
		
		transaction=session.beginTransaction();
		
		tempsalesman=(Salesman) session.get(Salesman.class,id);
		
		tempsalesman.setNumber(salesman.getNumber());
		tempsalesman.setName(salesman.getName());
		tempsalesman.setGender(salesman.getGender());
		tempsalesman.setBirthDate(salesman.getBirthDate());
		tempsalesman.setPhone(salesman.getPhone());
		tempsalesman.setAddress(salesman.getAddress());
		tempsalesman.setEmployedDate(salesman.getEmployedDate());
		//tempsalesman=salesman;
		
		session.update(tempsalesman);
		
		transaction.commit();
		
		hibernateUtil.close();
	}
	
	@Test
	public  List<Salesman> QueryAll()
	{
		HibernateUtil hibernateUtil=new HibernateUtil();
		
		session=hibernateUtil.getSession();
		
		String hql = "from Salesman";
		Query query=session.createQuery(hql);
		List<Salesman> list = query.list();
		//System.out.println(list.size());
		return list;
	}
	
	@Test
	public int QueryNumber(String number) {
		//List<Salesman> list=null;
		Salesman salesman=null;  
		HibernateUtil hibernateUtil=new HibernateUtil();
		
		session=hibernateUtil.getSession();
		
		String hql = "from Salesman where number = ?"; 
        Query query = session.createQuery(hql).setParameter(0, number); 
        salesman = (Salesman) query.uniqueResult();
        if(salesman == null)
        	return 0;
        else
        	return salesman.getId();
                  
	}
	
	public List<Salesman> QueryPhone(String phone) {
		List<Salesman> list=null;
		//Salesman salesman=null;
		HibernateUtil hibernateUtil=new HibernateUtil();
		
		session=hibernateUtil.getSession();
		
		String hql = "from Salesman where phone = ?"; 
        Query query = session.createQuery(hql).setParameter(0, phone); 
        list = query.list();
        return list;
                  
	}
	
	@Test
	public  List<Salesman> QueryName(String name) {  
		
		HibernateUtil hibernateUtil=new HibernateUtil();
		
		session=hibernateUtil.getSession();
		
		String hql = "from Salesman where name = ?"; 
        Query query = session.createQuery(hql).setParameter(0, name);  
        List<Salesman> list = query.list();  
        return list;
	}
	
	@Test
	public  List<Salesman> LikeNumber(String number) {  
		
		HibernateUtil hibernateUtil=new HibernateUtil();
		
		session=hibernateUtil.getSession();
		
        String hql = "from Salesman as s where s.number like  :temp";  
        Query query = session.createQuery(hql).setParameter("temp", "%"+number+"%");  
        //query.setString(0, "%"+name+"%");
        List<Salesman> list = query.list();     
        return list;
	}
	
	@Test
	public  List<Salesman> LikeName(String name) {  
		
		HibernateUtil hibernateUtil=new HibernateUtil();
		
		session=hibernateUtil.getSession();
		
        String hql = "from Salesman as s where s.name like  :temp";  
        Query query = session.createQuery(hql).setParameter("temp", "%"+name+"%");  
        //query.setString(0, "%"+name+"%");
        List<Salesman> list = query.list();     
        return list;
	}
	
	@Test
	public  List<Salesman> LikeGender(String gender) {  
		
		HibernateUtil hibernateUtil=new HibernateUtil();
		
		session=hibernateUtil.getSession();
		
        String hql = "from Salesman as s where s.gender like  :temp";  
        Query query = session.createQuery(hql).setParameter("temp", "%"+gender+"%");  
        //query.setString(0, "%"+name+"%");
        List<Salesman> list = query.list();     
        return list;
	}
	
	@Test
	public  List<Salesman> LikeBirthDate(String birthDate) {  
		
		HibernateUtil hibernateUtil=new HibernateUtil();
		
		session=hibernateUtil.getSession();
		
        String hql = "from Salesman as s where s.birthDate like  :temp";  
        Query query = session.createQuery(hql).setParameter("temp", "%"+birthDate+"%");  
        //query.setString(0, "%"+name+"%");
        List<Salesman> list = query.list();     
        return list;
	}

	@Test
	public  List<Salesman> LikePhone(String phone) {  
		
		HibernateUtil hibernateUtil=new HibernateUtil();
		
		session=hibernateUtil.getSession();
		
        String hql = "from Salesman as s where s.phone like  :temp";  
        Query query = session.createQuery(hql).setParameter("temp", "%"+phone+"%");  
        //query.setString(0, "%"+name+"%");
        List<Salesman> list = query.list();     
        return list;
	}
	
	@Test
	public  List<Salesman> LikeAddress(String address) {  
		
		HibernateUtil hibernateUtil=new HibernateUtil();
		
		session=hibernateUtil.getSession();
		
        String hql = "from Salesman as s where s.address like  :temp";  
        Query query = session.createQuery(hql).setParameter("temp", "%"+address+"%");  
        //query.setString(0, "%"+name+"%");
        List<Salesman> list = query.list();     
        return list;
	}
	
	@Test
	public  List<Salesman> LikeEmployedDate(String employedDate) {  
		
		HibernateUtil hibernateUtil=new HibernateUtil();
		
		session=hibernateUtil.getSession();
		
        String hql = "from Salesman as s where s.employedDate like  :temp";  
        Query query = session.createQuery(hql).setParameter("temp", "%"+employedDate+"%");  
        //query.setString(0, "%"+name+"%");
        List<Salesman> list = query.list();     
        return list;
	}
	
	@Test
	public Salesman Search(int id){
		
		HibernateUtil hibernateUtil=new HibernateUtil();
		
		session=hibernateUtil.getSession();
		
		Salesman salesman;//=new Salesman(1,"1000", "陈存粮" ,"男","1996-1-1","15957111222","杭电",new Date().toString());
		
		transaction=session.beginTransaction();
		
		salesman=(Salesman) session.get(Salesman.class,id);
		//System.out.println(salesman.toString());
		transaction.commit();
		
		hibernateUtil.close();
		return salesman;
	}
	
	@Test
	public void Load(int id){
		
		HibernateUtil hibernateUtil=new HibernateUtil();
		
		session=hibernateUtil.getSession();
		
		Salesman salesman;//=new Salesman(1,"1000", "陈存粮" ,"男","1996-1-1","15957111222","杭电",new Date().toString());
		
		transaction=session.beginTransaction();
		
		salesman=(Salesman) session.load(Salesman.class,id);
		System.out.println(salesman.toString());
		transaction.commit();
		
		hibernateUtil.close();
	}
		
	@Test
	public List<Salesman> Query(){

		
		String name="陈存粮";

		HibernateUtil hibernateUtil=new HibernateUtil();
		
		session=hibernateUtil.getSession();
		 
		//Salesman salesman;
	   //from后面是对象，不是表名

	   String hql="from Salesman as salesman where salesman.name=:name";//使用命名参数，推荐使用，易读。

	   Query query=session.createQuery(hql);

	   query.setString("name", name);

	   List<Salesman> list=query.list();

	   for(Salesman salesman : list){

	    System.out.println(salesman.toString());
	   }
	   return list;
	}
	
	public void ListTravel(List<Salesman> list){
		if(!list.isEmpty())
		{
			for(Salesman salesman : list){
		
			    System.out.println(salesman.toString());
			   }
		}
	}
	
}
