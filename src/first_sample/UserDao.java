package first_sample;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by N1kita on 28.12.2017.
 */
public interface UserDao {

    List<User> selectAll() throws SQLException;

    int deleteById(int id) throws SQLException;

    void insert(User user) throws SQLException; ;

}
