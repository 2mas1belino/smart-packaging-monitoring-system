package pt.ipleiria.estg.dei.ei.dae.daeproject.dtos;

import pt.ipleiria.estg.dei.ei.dae.daeproject.entities.Product;
import pt.ipleiria.estg.dei.ei.dae.daeproject.entities.Sensor;
import pt.ipleiria.estg.dei.ei.dae.daeproject.entities.TypePacking;
import pt.ipleiria.estg.dei.ei.dae.daeproject.entities.Volume;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VolumeDTO implements Serializable {

    private long id;
    private String description;
    private String status;
    private Boolean additionalPackaging;
    private TypePacking packagingType;
    private LocalDateTime creationDate;
    private OrderDTO order;
    private List<ProductDTO> products =  new ArrayList<>();
    private List<SensorDTO> sensors = new ArrayList<>();

    public VolumeDTO() {
    }

    public VolumeDTO(long id, String description, String status, Boolean additionalPackaging, TypePacking packagingType,
                     LocalDateTime creationDate, OrderDTO order) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.additionalPackaging = additionalPackaging;
        this.packagingType = packagingType;
        this.creationDate = creationDate;
        this.order = order;
    }

    public static VolumeDTO from(Volume volume) {
        return new VolumeDTO(
                volume.getId(),
                volume.getDescription(),
                volume.getStatus(),
                volume.getAdditionalPackaging(),
                volume.getPackagingType() != null ? volume.getPackagingType() : null,
                volume.getCreationDate(),
                OrderDTO.from(volume.getOrder())
        );
    }


    public static List<VolumeDTO> from(List<Volume> volumes) {
        return volumes.stream()
                .map(VolumeDTO::from)
                .collect(Collectors.toList());
    }

    // Getters e Setters
    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getAdditionalPackaging() {
        return additionalPackaging;
    }

    public void setAdditionalPackaging(Boolean additionalPackaging) {
        this.additionalPackaging = additionalPackaging;
    }

    public TypePacking getPackagingType() {
        return packagingType;
    }

    public void setPackagingType(TypePacking packagingType) {
        this.packagingType = packagingType;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    public void addProduct(ProductDTO product) {
        if (product != null && !products.contains(product)) {
            this.products.add(product);
        }
    }

    public void removeProduct(ProductDTO product) {
        if (product != null && products.contains(product)){
            this.products.remove(product);
        }
    }

    public List<SensorDTO> getSensors() {
        return sensors;
    }

    public void setSensors(List<SensorDTO> sensor) {
        this.sensors.add((SensorDTO) sensor);
    }

    public void addSensor(SensorDTO sensor) {
        if (sensor != null && !sensors.contains(sensor)) {
            this.sensors.add(sensor);
        }
    }

    public void removeSensor(SensorDTO sensor) {
        if (sensor != null && sensors.contains(sensor)) {
            this.sensors.remove(sensor);
        }
    }
}
