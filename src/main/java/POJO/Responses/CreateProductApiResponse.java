package POJO.Responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateProductApiResponse {
    private int id;
    private String name;
    private String type;
    private String upc;
    private double price;
    private double shipping;
    private String description;
    private String manufacturer;
    private String model;
    private String url;
    private String image;
    private String updatedAt;
    private String createdAt;


    public double getShipping() {
        return shipping;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getUrl() {
        return url;
    }

    public String getImage() {
        return image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getUpc() {
        return upc;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getModel() {
        return model;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
