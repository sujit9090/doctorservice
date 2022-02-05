package patient;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.DbCon;

@WebServlet("/patient/searchdoctor")
public class SearchDoctor extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dept = request.getParameter("dept");	
		Connection cn = DbCon.getCon();
		String sql = "select name,username from user where dept = ?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, dept);
			ResultSet rs=ps.executeQuery();
			request.setAttribute("detail", rs);
			RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
