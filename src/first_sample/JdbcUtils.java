package first_sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by N1kita on 28.12.2017.
 */
public final class JdbcUtils {

    private static boolean initialized;

    public static synchronized void initDriver(String driverClass){
            if (!initialized){
                try {
                    Class.forName(driverClass);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    throw new RuntimeException("Can't initialize driver: " + driverClass);
                }
                initialized = true;
            }
    }

    public static void closeQuietly(ResultSet resultSet){
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                // NOP
            }
        }
    }

    public static void closeQuietly(Statement statement){
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                // NOP
            }
        }
    }

    public static void closeQuietly(Connection connection){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // NOP
            }
        }
    }

    public static void rollbackQuietly(Connection connection){
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                //NOP
            }
        }
    }
}
