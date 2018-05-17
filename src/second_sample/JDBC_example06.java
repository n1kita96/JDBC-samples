package second_sample;

import java.sql.*;

/**
 * Created by N1kita on 31.12.2017.
 */
public class JDBC_example06 {

    public static final String JDBC_URL
            = "jdbc:mysql://127.0.0.1:3306/users?user=user&password=password";

    public static void main(String[] args) throws SQLException {
        try(Connection connection = DriverManager.getConnection(JDBC_URL)){
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS tmp;");
            statement.execute("CREATE TABLE tmp (id INT, name VARCHAR(64));");
            statement.execute("DROP TABLE tmp;");
        }
    }
}
