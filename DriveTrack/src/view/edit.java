package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import create.Cconn;
import create.Createpojo;

/**
 * Servlet implementation class edit
 */
@WebServlet("/edit")
public class edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = request.getReader();
		String s = br.readLine();
		System.out.println("angular data"+s);
		ObjectMapper mp = new ObjectMapper();
		
		 Createpojo cp = mp.readValue(s,Createpojo.class);// it creates registerpojo object// json object to java object
		 System.out.println("java object"+cp);
		 try {
			 Connection con = Cconn.getDBConnection();

				PreparedStatement ps = con.prepareStatement("update drive set COMPANY_NAME=?, NO_OF_RSRCS=?, EXP_REQ=?, CTC=?,JOIN_CRT=?,BOND=?, POSITION=?, FOLLOWUP=?, EDU_CRT=? where did=?");

				ps.setObject(1, cp.getCompanyname());
				ps.setObject(2, cp.getResources());
				ps.setObject(3, cp.getExperience());
				ps.setObject(4, cp.getCtc());
				ps.setObject(5, cp.getCriteria());
				ps.setObject(6, cp.getBond());
				ps.setObject(7, cp.getPosition());
				ps.setObject(8, cp.getFollowup());
				ps.setObject(9, cp.getCriteria());
				ps.setObject(10, cp.getDid());
				

				int status = ps.executeUpdate();
				Map<String, String> m = new HashMap<>();
				if (status == 1) 
				{
					m.put("msg", "succesfully updated");
				}  
				else 
				{
					m.put("msg", "error");
				}
	               System.out.println("map object=" + m);
				
				String jsonstr=mp.writeValueAsString(m);
				
				System.out.println("json string="+jsonstr);
			 }
			 catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				
		}
		
	}

}
