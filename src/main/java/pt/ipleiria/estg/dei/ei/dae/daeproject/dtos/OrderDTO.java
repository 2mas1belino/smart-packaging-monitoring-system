package pt.ipleiria.estg.dei.ei.dae.daeproject.dtos;

import pt.ipleiria.estg.dei.ei.dae.daeproject.entities.Order;
import pt.ipleiria.estg.dei.ei.dae.daeproject.entities.Volume;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDTO implements Serializable {

    private long id;
    private String status;
    private LocalDateTime timestamp;
    private String user;
    private List<VolumeDTO> volumes = new ArrayList<>();

    public OrderDTO() {
    }

    public OrderDTO(long id, String status, LocalDateTime timestamp, String user) {
        this.id = id;
        this.status = status;
        this.timestamp = timestamp;
        this.user = user;
    }

    public static OrderDTO from(Order order) {
        return new OrderDTO(
                order.getId(),
                order.getStatus(),
                order.getTimestamp(),
                order.getUser() != null ? order.getUser().getUsername() : null
        );
    }

    public static List<OrderDTO> from(List<Order> orders) {
        return orders.stream().map(OrderDTO::from).collect(Collectors.toList());
    }

    // Getters e Setters

    public long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<VolumeDTO> getVolumes() {
        return volumes;
    }

    public void setVolumes(List<VolumeDTO> volumes) {
        this.volumes = volumes;
    }

    public void addVolume(VolumeDTO volume) {
        if (volume != null && !this.volumes.contains(volume)) {
            this.volumes.add(volume);
        }
    }

    public void removeVolume(VolumeDTO volume) {
        if (volume != null && this.volumes.contains(volume)) {
            this.volumes.remove(volume);
        }
    }
}
