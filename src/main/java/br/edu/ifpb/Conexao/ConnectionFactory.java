package br.edu.ifpb.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static ConnectionFactory instance;
    private static Connection connection;

    public ConnectionFactory() {
    }

    public static ConnectionFactory getIntance() throws ConnectionException {

        try {
            if (instance == null) {
                instance = new ConnectionFactory();
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/POD", "postgres", "123");
            }
        } catch (ClassNotFoundException e) {
            throw new ConnectionException("Driver não encontrado");
        } catch (SQLException e) {
            throw new ConnectionException("Dados de conexão inválidos");
        }
        return instance;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        ConnectionFactory.connection = connection;
    }
}
