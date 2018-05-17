package second_sample;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by N1kita on 28.12.2017.
 */
public class JDBC_example05 {
    public static final String JDBC_URL
            = "jdbc:mysql://127.0.0.1:3306/users?user=user&password=password";

    public static void main(String[] args) throws SQLException {
        Driver driver = new com.mysql.jdbc.Driver();

        for (int i = 0; i < 200; i++) {
            long t0 = System.nanoTime();
            try(Connection connection = driver.connect(JDBC_URL, new Properties())){}
            long t1 = System.nanoTime();
            System.out.printf("%,10d\n", t1-t0);
        }
    }

}
