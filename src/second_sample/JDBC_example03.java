package second_sample;

import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by N1kita on 28.12.2017.
 */
public class JDBC_example03 {
    public static final String JDBC_URL
            = "jdbc:mysql://127.0.0.1:3306/users?user=user&password=password";

    public static void main(String[] args) throws SQLException {
        java.sql.Driver driver = new com.mysql.jdbc.Driver(); //java.sql.Driver

        System.out.println(driver.acceptsURL("jdbc:SUPER_DB")); //false
        System.out.println(driver.acceptsURL(JDBC_URL)); //true

        try(java.sql.Connection connection = driver.connect(
                JDBC_URL, new Properties())){ // autoclosable
            System.out.println(connection);
        }
    }
}
