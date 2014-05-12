
package servlet.app;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MessagesControllerServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		int offset = 0;
		String offsetstring  = req.getParameter("offset");
		if (offsetstring  != null && !"".equals(offsetstring )){
			offset = Integer.valueOf(offsetstring);
		}
		System.out.println(offsetstring);
		System.out.println(offset);
		//
	  Repository repository = new Repository();
	  List<String> list = repository.list(offset);
	  //
	  StringBuffer buffer = new StringBuffer();
	  buffer.append("[");
	  for (int i = 0; i < list.size(); i++) {
	  	String v = list.get(i);
	  	if (v != null){
	  		if (i > 0){
		  		buffer.append(", ");//finaliza aspas
		  	}
	  		buffer.append("\"");//inicia aspas
	  		buffer.append(list.get(i));
	  		buffer.append("\"");//finaliza aspas
	  	}
    }
	  buffer.append("]");
	  //
	  resp.setContentType("application/json");
	  resp.getOutputStream().write(buffer.toString().getBytes());
	  resp.getOutputStream().close();
	}

}
