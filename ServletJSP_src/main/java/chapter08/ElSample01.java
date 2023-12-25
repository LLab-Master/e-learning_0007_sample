package chapter08;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ElSample01")
public class ElSample01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Human h1 = new Human("山田", 20);

		// リクエストスコープに保存
		request.setAttribute("human1", h1);

		// JPSにフォワード
		request.getRequestDispatcher("el_sample01.jsp")
				.forward(request, response);
		
	}

}
