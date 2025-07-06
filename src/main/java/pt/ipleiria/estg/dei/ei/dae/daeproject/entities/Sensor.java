package pt.ipleiria.estg.dei.ei.dae.daeproject.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity

@NamedQueries({
        @NamedQuery(
                name = "getAllSensors",
                query = "SELECT s FROM Sensor s ORDER BY s.id" // JPQL
        )
})

@Table(name = "sensors")

public class Sensor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @NotNull
    private SensorInfo sensorInfo;

    @ManyToOne
    @NotNull
    private Volume volume;

    @OneToMany(mappedBy = "sensorRegist")
    private List<SensorRegist> sensorRegists = new ArrayList<>();

    // Default constructor
    public Sensor() {
    }

    // Constructor with all attributes
    public Sensor(SensorInfo sensorInfo, Volume volume) {
        this.sensorInfo = sensorInfo;
        this.volume = volume;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public SensorInfo getSensorInfo() {
        return sensorInfo;
    }

    public void setSensorInfo(SensorInfo sensorInfo) {
        this.sensorInfo = sensorInfo;
    }

    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    public List<SensorRegist> getSensorRegisters() {
        return sensorRegists;
    }

    public void setSensorRegisters(List<SensorRegist> sensorRegists) {
        this.sensorRegists = sensorRegists;
    }

    public void addSensorRegist(SensorRegist sensorRegist) {
        if (!sensorRegists.contains(sensorRegist)) {
            sensorRegists.add(sensorRegist);
        }
    }

    public void removeSensorRegist(SensorRegist sensorRegist) {
        if (sensorRegists.contains(sensorRegist)) {
            sensorRegists.remove(sensorRegist);
        }
    }
}

