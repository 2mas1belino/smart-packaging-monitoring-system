package pt.ipleiria.estg.dei.ei.dae.daeproject.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity

@NamedQueries({
        @NamedQuery(
                name = "getAllsensorInfos",
                query = "SELECT s FROM SensorInfo s ORDER BY s.id" // JPQL
        )
})

@Table(name = "sensorInfos")

public class SensorInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String description;

    @NotNull
    private String unit;

    @OneToMany(mappedBy = "sensorLimit")
    private List<SensorLimit> sensorLimits = new ArrayList<>();

    // Default constructor
    public SensorInfo() {
    }

    // Constructor with all attributes
    public SensorInfo(String unit, String description) {
        this.unit = unit;
        this.description = description;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SensorLimit> getSensorLimits() {
        return sensorLimits;
    }

    public void addSensorLimit(SensorLimit sensorLimit) {
        if (!sensorLimits.contains(sensorLimit)) {
            sensorLimits.add(sensorLimit);
        }
    }

    public void removeSensorLimit(SensorLimit sensorLimit) {
        if (sensorLimits.contains(sensorLimit)) {
            sensorLimits.remove(sensorLimit);
        }
    }
}

