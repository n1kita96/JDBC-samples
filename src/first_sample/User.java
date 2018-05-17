package first_sample;

/**
 * Created by N1kita on 28.12.2017.
 */
public class User {

    private String login;
    private String email;
    private int id;

    public User(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                " id=" + id + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email +
                '}';
    }
}
