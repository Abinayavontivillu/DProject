package com.example.product.demoprojectproduct.Model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Data
@Document(collection = "users")
public class User {

    @Id
    private String userId = UUID.randomUUID().toString();

    @Email(message = "Email should be valid")
    @NotBlank
    private String emailId;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
            message = "Password must be strong")
    @NotBlank
    private String pwd;

    @Size(min = 1, message = "At least one contact should be provided")
    @JsonProperty("contact")
    private List<Contact> contact;

    @NotBlank
    private String sex;

    @Min(0)
    @Max(150)
    private int age;

    @Past
    private Date dob;

    @Pattern(regexp = "^[a-zA-Z0-9_-]+$", message = "Username can only contain letters, numbers, underscores, and hyphens")
    @NotBlank
    private String userName;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name can only contain letters")
    @NotBlank
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name can only contain letters")
    @NotBlank
    private String lastName;

    @CreatedDate
    private LocalDateTime createdTime;

    @LastModifiedDate
    private LocalDateTime lastLogin;

    @Size(min = 1, message = "At least one address should be provided")
    @JsonProperty("address")
    private List<Address> address;


    public static class Contact {
        @JsonProperty("type")
        private String type;
        @JsonProperty("number")
        private String number;

    }

    public static class Address {
        @JsonProperty("address1")
        private String address1;
        @JsonProperty("address2")
        private String address2;
        @JsonProperty("state")
        private String state;
        @JsonProperty("city")
        private String city;
        @JsonProperty("pin")
        private String pin;
        @JsonProperty("contactno")
        private String contactNo;
        @JsonProperty("alternateno")
        private String alternateNo;


    }
}
