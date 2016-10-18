package Management;

import java.util.Date;

import Model.Salesman;
import Operate.Salesman_operate;

public class test {
	public static void main(String[] args) throws Exception {
		
		Salesman_operate op=new Salesman_operate();
		Salesman s=new Salesman();
		s.setName("ccl");
		s.setNumber("1");
		s.setGender("nan");
		s.setPhone("12345");
		s.setbirthDate(new Date());
		s.setAddress("hangdian");
		s.setemployedDate(new Date());
		s.set
		
		
		op.addSalesman(s);
	}
}
