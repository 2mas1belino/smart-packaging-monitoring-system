package pt.ipleiria.estg.dei.ei.dae.daeproject.dtos;

import pt.ipleiria.estg.dei.ei.dae.daeproject.entities.SensorLimit;

import java.util.List;
import java.util.stream.Collectors;

public class SensorLimitDTO {
    private long id;
    private double limitMax;
    private double limitMin;
    private String state;
    private SensorInfoDTO sensorInfo;

    // Default constructor
    public SensorLimitDTO() {
    }

    // Constructor with all attributes
    public SensorLimitDTO(long id, double limitMax, double limitMin, String state, SensorInfoDTO sensorInfo) {
        this.id = id;
        this.limitMax = limitMax;
        this.limitMin = limitMin;
        this.state = state;
        this.sensorInfo = sensorInfo;
    }

    public static SensorLimitDTO from(SensorLimit sensorsLimits) {
        return new SensorLimitDTO(
                sensorsLimits.getId(),
                sensorsLimits.getLimitMax(),
                sensorsLimits.getLimitMin(),
                sensorsLimits.getState(),
                SensorInfoDTO.from(sensorsLimits.getInfoSensor())
        );
    }

    // converts an entire list of entities into a list of DTOs
    public static List<SensorLimitDTO> from(List<SensorLimit> sensorsLimits) {
        return sensorsLimits.stream().map(SensorLimitDTO::from).collect(Collectors.toList());
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

    public SensorInfoDTO getSensorInfo() {
        return sensorInfo;
    }

    public void setSensorInfo(SensorInfoDTO sensorInfo) {
        this.sensorInfo = sensorInfo;
    }
}
