//package drive.servlets;
//
//
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.Map;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import drive.beans.Register;
//import drive.dao.DaoLayer;
//import drive.utility.UtilityJson;
//
//@WebServlet("/Register")
//public class Registerservlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		String requestdata = request.getReader().readLine();
//
//		Register rp = (Register) UtilityJson.getObjectFromJSON(requestdata, Registerservlet.class);
//
//		Map<String, String> map = null;
//		try {
//		map=DaoLayer.saveData(rp);
//		}
//		catch(ClassNotFoundException e)
//		{
//			e.printStackTrace();
//		}
//		catch(SQLException e)
//		{
//			e.printStackTrace();
//		}
//		
//String responsedata = (String) UtilityJson.getJSONFromObject(map);
//		
//		response.getWriter().write(responsedata);
//		
//		response.flushBuffer();
//
//}
//}
