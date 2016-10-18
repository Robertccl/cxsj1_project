package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Manage.ManageSalesman;
import Model.Salesman;

/**
 * Servlet implementation class SalesmanServlet
 */
@WebServlet(name = "SalesmanServlet1", urlPatterns = { "/SalesmanServlet1" })
public class SalesmanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String action;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalesmanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	*//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doPost(request, response);
		List<Salesman> list=null;
		ManageSalesman manageSalesman=new ManageSalesman();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		//Salesman salesman=GetData(request, response);
		out.println("<html>");  
        out.println("<body>");  
        out.println("<h1>Get</h1>"+"<hr>");

        if(request.getParameter("action")!=null)
		{
        	this.action = request.getParameter("action");
  
			if(action.equals("delete"))
			{
				String s=request.getParameter("id");
				int id = Integer.parseInt(s);
				manageSalesman.RemoveSalesman(id);
				list=manageSalesman.QueryAllSalesman();
		        request.getSession().setAttribute("list",list);
				response.sendRedirect(request.getContextPath()+"/display.jsp");
			}
			if(action.equals("query"))
			{
				//manageSalesman.QueryAllSalesman();
				list=manageSalesman.QueryAllSalesman();
		        request.getSession().setAttribute("list",list);
				response.sendRedirect(request.getContextPath()+"/display.jsp");
			}
			if(action.equals("search"))
			{
				List<Salesman> Slist=null;
				String name=request.getParameter("search");
				//manageSalesman.QueryAllSalesman();
				Slist=manageSalesman.QueryName(name);
		        request.getSession().setAttribute("Slist",Slist);
				response.sendRedirect(request.getContextPath()+"/query.jsp");
			}
			if(action.equals("update"))
			{
				Salesman salesman=null;
				String s=request.getParameter("id");
				int id = Integer.parseInt(s);
				salesman=manageSalesman.QueryId(id);
				
		        request.getSession().setAttribute("salesman",salesman);
		        //System.out.println(salesman.toString());
				response.sendRedirect(request.getContextPath()+"/update.jsp");
				//manageSalesman.RemoveSalesman(id);
			}
		}
			
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//System.out.println(request.getParameter("number"));
		List<Salesman> list=null;
		ManageSalesman manageSalesman=new ManageSalesman();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		//Salesman salesman=GetData(request, response);
		String action = request.getParameter("action");
		
		if(action=="add")
		{
		
			System.out.println(action);
			out.println("<html>");  
			out.println("<body>");  
			out.println("<h1>Success</h1>"+"<hr>"+action+"Success");
			out.println("</html>");
			Salesman salesman=GetData(request, response);
			System.out.println(salesman.toString());
			manageSalesman.AddSalesman(salesman);
		}
		//添加if条件后不能使用
		
		if(action=="update")
		{
			out.println("<html>");  
			out.println("<body>");  
			out.println("<h1>Success</h1>"+"<hr>"+action+"Success");
			out.println("</html>");
			Salesman salesman=GetData(request, response);
			System.out.println(salesman.toString());
			int id=salesman.getId();
			manageSalesman.UpdateSalesman(id, salesman);
		}
		
		
		list=manageSalesman.QueryAllSalesman();
		request.getSession().setAttribute("list",list);
		response.sendRedirect(request.getContextPath()+"/display.jsp");
		

			
}
	
	private Salesman GetData(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException
	{
		//String a = new String(request.getParameter("a").getBytes("ISO8859_1"),"UTF-8");
		Salesman salesman=new Salesman();
		salesman.setNumber(request.getParameter("number")); 
		salesman.setName(new String(request.getParameter("name").getBytes("ISO8859_1"),"UTF-8")); 
		salesman.setGender(request.getParameter("sex"));
		salesman.setBirthDate(request.getParameter("birthDate"));
		salesman.setPhone(request.getParameter("phone"));
		salesman.setAddress(new String(request.getParameter("address").getBytes("ISO8859_1"),"UTF-8"));
		salesman.setEmployedDate(request.getParameter("employedDate"));
		return salesman;
		
	}
	

}
