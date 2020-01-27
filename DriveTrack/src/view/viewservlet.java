package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import create.Createpojo;

/**
 * Servlet implementation class viewservlet
 */
@WebServlet("/views")
public class viewservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			Connection con = Vconn.getDBConnection();
			PreparedStatement ps = con.prepareStatement("select *from drive");
			ResultSet rs = ps.executeQuery();
			ArrayList<Createpojo> al  = new ArrayList<>();
			while(rs.next()) {
				Createpojo cp = new Createpojo();
				cp.setDid(rs.getInt(1));
				cp.setCompanyname(rs.getString(2));
				cp.setResources(rs.getInt(3));
				cp.setExperience(rs.getInt(4));
				cp.setCtc(rs.getInt(5));
				cp.setBond(rs.getFloat(7));
				cp.setPosition(rs.getInt(8));
				cp.setFollowup(rs.getString(9));
				cp.setCriteria(rs.getInt(10));
				cp.setJoining(rs.getInt(6));
				al.add(cp);
				
	
				
			}
			ObjectMapper ob = new ObjectMapper();
			String s = ob.writeValueAsString(al);
			PrintWriter pw = response.getWriter();
			pw.write(s);	

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	   
}
