package second_sample;

import java.sql.*;

/**
 * Created by N1kita on 31.12.2017.
 */
public class JDBC_example08 {
    public static final String JDBC_URL
            = "jdbc:mysql://127.0.0.1:3306/users?user=user&password=password";

    public static void main(String[] args) throws SQLException {
            Connection connection = DriverManager.getConnection(JDBC_URL);
            try {
                connection.setAutoCommit(false);
                Statement statement = connection.createStatement();
                statement.execute("INSERT INTO Tmps (id, name) VALUES (1, 'Nick');");
                connection.commit();
            } catch (Exception e){
                if (connection != null){
                    connection.rollback();
                }
                throw e;
            }
        }
}
