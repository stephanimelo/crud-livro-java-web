package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {
    private static final String URL =
        "jdbc:sqlserver://localhost:1433;databaseName=db_livraria;encrypt=false";
    private static final String USER = "sa";
    private static final String SENHA = "SuaSenha123";

    public static Connection getConexao() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(URL, USER, SENHA);
    }
}