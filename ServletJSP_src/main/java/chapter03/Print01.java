package chapter03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoGet01
 */
@WebServlet("/Print01")
public class Print01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Content-Type ヘッダの設定
		response.setContentType("text/html; charset=UTF-8");

		// PrintWriter 取得
		PrintWriter out = response.getWriter();

		// HTML 書き出し
		out.println("<html>");
		out.println("<p>Hello Servlet/JSP !</p>");
		out.println("</html>");
	}

}
