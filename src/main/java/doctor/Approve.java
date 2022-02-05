package doctor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.DbCon;
@WebServlet("/doctor/approve")
public class Approve extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		String slno = request.getParameter("slno");
		int status = op.equals("1") ? 1 : 2;
		String sql = "update appointment set status = ? where slno = ?";
		Connection cn= DbCon.getCon();
		try {
			PreparedStatement ps= cn.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setInt(2, Integer.parseInt(slno));
			ps.executeUpdate();
			response.sendRedirect("home");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
