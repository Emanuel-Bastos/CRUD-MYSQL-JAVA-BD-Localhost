package createdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {

    public static void main(String[] args) {
        try {
            // Configurações do banco de dados
            String jdbcUrl = "jdbc:mysql://localhost:3306/";
            String username = "root";
            String password = "Admin@123";

            // Criar o banco de dados
            String createDatabaseSql = "CREATE DATABASE IF NOT EXISTS petshopefdb";
            executeSql(jdbcUrl, username, password, createDatabaseSql);

            // Criar a tabela no banco de dados correto
            String createTableSql = "CREATE TABLE IF NOT EXISTS cadastro_clientes_pets ("
                    + "id INT AUTO_INCREMENT,"
                    + "nome_tutor VARCHAR(100) NOT NULL,"
                    + "nome_pet VARCHAR(100) NOT NULL,"
                    + "raca VARCHAR(50),"
                    + "telefone VARCHAR(20),"
                    + "PRIMARY KEY (id)"
                    + ")";
            executeSql(jdbcUrl + "petshopefdb", username, password, createTableSql);

            System.out.println("Banco de dados e tabela criados com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void executeSql(String jdbcUrl, String username, String password, String sql) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
