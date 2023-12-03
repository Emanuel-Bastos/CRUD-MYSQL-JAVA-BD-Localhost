package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection conector() {
        Connection conexao = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/petshopefdb?useTimezone=true&serverTimezone=UTC";
        String usuario = "root";
        String senha = "Admin@123";

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);

            if (conexao != null) {
                System.out.println("Conexão aberta com sucesso!");
            }

            return conexao;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
            System.out.println("Não foi possível realizar a conexão com o banco!");
            return null;
        }
    }
}