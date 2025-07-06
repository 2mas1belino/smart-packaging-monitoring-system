package pt.ipleiria.estg.dei.ei.dae.daeproject.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Entity

@NamedQueries({
        @NamedQuery(
                name = "getAllsensorLimits",
                query = "SELECT s FROM SensorLimit s ORDER BY s.id" // JPQL
        )
})

@Table(name = "sensorLimits")

public class SensorLimit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private double limitMax;

    @NotNull
    private double limitMin;

    @NotNull
    private String state;

    @ManyToOne
    @NotNull
    private SensorInfo sensorInfo;


    // Default constructor
    public SensorLimit() {
    }

    // Constructor with all attributes
    public SensorLimit(double limitMax, double limitMin, String state, SensorInfo sensorInfo) {
        this.limitMax = limitMax;
        this.limitMin = limitMin;
        this.state = state;
        this.sensorInfo = sensorInfo;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public double getLimitMax() {
        return limitMax;
    }

    public void setLimitMax(double limitMax) {
        this.limitMax = limitMax;
    }

    public double getLimitMin() {
        return limitMin;
    }

    public void setLimitMin(double limitMin) {
        this.limitMin = limitMin;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public SensorInfo getInfoSensor() {
        return sensorInfo;
    }

    public void setInfoSensor(SensorInfo sensorInfo) {
        this.sensorInfo = sensorInfo;
    }


}

