package stars;
import java.io.Serializable;

public class User implements Serializable{
    private String password;
    private String email;
    private String typeOfUser;
    private String userName;
    public User()
    {

    }
    public User(String password, String email, String typeOfUser, String userName) {
        this.password = password;
        this.email = email;
        this.typeOfUser = typeOfUser;
        this.userName=userName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeOfUser() {
        return this.typeOfUser;
    }

    public void setTypeOfUser(String typeOfUser) {
        this.typeOfUser = typeOfUser;
    }
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public boolean matchPassword(String password) {
        //method that will be used for password checking during login
        if (this.password.equals(password))
            return true;
        else
            return false;
    }
}

