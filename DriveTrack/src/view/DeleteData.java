package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteData
 */
@WebServlet("/DeleteData")
public class DeleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = request.getReader();
		String s = br.readLine();
		System.out.println(s);
		Connection con;
		try {
			con = Vconn.getDBConnection();
			PreparedStatement ps =con.prepareStatement("delete from drive where DID=?");
			ps.setObject(1, s);
			ps.executeUpdate();
		}
		
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
	}

}
