package cs1220.lab4;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Save_Shopping
 */
@WebServlet("/cs1220/lab4/Save_Shopping")
public class Save_Shopping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Save_Shopping() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String movieName=request.getParameter("movieName").trim();
		String imageUrl=request.getParameter("imageUrl").trim();
		String price=request.getParameter("price").trim();
		String quantity=request.getParameter("quantity").trim();
		HttpSession s=request.getSession();
		int id=Integer.parseInt(((Items)s.getAttribute("id")).getId()+"");
		ArrayList<Items> i=(ArrayList<Items>) s.getAttribute("admindata_Shopping");
		if(!movieName.isEmpty())
			i.get(id-1).setName(movieName);
		if(!imageUrl.isEmpty())
			i.get(id-1).setImage(imageUrl);
		if(!price.isEmpty())
			i.get(id-1).setPrice(Integer.parseInt(price));
		if(!quantity.isEmpty())
			i.get(id-1).setQuantity(Integer.parseInt(quantity));
		response.sendRedirect("Admin_Shopping.jsp");
	}

}
