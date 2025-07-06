package pt.ipleiria.estg.dei.ei.dae.daeproject.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "volumes")
public class Volume implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String description;

    @NotNull
    private String status;

    private Boolean additionalPackaging;

    @ManyToOne
    private TypePacking packagingType;

    private LocalDateTime creationDate;

    @OneToMany
    @JoinColumn(name = "volume_id", referencedColumnName = "id")
    private List<Sensor> sensors;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @ManyToMany
    @NotNull
    @JoinTable(
            name = "volume_product",
            joinColumns = @JoinColumn(
                    name = "volume_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "product_id",
                    referencedColumnName = "id"
            )
    )
    private List<Product> products = new ArrayList<>();


    public Volume() {
    }

    public Volume(String description, String status, Boolean additionalPackaging, TypePacking packagingType, LocalDateTime creationDate, List<Sensor> sensors, Order order) {
        this.description = description;
        this.status = status;
        this.additionalPackaging = additionalPackaging;
        this.packagingType = packagingType;
        this.creationDate = creationDate;
        this.sensors = sensors;
        this.order = order;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getAdditionalPackaging() {
        return additionalPackaging;
    }

    public void setAdditionalPackaging(Boolean additionalPackaging) {
        this.additionalPackaging = additionalPackaging;
    }

    public TypePacking getPackagingType() {
        return packagingType;
    }

    public void setPackagingType(TypePacking packagingType) {
        this.packagingType = packagingType;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public void addProduct(Product product) {
        if (this.products.contains(product)) {
            throw new RuntimeException("The product " + product.getName() + " is already in the volume");
        }
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    public void addSensor(Sensor sensor) {
        if (this.sensors.contains(sensor)) {
            throw new RuntimeException("The sensor " + sensor.getSensorInfo().getDescription() + " is already in the volume");
        }
        this.sensors.add(sensor);
    }

    public void removeSensor(Sensor sensor) {
        this.sensors.remove(sensor);
    }
}

