package drive.servlets;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import drive.beans.Drive;
import drive.dao.DaoLayer;
import drive.utility.UtilityJson;

@WebServlet("/edit")
public class EditDrive extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String requestData = request.getReader().readLine();
		
		Drive u = (Drive) UtilityJson.getObjectFromJSON(requestData, Drive.class);

		Map<String, String> map = DaoLayer.update(u);

		String responseData = (String) UtilityJson.getJSONFromObject(map);
		
		response.getWriter().write(responseData);
		
		response.flushBuffer();

		
				
	}

}
