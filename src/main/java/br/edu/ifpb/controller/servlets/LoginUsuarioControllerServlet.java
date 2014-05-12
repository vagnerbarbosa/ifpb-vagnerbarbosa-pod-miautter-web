package br.edu.ifpb.controller.servlets;

import br.edu.ifpb.Conexao.ConnectionException;
import br.edu.ifpb.daos.UsuarioDAO;
import br.edu.ifpb.model.entidades.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginUsuario", urlPatterns = {"/LoginUsuario"})
public class LoginUsuarioControllerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ConnectionException, SQLException {

        String login = (request.getParameter("login"));
        String senha = (request.getParameter("senha"));

        Usuario usuario = new Usuario();
        UsuarioDAO uDAO = new UsuarioDAO();
        usuario = uDAO.recuperarUsuarioPorLogin(login);

        if (usuario != null && usuario.getSenha().equals(senha)) {
            System.out.println("Setando usuario na sessao " + usuario);
            request.getSession().setAttribute("usuario", usuario);
            request.getRequestDispatcher("user/home.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            try {
                processRequest(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(LoginUsuarioControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ConnectionException ex) {
            Logger.getLogger(LoginUsuarioControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            try {
                processRequest(request, response);
            } catch (ConnectionException ex) {
                Logger.getLogger(LoginUsuarioControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginUsuarioControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
