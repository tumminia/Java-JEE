package pietro.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pietro.jdbc.*;

@WebServlet({ "/PrenotaServlet", "/prenota" })
public class PrenotaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Pg pg; 

	public PrenotaServlet() {
        super();
        pg = new Pg();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cogn = request.getParameter("cogn");
		String tel = request.getParameter("tel");
		String data = request.getParameter("data");
		String ora = request.getParameter("ora");
		int tav = Integer.parseInt(request.getParameter("num"));
		
		pg.prenota(nome, cogn, tel, data, ora, tav);
		
		response.sendRedirect("/pietro/table.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
