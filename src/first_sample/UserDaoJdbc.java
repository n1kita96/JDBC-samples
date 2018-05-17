package first_sample;

import com.sun.rowset.JdbcRowSetImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by N1kita on 28.12.2017.
 */
public class UserDaoJdbc implements UserDao{

    static {
        JdbcUtils.initDriver("com.mysql.jdbc.Driver");
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "user", "password");
    }

    @Override
    public List<User> selectAll() throws SQLException {
        Connection connection = getConnection();
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT  id, login, email FROM Users");
            List<User> result = new ArrayList<>();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String email = resultSet.getString("email");

                User user = new User(id);
                user.setLogin(login);
                user.setEmail(email);

                result.add(user);
            }

            connection.commit();
            return result;
        } catch (SQLException e) {
            JdbcUtils.rollbackQuietly(connection);
            throw e;
        } finally {
            JdbcUtils.closeQuietly(resultSet);
            JdbcUtils.closeQuietly(statement);
            JdbcUtils.closeQuietly(connection); // should be cached (connection is expensive object)
        }

    }


    @Override
    public int deleteById(int id) throws SQLException{
        Connection connection = getConnection();
        connection.setAutoCommit(false);
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement("DELETE FROM Users WHERE id = ?");
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            connection.commit();
            return result;
        } catch (SQLException ex){
            JdbcUtils.rollbackQuietly(connection);
            throw ex;
        } finally {
            JdbcUtils.closeQuietly(ps);
            JdbcUtils.closeQuietly(connection);
        }
    }

    @Override
    public void insert(User user) throws SQLException {
        Connection connection = getConnection();
        connection.setAutoCommit(false);
        PreparedStatement ps = null;

        try{
            ps = connection.prepareStatement("INSERT INTO Users VALUES (?, ?, ?)");
            ps.setInt(1, user.getId());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getEmail());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            JdbcUtils.rollbackQuietly(connection);
            throw ex;
        } finally {
            JdbcUtils.closeQuietly(ps);
            JdbcUtils.closeQuietly(connection);
        }
    }

}
