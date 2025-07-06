package pt.ipleiria.estg.dei.ei.dae.daeproject.dtos;

import pt.ipleiria.estg.dei.ei.dae.daeproject.entities.SensorInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SensorInfoDTO {
    private long id;
    private String description;
    private String unit;
    private List<SensorLimitDTO> sensorLimits = new ArrayList<>();

    // Default constructor
    public SensorInfoDTO() {
    }

    // Constructor with all attributes
    public SensorInfoDTO(long id, String description, String unit) {
        this.id = id;
        this.description = description;
        this.unit = unit;
    }

    public static SensorInfoDTO from(SensorInfo sensor) {
        return new SensorInfoDTO(
                sensor.getId(),
                sensor.getDescription(),
                sensor.getUnit()
        );
    }

    // converts an entire list of entities into a list of DTOs
    public static List<SensorInfoDTO> from(List<SensorInfo> sensors) {
        return sensors.stream().map(SensorInfoDTO::from).collect(Collectors.toList());
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<SensorLimitDTO> getLimits() {
        return sensorLimits;
    }

    public void setLimits(List<SensorLimitDTO> sensorLimits) {
        this.sensorLimits = sensorLimits;
    }

    public void addLimit(SensorLimitDTO limit) {
       if (sensorLimits != null && !sensorLimits.contains(limit)) {
           sensorLimits.add(limit);
       }
    }

    public void removeLimit(SensorLimitDTO limit) {
        if (sensorLimits != null && sensorLimits.contains(limit)) {
            sensorLimits.remove(limit);
        }
    }
}