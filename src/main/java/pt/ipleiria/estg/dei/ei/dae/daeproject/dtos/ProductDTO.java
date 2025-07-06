package pt.ipleiria.estg.dei.ei.dae.daeproject.dtos;

import pt.ipleiria.estg.dei.ei.dae.daeproject.entities.Product;
import pt.ipleiria.estg.dei.ei.dae.daeproject.entities.SensorInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDTO implements Serializable {

    private long id;
    private String name;
    private Boolean additionalPackaging;
    private List<SensorInfo> sensorsInfo = new ArrayList<>();

    public ProductDTO() {
    }

    public ProductDTO(long id, String name, Boolean additionalPackaging) {
        this.id = id;
        this.name = name;
        this.additionalPackaging = additionalPackaging;
    }

    public static ProductDTO from(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getAdditionalPackaging()
        );
    }

    public static List<ProductDTO> from(List<Product> products) {
        return products.stream()
                .map(ProductDTO::from)
                .collect(Collectors.toList());
    }

    // Getters e Setters
    public long getId() {
        return id;
    }

    public Boolean getAdditionalPackaging() {
        return additionalPackaging;
    }

    public void setAdditionalPackaging(Boolean additionalPackaging) {
        this.additionalPackaging = additionalPackaging;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SensorInfo> getSensorsInfo() {
        return sensorsInfo;
    }

    public void setSensors(List<SensorInfo> sensorsInfo) {
        this.sensorsInfo = sensorsInfo;
    }

    public void addSensor(SensorInfo sensorInfo) {
        if(sensorInfo != null && !sensorsInfo.contains(sensorInfo)) {
            sensorsInfo.add(sensorInfo);
        }
    }

    public void removeSensor(SensorInfo sensorInfo) {
        if (sensorInfo != null && sensorsInfo.contains(sensorInfo)) {
            sensorsInfo.remove(sensorInfo);
        }
    }


}

