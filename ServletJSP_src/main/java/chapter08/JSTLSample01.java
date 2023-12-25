package chapter08;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JSTLSample01
 */
@WebServlet("/JSTLSample01")
public class JSTLSample01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> persons = new ArrayList<>();
		
		persons.add("太郎");
		persons.add("次郎");
		persons.add("鬼");
		persons.add("花子");

		request.setAttribute("persons", persons);
		request.getRequestDispatcher("/jstl_sample01.jsp")
			.forward(request, response);
	}

}
