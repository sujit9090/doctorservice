package loginsignup;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.DbCon;

@WebServlet("/registration")
public class Registration extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String occuption = request.getParameter("occuption");
		String dept = request.getParameter("dept");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		Connection cn=DbCon.getCon();
		if(occuption.equals("1"))
		{
			try {
				String sql = "insert into user (name,username,password,occupation,email,phone,"+
						"address ) values (?,?,?,?,?,?,?)";
				
				
				PreparedStatement ps=cn.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, username);
				ps.setString(3, password);
				ps.setInt(4, Integer.parseInt(occuption));
				ps.setString(5, email);
				ps.setString(6, phone);
				ps.setString(7, address);
				ps.executeUpdate();
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp?reg=pass");
				rd.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			try {
				String sql = "insert into user (name,username,password,occupation,dept,email,"+
						"phone,address) values (?,?,?,?,?,?,?,?)";
				PreparedStatement ps=cn.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, username);
				ps.setString(3, password);
				ps.setString(4, occuption);
				ps.setString(5, dept);
				ps.setString(6, email);
				ps.setString(7, phone);
				ps.setString(8, address);
				ps.executeUpdate();
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp?reg=pass");
				rd.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
