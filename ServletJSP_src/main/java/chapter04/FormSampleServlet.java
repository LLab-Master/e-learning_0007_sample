package chapter04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FormSampleServlet")
public class FormSampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストの文字コード
		request.setCharacterEncoding("UTF-8");
		
		// リクエストパラメータの取得
		String userName = request.getParameter("user_name");
		String age = request.getParameter("age");
		
		// Content-Type ヘッダの設定
		response.setContentType("text/html; charset=UTF-8");

		// PrintWriter 取得
		PrintWriter out = response.getWriter();

		// HTML 書き出し
		out.println("<html>");

		out.println("<p>" + userName + "さんは" + age + "歳ですね</p>");
				
		out.println("</html>");
	}

}
