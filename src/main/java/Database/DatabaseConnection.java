package Database;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {
    //String de conexão co o banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/banco_dados";

    //método para carregar o driver de conexão
    public static Connection connect() throws SQLException {
        try {
            //carrega o driver jdbc
            Class.forName("com.mysql.cj.jdbc.Driver");
                return  DriverManager.getConnection(URL);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver não encontrado", e );
        }
    }
}
