package pt.ipleiria.estg.dei.ei.dae.daeproject.ejbs;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Hibernate;
import pt.ipleiria.estg.dei.ei.dae.daeproject.security.Hasher;
import pt.ipleiria.estg.dei.ei.dae.daeproject.entities.User;

public class UserBean {
    @PersistenceContext
    private EntityManager em;

    @Inject
    private Hasher hasher;

    // Usado no security/AuthenticationFilter
    public User findOrFail(String username) {
        var user = em.getReference(User.class, username);
        Hibernate.initialize(user);
        return user;
    }

    // Falta implementar a sua utilização no AuthService
    public boolean canLogin(String username, String password) {

        var user = findOrFail(username);
        return user != null && user.getPassword().equals(hasher.hash(password));
    }


}
