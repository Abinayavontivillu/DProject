package com.example.product.demoprojectproduct.Model;




import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;


@Data
@AllArgsConstructor
@Document(collection="products")
public class Product
{
    private static final Logger logger = LogManager.getLogger(Product.class);
    @Id
    private String id= UUID.randomUUID().toString();
    @NotBlank(message = "Description is mandatory")
    private String description;
    @NotBlank(message="Category is mandatory")
    private String category;
    @NotBlank(message = "Brand is mandatory")
    private String brand;
    @Min(value = 0,message = "Price should be postivie")
    private double price;
    @Min(value=0,message="Offer should be positive")
    @Max(value=100,message="Offer cannot exceed 100%")
    private double offer;
    @NotBlank(message="Manfacturer is mandatory")
    private String manufacturer;
    @NotEmpty(message = "Color cannot be empty")
    @JsonProperty("colors")
    private List<Color> colors;
    @Min(value=0,message="In-stock should be positive")
    private int inStock;
    private boolean ifAvailable;
    @Min(value=0,message = "MRP should be positive")
    private double mrp;
    @Min(value=0,message="MArgin should be postive")
    @Max(value=100,message="Margin cannot exceed 100%")
    private double margin;
    @NotEmpty(message = "Images cannot be empty")
    @JsonProperty("images")
    private List<Image> images;

    public void setId(String id) {
    }


    public static class Color
    {
        @JsonProperty("colorcode")
        @NotBlank(message="color code is mandatory")
        private String colorCode;

        @JsonProperty("colorname")
        @NotBlank(message="Color name is mandatory")
        private String colorName;
    }
    public static class Image
    {
        @NotBlank(message="ImageId is mandatory")
        @JsonProperty("imagesid")
        private String imageId;
        @JsonProperty("resolution")
        @NotBlank(message="Resolution is mandatory")
        private String resolution;
        @JsonProperty("type")
        @NotBlank(message="type is mandatory")
        private String type;
        @JsonProperty("weblocation")
        @NotBlank(message="Web location is mandatory")
        private String weblocation;
    }

}
