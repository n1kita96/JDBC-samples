package second_sample;

import com.mysql.jdbc.JDBC4Connection;

import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by N1kita on 28.12.2017.
 */
public class JDBC_example02 {

    public static final String JDBC_URL
            = "jdbc:mysql://127.0.0.1:3306/users?user=user&password=password";

    public static void main(String[] args) throws SQLException {
        com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
        try(com.mysql.jdbc.JDBC4Connection connection = (JDBC4Connection) driver.connect(
                JDBC_URL, new Properties())){ // autoclosable
            System.out.println(connection);
        }
    }

}
