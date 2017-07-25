package blog.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by albertkurnia on 7/25/2017.
 */
public class RegisterForm {

    @NotNull
    @Size(min=2,max=30, message = "Please fill the field")
    private String fullName;

    @Size(min=2, max=30, message = "Username size should be in the range [2..30]")
    private String username;

    @NotNull
    @Size(min=1, max=50)
    private String password;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
