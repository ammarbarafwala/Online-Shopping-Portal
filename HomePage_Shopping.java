package cs1220.lab4;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomePage_Shopping
 */
@WebServlet("/cs1220/lab4/HomePage_Shopping")
public class HomePage_Shopping extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		ServletContext context=this.getServletContext();
		if((context.getAttribute("registerUserShopping"))==null){
			ArrayList<RegisterUser> arr=new ArrayList<>();
			arr.add(new RegisterUser("Ammar", "Barafwala", "ammarbarafwala@gmail.com","ammar","a$7",Long.parseLong("4542425651"), Long.parseLong("6262518556")));
			arr.add(new RegisterUser("Meet", "Thakkar", "mt@gmail.com", "meet", "m@1",Long.parseLong("1234567890"), Long.parseLong("9874563210")));
			context.setAttribute("registerUserShopping", arr);
			context.setAttribute("userName", "");
			context.setAttribute("password", "");	
		}
		if((context.getAttribute("admin"))==null){
			ArrayList<RegisterUser> arr=new ArrayList<>();
			arr.add(new RegisterUser("admin", "admin", "john@admin.com","admin","admin",Long.parseLong("6454242941"), Long.parseLong("6262518556")));
			context.setAttribute("admin", arr);
			context.setAttribute("userName", "");
			context.setAttribute("password", "");
			
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.sendRedirect("HomePage_Shopping.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
