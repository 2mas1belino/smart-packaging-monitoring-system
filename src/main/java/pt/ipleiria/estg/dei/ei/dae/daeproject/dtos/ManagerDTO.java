package pt.ipleiria.estg.dei.ei.dae.daeproject.dtos;

import pt.ipleiria.estg.dei.ei.dae.daeproject.entities.Manager;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class ManagerDTO implements Serializable {

    private long id;
    private String username;
    private String password;
    private String email;

    public ManagerDTO() {
    }

    public ManagerDTO(long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public static ManagerDTO from(Manager manager) {
        return new ManagerDTO(
                manager.getId(),
                manager.getUsername(),
                manager.getPassword(),
                manager.getEmail()
        );
    }

    public static List<ManagerDTO> from(List<Manager> managers) {
        return managers.stream().map(ManagerDTO::from).collect(Collectors.toList());
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
