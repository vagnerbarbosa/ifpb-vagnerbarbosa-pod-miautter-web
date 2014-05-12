package br.edu.ifpb.daos.interfaces;

import br.edu.ifpb.model.entidades.Usuario;
import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAOInterface {
    
    public Usuario recuperarUsuario(Integer id) throws SQLException;
    public void persistirUsuario(Usuario usuario) throws SQLException;
    public List<Usuario> listarUsuarios() throws SQLException;
    public void atualizarUsuario(Usuario usuario) throws SQLException;
    public Usuario recuperarUsuarioPorLogin(String login) throws SQLException;
    
}
