package first_sample;

import java.sql.SQLException;

/**
 * Created by N1kita on 28.12.2017.
 */
public class Main {

    public static void main(String[] args) throws SQLException{

        UserDao dao = new UserDaoJdbc();

        System.out.println("--Before insert--");
        for (User user : dao.selectAll()) {
            System.out.println(user.toString());
        }

        User newUser = new User(2);
        newUser.setLogin("Mykyta");
        newUser.setEmail("n1kitaflow96@gmail.com");

        dao.insert(newUser);

        System.out.println("--After insert--");
        for (User user : dao.selectAll()) {
            System.out.println(user.toString());
        }

        dao.deleteById(2);

        System.out.println("--After delete--");
        for (User user : dao.selectAll()) {
            System.out.println(user.toString());
        }
    }
}
