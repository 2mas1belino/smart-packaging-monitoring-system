package pt.ipleiria.estg.dei.ei.dae.daeproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client extends User {

    public Client() {
    }

    public Client(String email, String password, String username) {
        super(email, password, username);
    }
}
