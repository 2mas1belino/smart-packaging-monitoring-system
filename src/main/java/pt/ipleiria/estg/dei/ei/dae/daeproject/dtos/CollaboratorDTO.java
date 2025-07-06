package pt.ipleiria.estg.dei.ei.dae.daeproject.dtos;

import pt.ipleiria.estg.dei.ei.dae.daeproject.entities.Collaborator;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class CollaboratorDTO implements Serializable {

    private long id;
    private String username;
    private String password;
    private String email;

    public CollaboratorDTO() {
    }

    public CollaboratorDTO(long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public static CollaboratorDTO from(Collaborator collaborator) {
        return new CollaboratorDTO(
                collaborator.getId(),
                collaborator.getUsername(),
                collaborator.getPassword(),
                collaborator.getEmail()
        );
    }

    public static List<CollaboratorDTO> from(List<Collaborator> collaborators) {
        return collaborators.stream().map(CollaboratorDTO::from).collect(Collectors.toList());
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

