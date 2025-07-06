package pt.ipleiria.estg.dei.ei.dae.daeproject.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private Boolean additionalPackaging;

    @NotBlank
    private String name;

    @ManyToOne
    @JoinColumn(name = "packaging_Type_id", referencedColumnName = "id")
    private TypePacking typePacking;

    @ManyToMany
    @JoinTable(
            name = "product_sensor",
            joinColumns = @JoinColumn(
                    name = "product_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "sensor_id",
                    referencedColumnName = "id"
            )
    )
    private List<SensorInfo> sensors = new ArrayList<>();

    public Product() {
    }

    public Product(Boolean additionalPackaging, String name, TypePacking typePacking) {
        this.additionalPackaging = additionalPackaging;
        this.name = name;
        this.typePacking = typePacking;
    }

    public long getId() {
        return id;
    }

    public Boolean getAdditionalPackaging() {
        return additionalPackaging;
    }

    public void setAdditionalPackaging(Boolean additionalPackaging) {
        this.additionalPackaging = additionalPackaging;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypePacking getTypePacking() {
        return typePacking;
    }

    public void setTypePacking(TypePacking typePacking) {
        this.typePacking = typePacking;
    }

    public List<SensorInfo> getSensors() {
        return sensors;
    }

    public void setSensors(List<SensorInfo> sensors) {
        this.sensors = sensors;
    }

    public void addSensor(SensorInfo sensor) {
        if (this.sensors.contains(sensor)) {
            throw new RuntimeException("The sensor " + sensor.getDescription() + " is already in the list");
        }
        sensors.add(sensor);
    }

    public void removeSensor(SensorInfo sensor) {
        sensors.remove(sensor);
    }
}
