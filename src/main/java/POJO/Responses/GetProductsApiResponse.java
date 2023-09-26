package POJO.Responses;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class GetProductsApiResponse {
    private int total;
    private int limit;
    private int skip;
    private List<data> data;
    private int id;
    private String name;
    private String type;
    private double price;
    private String upc;
    private int shipping;
    private String description;
    private String manufacturer;
    private String model;
    private String url;
    private String image;
    private String createdAt;
    private String updatedAt;
    private List<category> categories;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getUpc() {
        return upc;
    }

    public int getShipping() {
        return shipping;
    }

    public String getDescription() {
        return description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getUrl() {
        return url;
    }

    public String getImage() {
        return image;
    }

    public List<category> getCategories() {
        return categories;
    }

    public int getTotal() {
        return total;
    }

    public int getLimit() {
        return limit;
    }

    public int getSkip() {
        return skip;
    }

    public List<data> getData() {
        return data;
    }

    public static class data {

        private int id;
        private String name;
        private String type;
        private double price;
        private String upc;
        private int shipping;
        private String description;
        private String manufacturer;
        private String model;
        private String url;
        private String image;
        private String createdAt;
        private String updatedAt;
        private List<category> categories;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public double getPrice() {
            return price;
        }

        public String getUpc() {
            return upc;
        }

        public int getShipping() {
            return shipping;
        }

        public String getDescription() {
            return description;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public String getModel() {
            return model;
        }

        public String getUrl() {
            return url;
        }

        public String getImage() {
            return image;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public List<category> getCategories() {
            return categories;
        }

    }

    public static class category {
        private String id;
        private String name;
        private String createdAt;
        private String updatedAt;

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }
    }
}
