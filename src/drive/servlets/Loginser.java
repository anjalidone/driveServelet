package drive.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import drive.utility.UtilityJson;

@WebServlet("/Loginser")
public class Loginser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String jsonobject = request.getReader().readLine();
		System.out.println(jsonobject);

		//Loginpojo log = (Loginpojo)UtilityJson.getObjectFromJSON(jsonobject, Loginpojo.class);
		//System.out.println(log);

		Map<String, String> mp = null;
		
		String jsonString = (String) UtilityJson.getJSONFromObject(mp);

		response.getWriter().write(jsonString);

		response.flushBuffer();

	}

}
