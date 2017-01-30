package cs1220.lab4;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Signin_Shopping
 */
@WebServlet("/cs1220/lab4/Signin_Shopping")
public class Signin_Shopping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin_Shopping() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String rememberMe=request.getParameter("rememberMe");
		ArrayList<RegisterUser> arr=(ArrayList<RegisterUser>) getServletContext().getAttribute("registerUserShopping");
		boolean flag=false;
		ServletContext context=getServletContext();
		for(RegisterUser ru:arr)
		{
			if(ru.getUserName().equalsIgnoreCase(userName))
			{
				if(ru.getPassword().equals(password))
				{
					flag=true;
					HttpSession session=request.getSession();
					session.setAttribute("firstname", ru.getFirstName());
					session.setAttribute("lastname", ru.getLastName());
					session.setAttribute("remember", rememberMe);
					session.setMaxInactiveInterval(30);
					response.sendRedirect("Welcome_Shopping.jsp");
					break;
				}
				else {
					break;
				}
			}
		}
		if(!flag)
		{
			ArrayList<RegisterUser> ad=(ArrayList<RegisterUser>) getServletContext().getAttribute("admin");
			for(RegisterUser ru:ad)
			{
				if(ru.getUserName().equalsIgnoreCase(userName))
				{
					if(ru.getPassword().equals(password))
					{
						flag=true;
						HttpSession session=request.getSession();
						session.setMaxInactiveInterval(30);
						session.setAttribute("remember", rememberMe);
						session.setAttribute("useradmin", arr);
						response.sendRedirect("Admin_Shopping");
						break;
					}
					else {
						break;
					}
				}
			}
		}
		if(!flag){
			context.setAttribute("error","Invalid Username/Password<br/>");
			response.sendRedirect("Signin_Shopping.jsp");
		}
	}
}
