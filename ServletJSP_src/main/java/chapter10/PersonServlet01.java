package chapter10;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PersonServlet01")
public class PersonServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonLogic personLogic = new PersonLogic();
		List<String> names = personLogic.getAll();
		
		request.setAttribute("names", names);
		request.getRequestDispatcher("person01.jsp")
			.forward(request, response);
 	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フィルターで設定済みなら不要
		request.setCharacterEncoding("UTF-8"); 
		
		String newName = request.getParameter("name");
		
		PersonLogic personLogic = new PersonLogic();
		personLogic.add(newName);
		
		doGet(request, response);  // doGet()にチェーン
	}
}
