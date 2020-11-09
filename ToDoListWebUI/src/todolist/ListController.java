package todolist;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sd2.ToDoListProcessing;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/")
public class ListController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ToDoListProcessing tdlp;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch (action) {
			case "/link":
				checkLink(request, response);
				break;
	        case "/addItem":
	            insertItem(request, response);
	            break;
	        case "/delete":
	            deleteItem(request, response);
	            break;
	        case "/showList":
	            showList(request, response);
	            break;
	        default:
	            break;	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void insertItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		tdlp = new ToDoListProcessing();
		String item = request.getParameter("item");
		//tdlp.getAllToDoListItems(); 
		tdlp.addItem(item);
		tdlp.saveToDoList();
		showList(request, response);
	}
	private void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int itemNumber = Integer.parseInt(request.getParameter("id"));
		tdlp = new ToDoListProcessing();
		tdlp.deleteItem(itemNumber);
		tdlp.saveToDoList();
		showList(request, response);
	}
	private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		tdlp = new ToDoListProcessing();
		HashMap<Integer,String> list = tdlp.getAllToDoListItems();
		request.setAttribute("list", list);
		RequestDispatcher dispatch = request.getRequestDispatcher("showlist.jsp");
		dispatch.forward(request, response);
	}
	private void checkLink(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String link = request.getParameter("link");
		if (link.equalsIgnoreCase("add")) {
			response.sendRedirect(request.getContextPath() + "/additem.jsp");
		}else if(link.equalsIgnoreCase("show")) {
			showList(request, response);
		}else {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
	}
	

}
