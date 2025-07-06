package pt.ipleiria.estg.dei.ei.dae.daeproject.dtos;

import pt.ipleiria.estg.dei.ei.dae.daeproject.entities.TypePacking;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TypePackingDTO implements Serializable {

    private long id;
    private String type;
    private List<String> sensors = new ArrayList<>();

    public TypePackingDTO() {
    }

    public TypePackingDTO(long id, String type) {
        this.id = id;
        this.type = type;
    }

    public static TypePackingDTO from(TypePacking typePacking) {
        return new TypePackingDTO(
                typePacking.getId(),
                typePacking.getType()
        );
    }

    public static List<TypePackingDTO> from(List<TypePacking> typePacking) {
        return typePacking.stream()
                .map(TypePackingDTO::from)
                .collect(Collectors.toList());
    }

    // Getters e Setters
    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getSensors() {
        return sensors;
    }

    public void setSensors(List<String> sensors) {
        this.sensors = sensors;
    }

    public void addSensor(String sensor) {
        if (sensor != null && !sensor.isEmpty()) {
            this.sensors.add(sensor);
        }
    }

    public void removeSensor(String sensor) {
        this.sensors.remove(sensor);
    }
}

