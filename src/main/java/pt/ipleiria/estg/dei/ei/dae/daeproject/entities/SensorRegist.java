package pt.ipleiria.estg.dei.ei.dae.daeproject.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity

@NamedQueries({
        @NamedQuery(
                name = "getAllsensorRegists",
                query = "SELECT s FROM SensorRegist s ORDER BY s.id" // JPQL
        )
})

@Table(name = "sensorRegists")

public class SensorRegist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private LocalDateTime date;

    @NotNull
    private String value;

    @NotNull
    private String stateSensor;

    @NotNull
    private double batery;

    @ManyToOne
    @NotNull
    private Sensor sensor;

    // Default constructor
    public SensorRegist() {
    }

    // Constructor with all attributes
    public SensorRegist(LocalDateTime date, String value, String stateSensor, Double batery, Sensor sensor) {
        this.date = date;
        this.value = value;
        this.stateSensor = stateSensor;
        this.batery = batery;
        this.sensor = sensor;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getStateSensor() {
        return stateSensor;
    }

    public void setStateSensor(String stateSensor) {
        this.stateSensor = stateSensor;
    }

    public Double getBatery() {
        return batery;
    }

    public void setBatery(Double batery) {
        this.batery = batery;
    }

    public Sensor getSensor() {
        return sensor;
    }
}

