package loginsignup;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/login")
public class Login extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String username=request.getParameter("username");
		String password= request.getParameter("password");
		Connection cn=DbCon.getCon();
		String sql = "select occupation from user where username = ? and password = ?";
		try {
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				HttpSession hs=request.getSession(true);
				hs.setAttribute("username", username);
				int a = rs.getInt("occupation");
				String page= a==2 ? "doctor/home" : "patient/home";
				response.sendRedirect(page);
			}else {
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp?login=failed");			
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
