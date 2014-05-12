package br.edu.ifpb.daos;

import br.edu.ifpb.Conexao.ConnectionException;
import br.edu.ifpb.Conexao.ConnectionFactory;
import br.edu.ifpb.daos.interfaces.UsuarioDAOInterface;
import br.edu.ifpb.model.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements UsuarioDAOInterface {

    private Connection connection;

    public UsuarioDAO() throws ConnectionException {
        this.connection = ConnectionFactory.getIntance().getConnection();
    }

    @Override
    public Usuario recuperarUsuario(Integer id) throws SQLException {

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuario WHERE id = ?");
        statement.setInt(1, id);
        statement.execute();
        Usuario usuario = null;
        while (statement.getResultSet().next()) {
            usuario = new Usuario();
            usuario.setId(statement.getResultSet().getLong("id"));
            usuario.setNome(statement.getResultSet().getString("nome"));
            usuario.setEmail(statement.getResultSet().getString("email"));
            usuario.setLogin(statement.getResultSet().getString("login"));
            usuario.setSenha(statement.getResultSet().getString("senha"));
        }
        return usuario;

    }

    @Override
    public void persistirUsuario(Usuario usuario) throws SQLException {

        PreparedStatement statement = connection.prepareStatement("INSERT INTO usuario(nome, email, login, senha) VALUES(?,?,?,?)");
        statement.setString(1, usuario.getNome());
        statement.setString(2, usuario.getEmail());
        statement.setString(3, usuario.getLogin());
        statement.setString(4, usuario.getSenha());
        statement.executeUpdate();
    }

    @Override
    public List<Usuario> listarUsuarios() throws SQLException {

        Statement statement = connection.createStatement();


        ResultSet resultSet = statement.executeQuery("SELECT * FROM usuario");

        List<Usuario> usuarios = new ArrayList<Usuario>();

        while (resultSet.next()) {

            Usuario usuario = new Usuario();
            usuario.setId(statement.getResultSet().getLong("id"));
            usuario.setNome(statement.getResultSet().getString("nome"));
            usuario.setEmail(statement.getResultSet().getString("email"));
            usuario.setLogin(statement.getResultSet().getString("login"));
            usuario.setSenha(statement.getResultSet().getString("senha"));
            usuarios.add(usuario);
        }

        return usuarios;
    }

    @Override
    public void atualizarUsuario(Usuario usuario) throws SQLException {

        PreparedStatement statement = connection.prepareStatement("UPDATE usuario set nome = ?, email = ?, login = ?, senha = ? where id =? ");
        statement.setLong(5, usuario.getId());
        statement.setString(1, usuario.getNome());
        statement.setString(2, usuario.getEmail());
        statement.setString(3, usuario.getLogin());
        statement.setString(4, usuario.getSenha());
        statement.executeUpdate();
    }

    public void removerUsuario(int id) throws SQLException {

        PreparedStatement statement = connection.prepareStatement("DELETE FROM USUARIO WHERE id = ?");
        statement.setLong(1, id);
        statement.executeUpdate();
    }

    @Override
    public Usuario recuperarUsuarioPorLogin(String login) throws SQLException {

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuario WHERE login = ?");
        statement.setString(1, login);
        statement.execute();
        Usuario usuario = null;
        while (statement.getResultSet().next()) {
            usuario = new Usuario();
            usuario.setId(statement.getResultSet().getLong("id"));
            usuario.setNome(statement.getResultSet().getString("nome"));
            usuario.setEmail(statement.getResultSet().getString("email"));
            usuario.setLogin(statement.getResultSet().getString("login"));
            usuario.setSenha(statement.getResultSet().getString("senha"));
        }
        return usuario;
    }
}
