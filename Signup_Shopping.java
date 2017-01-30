package cs1220.lab4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Signup_Shopping
 */
@WebServlet("/cs1220/lab4/Signup_Shopping")
public class Signup_Shopping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup_Shopping() {
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
		PrintWriter pr=response.getWriter();
		String firstName=((String) request.getParameter("firstName")).trim();
		String lastName=((String) request.getParameter("lastName")).trim();
		String email=((String) request.getParameter("email")).trim();
		String password=((String) request.getParameter("password")).trim();
		String userName=((String) request.getParameter("userName")).trim();
		String phone=((String) request.getParameter("phone")).trim();
		String creditCard=((String) request.getParameter("creditCard")).trim();
		boolean flag=true;
		String[] s={"","","","","","",""};
		
		ArrayList<RegisterUser> arr=(ArrayList<RegisterUser>) getServletContext().getAttribute("registerUser");
		
		if(!firstName.isEmpty())
		{
			if(!firstName.matches("[a-zA-Z]+")){
				s[0]="First Name should contain only alphabets<br/>";
				flag=false;
			}
		}
		else
		{
			s[0]="First Name cannot be empty<br/>";
			flag=false;
		}
		if(!lastName.isEmpty())
		{
			if(!lastName.matches("[a-zA-Z]+"))
			{
				s[1]="Last Name should contain only alphabets<br/>";
				flag=false;
			}
		}
		else
		{
			s[1]="Last Name cannot be empty<br/>";
			flag=false;
		}
		if(!email.isEmpty())
		{
			if(email.contains("@") && email.contains("."))
			{
				int index1=email.indexOf('@');
				int index2=email.indexOf('.');
				if(!email.substring(0,index1).matches("[a-zA-Z0-9_-]+") || !email.substring(index1+1,index2).matches("[a-zA-Z0-9]+") || !email.substring(index2+1,email.length()).matches("[a-zA-Z0-9]+"))
				{
					s[2]="Please enter valid email id eg: jane@admin.com<br/>";
					flag=false;
				}
			}
			else
			{
				s[2]="Please enter correct email id eg: jane@admin.com<br/>";
				flag=false;
			}
		}
		else {
			s[2]="Email cannot be empty<br/>";
			flag=false;
		}
		
		if(!userName.isEmpty())
		{
			for(RegisterUser user:arr)
				if(user.getUserName().equalsIgnoreCase(userName))
				{
					s[3]="Username already exists<br/>";
					flag=false;
					break;
				}
		}
		else {
			s[3]="Username cannot be empty<br/>";
			flag=false;
		}
		if(!password.isEmpty())
		{
			if(!password.matches("((?=.*\\d)(?=.*[a-zA-Z])(?=.*[\\W]).{1,})"))
			{
				s[4]="Password should atleast contain one alphabet, one digit and one special character<br/>";
				flag=false;
			}
		}
		else {
			s[4]="Password cannot be empty<br/>";
			flag=false;
		}
		if(!phone.isEmpty())
		{
			if(phone.length()!=10 && !phone.matches("[0-9]+")){
				s[5]="Please enter a valid phone number<br/>";
				flag=false;
			}
		}
		else {
			s[5]="Phone Number cannot be empty<br/>";
			flag=false;
		}
		if(!creditCard.isEmpty()){
			if(creditCard.length()!=10 && !creditCard.matches("[0-9]+")){
				s[6]="Please enter a valid credit card number<br/>";
				flag=false;
			}
		}
		else
		{
			s[6]="Credit card number cannot be empty<br/>";
			flag=false;
		}
		
		if(flag){
			arr.add(new RegisterUser(firstName, lastName, email, userName, password, Long.parseLong(creditCard), Long.parseLong(phone)));
			response.sendRedirect("Signin_Shopping.jsp");
		}
		else{
			ServletContext context=getServletContext();
			for(int i=0;i<s.length;i++)
				context.setAttribute("s"+i, s[i]);
			response.sendRedirect("Signup_Shopping.jsp");
		}
	}
}
