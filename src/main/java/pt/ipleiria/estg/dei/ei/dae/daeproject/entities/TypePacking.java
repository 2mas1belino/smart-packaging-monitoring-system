package pt.ipleiria.estg.dei.ei.dae.daeproject.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity

@NamedQueries({
        @NamedQuery(
                name = "getAlltypePacking",
                query = "SELECT s FROM TypePacking s ORDER BY s.id" // JPQL
        )
})

@Table(name = "typePacking")

public class TypePacking implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String type;

    @ManyToMany
    @JoinTable(
            name = "typePacking_sensor",
            joinColumns = @JoinColumn(
                    name = "typePacking_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "sensor_id",
                    referencedColumnName = "id"
            )
    )
    private List<SensorInfo> sensors = new ArrayList<>();

    // Default constructor
    public TypePacking() {
    }

    // Constructor with all attributes
    public TypePacking(String type) {
        this.type = type;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<SensorInfo> getSensor() {
        return sensors;
    }

    public void setSensor(List<SensorInfo> sensor) {
        this.sensors = sensor;
    }

    public void addSensor(SensorInfo sensor) {
        if (this.sensors.contains(sensor)) {
            throw new RuntimeException("The sensor " + sensor.getDescription() + " is already in the list");
        }
        this.sensors.add(sensor);
    }

    public void removeSensor(SensorInfo sensor) {
        this.sensors.remove(sensor);
    }
}

