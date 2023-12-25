package chapter07;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SesScope01")
public class SesScope01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Human h1 = new Human("佐藤", 22);

		// セッション作成
		HttpSession session = request.getSession();
		// セッションスコープに保存
		session.setAttribute("human2", h1);

		// JPSにフォワード
		request.getRequestDispatcher("ses_scope01.jsp")
				.forward(request, response);
		
	}		
		
}

