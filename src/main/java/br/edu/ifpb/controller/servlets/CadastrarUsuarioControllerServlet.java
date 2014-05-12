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

@WebServlet(name = "CadastrarUsuario", urlPatterns = {"/CadastrarUsuario"})
public class CadastrarUsuarioControllerServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ConnectionException, SQLException {
             Usuario usuario = new Usuario();             
             UsuarioDAO uDAO = new UsuarioDAO();                    
                    usuario.setNome(request.getParameter("nome"));
                    usuario.setLogin(request.getParameter("login"));
                    usuario.setEmail(request.getParameter("email"));
                    usuario.setSenha(request.getParameter("senha"));                    
                    
                      uDAO.persistirUsuario(usuario);
                      request.setAttribute("mensagem", "Usuario: "+request.getParameter("nome")+" Cadastrado com sucesso!");
                      request.getRequestDispatcher("index.jsp").forward(request, response);
             
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ConnectionException ex) {
            Logger.getLogger(CadastrarUsuarioControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarUsuarioControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ConnectionException ex) {
            Logger.getLogger(CadastrarUsuarioControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarUsuarioControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
