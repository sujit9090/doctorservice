
package doctor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utility.DbCon;

@WebServlet("/doctor/home")
public class Home extends HttpServlet {
	ResultSet rs1, rs2;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession(false);
		String un = (String) hs.getAttribute("username");
		Connection cn1 = DbCon.getCon();
		Connection cn2 = DbCon.getCon();
		Thread t1 = new Thread(() -> {
			String sql = "select name from user where username = ?";
			try {
				PreparedStatement ps = cn1.prepareStatement(sql);
				ps.setString(1, un);
				rs1 = ps.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		Thread t2 = new Thread(() -> {
			String sql = "select u.name,a.slno, a.ap_date,a.ap_time from user u inner join appointment a "
					+ "on u.username = a.pat_username " + "where a.doc_username = ? and a.status = 0 ";
			
			try {
				PreparedStatement ps = cn2.prepareStatement(sql);
				ps.setString(1, un);
				rs2 = ps.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		});
		try {
			t1.start();
			t2.start();
			t1.join();
			t2.join();
			if (rs1.next())
				request.setAttribute("name", rs1.getString("name"));
			request.setAttribute("detail", rs2);
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
