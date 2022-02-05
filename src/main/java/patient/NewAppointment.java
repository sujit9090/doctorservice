package patient;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utility.DbCon;

@WebServlet("/patient/newappointment")
public class NewAppointment extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession(false);
		String pun = (String) hs.getAttribute("username");
		String dun = request.getParameter("username");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		Connection cn = DbCon.getCon();
		String sql = "insert into appointment (pat_username,doc_username,ap_date,ap_time) "+
				"values (?,?,?,?)";
		try {
			PreparedStatement ps= cn.prepareStatement(sql);
			ps.setString(1, pun);
			ps.setString(2, dun);
			ps.setString(3, date);
			ps.setString(4, time);
			ps.executeUpdate();
			response.sendRedirect("home");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
