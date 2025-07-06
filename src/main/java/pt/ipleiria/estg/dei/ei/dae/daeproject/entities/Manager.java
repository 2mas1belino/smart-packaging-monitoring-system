package pt.ipleiria.estg.dei.ei.dae.daeproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "managers")
public class Manager extends User {

    public Manager() {
    }

    public Manager(String email, String password, String username) {
        super(email, password, username);
    }
}
