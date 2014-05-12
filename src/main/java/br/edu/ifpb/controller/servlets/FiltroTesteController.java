package br.edu.ifpb.controller.servlets;

import br.edu.ifpb.model.entidades.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FiltroTesteController implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) req).getSession();

        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario == null) {

            session.setAttribute("msg", "Você não está logado no sistema!");

            ((HttpServletResponse) res).sendRedirect("../index.jsp");

        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {}
}