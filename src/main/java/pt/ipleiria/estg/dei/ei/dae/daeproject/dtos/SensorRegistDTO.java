package pt.ipleiria.estg.dei.ei.dae.daeproject.dtos;

import pt.ipleiria.estg.dei.ei.dae.daeproject.entities.SensorRegist;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class SensorRegistDTO {
    private long id;
    private LocalDateTime date;
    private String value;
    private String stateSensor;
    private double batery;
    private SensorDTO sensor;

    // Default constructor
    public SensorRegistDTO() {
    }

    // Constructor with all attributes
    public SensorRegistDTO(long id, LocalDateTime date, String value, String stateSensor, double batery) {
        this.id = id;
        this.date = date;
        this.value = value;
        this.stateSensor = stateSensor;
        this.batery = batery;
    }

    // Static method to convert from entity to DTO
    public static SensorRegistDTO from(SensorRegist sensorRegist) {
        return new SensorRegistDTO(
                sensorRegist.getId(),
                sensorRegist.getDate(),
                sensorRegist.getValue(),
                sensorRegist.getStateSensor(),
                sensorRegist.getBatery()
        );
    }

    // converts an entire list of entities into a list of DTOs
    public static List<SensorRegistDTO> from(List<SensorRegist> sensorRegists) {
        return sensorRegists.stream().map(SensorRegistDTO::from).collect(Collectors.toList());
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

    public double getBatery() {
        return batery;
    }

    public void setBatery(double batery) {
        this.batery = batery;
    }

    public SensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }
}