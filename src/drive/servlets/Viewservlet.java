package drive.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import drive.beans.Drive;
import drive.dao.DaoLayer;
import drive.utility.UtilityJson;

@WebServlet("/views")
public class Viewservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	ArrayList<Drive> list = DaoLayer.getUserDataFromDB();
	
	String responseData = (String) UtilityJson.getJSONFromObject(list);

	response.getWriter().write(responseData);

	response.flushBuffer();
	
	}
}