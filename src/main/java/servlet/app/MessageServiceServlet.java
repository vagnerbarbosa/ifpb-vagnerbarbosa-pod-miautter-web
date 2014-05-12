package servlet.app;

import br.edu.ifpb.model.entidades.Usuario;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MessageServiceServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//inicial
		String result = "ERROR";
		//processamento
          Usuario u = new Usuario();
          u = (Usuario) req.getSession().getAttribute("usuario");
	  
          String message = u.getNome() + ": " + req.getParameter("message");          
          
          
	  if (message != null && !"".equals(message)){
	  	Repository repository = new Repository();                          
	  	repository.store(message);
	  	result = "OK";
	  }
	  //resposta
	  resp.getOutputStream().write(result.getBytes());
	}

}
