package second_sample;

import java.sql.*;

/**
 * Created by N1kita on 31.12.2017.
 */
public class JDBC_example07 {
    /**mix DDL & DML example*/
    public static final String JDBC_URL
            = "jdbc:mysql://127.0.0.1:3306/users?user=user&password=password";

    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS Tmps;");
            statement.execute("CREATE TABLE Tmps (id INT, name VARCHAR(64));");

            statement.execute("INSERT INTO Tmps (id, name) VALUES (1, 'Nick');");
            statement.execute("INSERT INTO Tmps (id, name) VALUES (2, 'John');");
            statement.execute("INSERT INTO Tmps (id, name) VALUES (3, 'James');");

            ResultSet resultSet = statement.executeQuery("SELECT id, name FROM Tmps;");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.printf("%d, %s\n", id, name);
            }

            statement.execute("DROP TABLE Tmps;");
        }
    }
}
