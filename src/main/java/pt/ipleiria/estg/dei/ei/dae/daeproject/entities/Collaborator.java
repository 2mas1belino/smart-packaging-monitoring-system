package pt.ipleiria.estg.dei.ei.dae.daeproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "collaborators")
public class Collaborator extends User {

    public Collaborator() {
    }

    public Collaborator(String email, String password, String username) {
        super(email, password, username);
    }

}
