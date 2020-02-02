package drive.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import drive.beans.Drive;
import drive.dao.DaoLayer;
import drive.utility.UtilityJson;
@WebServlet("/Create")
public class CreateDrive extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BufferedReader br = request.getReader();

		String s = br.readLine();

		Drive d = (Drive) UtilityJson.getObjectFromJSON(s, Drive.class);

		
		Map<String, String> mp=DaoLayer.save(d);
		
		String rdata=(String) UtilityJson.getJSONFromObject(mp);
		
		PrintWriter pw=response.getWriter();
		
		pw.write(rdata);
		
		

	}

}
