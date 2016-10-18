package Operate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import Model.Password;
import Model.Salesman;
import Myutil.HibernateUtil;

public class PasswordOperate {
	
	private Session session;
	private SessionFactory sessionFactory;
	private Transaction transaction;
	//HibernateUtil hibernateUtil=new HibernateUtil();
	
	@Test
	public void Add(Password password){
		
		//Password password=new Password("1234","1","How are you?","Fine,thanks!");
		
		HibernateUtil hibernateUtil=new HibernateUtil();
		
		session=hibernateUtil.getSession();
		
		
		transaction=session.beginTransaction();
		
		session.save(password);
		
		transaction.commit();
		
		hibernateUtil.close();
	}
	
	@Test
	public void Remove(int id){
		
		HibernateUtil hibernateUtil=new HibernateUtil();
		
		session=hibernateUtil.getSession();
		
		Password password;
		
		transaction=session.beginTransaction();
		password=(Password) session.get(Password.class,id);
		//System.out.println(salesman.toString());
		
		session.delete(password);
		
		transaction.commit();
		
		hibernateUtil.close();
	}
	
	@Test
	public Password Query(int id){
		Password temp=null;
		HibernateUtil hibernateUtil=new HibernateUtil();
		
		session=hibernateUtil.getSession();
		
		Password password=null;
		
		transaction=session.beginTransaction();
		
		password=(Password) session.get(Password.class,id);
		//System.out.println(password.toString());
		temp=password;
		transaction.commit();
		
		hibernateUtil.close();
		return temp;
	}
	
	@Test
	public int QueryAccount(String account) {
		//String account="1234";
		Password password=null;
		HibernateUtil hibernateUtil=new HibernateUtil();
		
		session=hibernateUtil.getSession();
		
		String hql = "from Password where account = ?"; 
        Query query = session.createQuery(hql).setParameter(0, account); 
        password = (Password) query.uniqueResult();
        if(password == null)
        	return 0;
        else
        	return password.getId();
                  
	}
	
	@Test
	public void Update(int id,String newPassword){
		//Password password=new Password("abc");
		
		Password temppassword=null;
		//id = 1;
		HibernateUtil hibernateUtil=new HibernateUtil();
		
		session=hibernateUtil.getSession();
		
		transaction=session.beginTransaction();
		
		temppassword=(Password) session.get(Password.class,id);
		//System.out.println(temppassword.toString());
		temppassword.setPassword(newPassword);
		
		session.update(temppassword);
		
		transaction.commit();
		
		hibernateUtil.close();	
	}
	
	@Test
	public void UpdatePassword(String password){
		//Password password=new Password("abc");
		
		Password temppassword=null;
		//id = 1;
		HibernateUtil hibernateUtil=new HibernateUtil();
		
		session=hibernateUtil.getSession();
		
		transaction=session.beginTransaction();
		
		temppassword=(Password) session.get(Password.class,1);
		//System.out.println(temppassword.toString());
		temppassword.setPassword(password);
		
		session.update(temppassword);
		
		transaction.commit();
		
		hibernateUtil.close();	
	}
	
}
