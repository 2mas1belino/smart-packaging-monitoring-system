package pt.ipleiria.estg.dei.ei.dae.daeproject.dtos;

import org.hibernate.Hibernate;
import pt.ipleiria.estg.dei.ei.dae.daeproject.entities.User;

import java.util.List;
import java.util.stream.Collectors;


public class UserDTO {
    private String username;
    private String email;
    private String role;

    // empty constructor
    public UserDTO() {

    }

    // constructor
    public UserDTO(String username, String email, String role) {
        this.username = username;
        this.email = email;
        this.role = role;
    }
    public static UserDTO from(User user) {
        return new UserDTO(
                user.getUsername(),
                user.getEmail(),
                Hibernate.getClass(user).getSimpleName()
        );
    }
    public static List<UserDTO> from(List<User> users) {
        return users.stream().map(UserDTO::from).collect(Collectors.toList());
    }

    //getters e setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
