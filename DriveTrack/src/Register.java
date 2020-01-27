

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


/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("Welcome dopost");
		BufferedReader br = request.getReader();
		String s = br.readLine();
		System.out.println("angular data"+s);
		ObjectMapper mp = new ObjectMapper();
		
		 Registerpojo rp = mp.readValue(s,Registerpojo.class);// it creates registerpojo object// json object to java object
		 System.out.println("java object"+rp);
		 try {
		 Connection con = Jdconn.getDBConnection();

			PreparedStatement ps = con.prepareStatement("insert into stud(name, pass, mail, gender, country, mobile) values(?,?,?,?,?,?)");

			ps.setObject(1, rp.getName());
			ps.setObject(2, rp.getPass());
			ps.setObject(3, rp.getMail());
			ps.setObject(4, rp.getGender());
			ps.setObject(5, rp.getCountry());
			ps.setObject(6, rp.getMobile());
			

			int status = ps.executeUpdate();
			Map<String, String> m = new HashMap<>();
			if (status == 1) 
			{
				m.put("msg", "succesfully register");
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
