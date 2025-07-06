package pt.ipleiria.estg.dei.ei.dae.daeproject.dtos;

import pt.ipleiria.estg.dei.ei.dae.daeproject.entities.Sensor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SensorDTO {
    private long id;
    private SensorInfoDTO sensorInfo;
    private long volume_id;
    private List<SensorRegistDTO> sensorRegists = new ArrayList<>();

    // Default constructor
    public SensorDTO() {
    }

    // Constructor with all attributes
    public SensorDTO(long id, SensorInfoDTO sensorInfo, long volume_id) {
        this.id = id;
        this.sensorInfo = sensorInfo;
        this.volume_id = volume_id;
    }

    // Static method to convert from entity to DTO
    public static SensorDTO from(Sensor sensor) {
        return new SensorDTO(
                sensor.getId(),
                SensorInfoDTO.from(sensor.getSensorInfo()),
                sensor.getVolume().getId()
        );
    }

    // converts an entire list of entities into a list of DTOs
    public static List<SensorDTO> from(List<Sensor> sensors) {
        return sensors.stream().map(SensorDTO::from).collect(Collectors.toList());
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public SensorInfoDTO getSensorInfo() {
        return sensorInfo;
    }

    public void setSensorInfo(SensorInfoDTO sensorInfo) {
        this.sensorInfo = sensorInfo;
    }

    public long getVolume() {
        return volume_id;
    }

    public void setVolumeId(long volume) {
        this.volume_id = volume;
    }

    public List<SensorRegistDTO> getSensorRegists() {
        return sensorRegists;
    }

    public void setSensorRegists(List<SensorRegistDTO> sensorRegists) {
        this.sensorRegists = sensorRegists;
    }

    public void addSensorRegist(SensorRegistDTO sensorRegist) {
        if (sensorRegist != null && !sensorRegists.contains(sensorRegist)) {
            sensorRegists.add(sensorRegist);
        }
    }

    public void removeSensorRegist(SensorRegistDTO sensorRegist) {
        if (sensorRegist != null && sensorRegists.contains(sensorRegist)) {
            sensorRegists.remove(sensorRegist);
        }
    }

}