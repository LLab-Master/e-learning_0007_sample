package chapter07;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SesScope02")
public class SesScope02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// セッション取得
		HttpSession session = request.getSession();
		// セッションスコープから取り出す
		Human h1 = (Human)session.getAttribute("human2");

		// JSP にフォワードしたら、セッションを消す主体がいなくなるので、
		// データをリクエストスコープに転載した後、セッションを破棄
		request.setAttribute("human3", h1);
		session.invalidate();
		// JSPにフォワード
		request.getRequestDispatcher("ses_scope02.jsp")
				.forward(request, response);
		
	}		
		
}

