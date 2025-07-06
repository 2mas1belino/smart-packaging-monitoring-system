package pt.ipleiria.estg.dei.ei.dae.daeproject.dtos;

import pt.ipleiria.estg.dei.ei.dae.daeproject.entities.Client;
import pt.ipleiria.estg.dei.ei.dae.daeproject.entities.Order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;

public class ClientDTO implements Serializable {

    private long id;
    private String username;
    private String password;
    private String email;
    private List<Order> orders = new ArrayList<>();

    public ClientDTO() {
    }

    public ClientDTO(long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public static ClientDTO from(Client client) {
        return new ClientDTO(
                client.getId(),
                client.getUsername(),
                client.getPassword(),
                client.getEmail()
        );
    }

    public static List<ClientDTO> from(List<Client> clients) {
        return clients.stream().map(ClientDTO::from).collect(Collectors.toList());
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        if (order != null && !this.orders.contains(order)) {
            this.orders.add(order);
        }
    }

    public void removeOrder(Order order) {
        if (order != null && this.orders.contains(order)) {
            this.orders.remove(order);
        }
    }
}

