package com.example.product.demoprojectproduct.Controller;


import com.example.product.demoprojectproduct.Model.DeliveryDetails;
import com.example.product.demoprojectproduct.Service.DeliveryDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/delivery")
public class DeliveryDetailsController {

    @Autowired
    private DeliveryDetailsService deliveryDetailsService;

    @PostMapping
    public ResponseEntity<DeliveryDetails> createDeliveryDetails(@RequestBody DeliveryDetails deliveryDetails) {
        DeliveryDetails savedDetails = deliveryDetailsService.saveDeliveryDeatils(deliveryDetails);
        return new ResponseEntity<>(savedDetails, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<DeliveryDetails>> getAllDeliveryDetails() {
        List<DeliveryDetails> detailsList = deliveryDetailsService.getAllDeliveryDetails();
        return new ResponseEntity<>(detailsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryDetails> getDeliveryDetailsById(@PathVariable String id) {
        Optional<DeliveryDetails> deliveryDetails = deliveryDetailsService.getDeliveryDetailsById(id);
        return deliveryDetails.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeliveryDetailsById(@PathVariable String id) {
        deliveryDetailsService.deleteDeliveryDetailsById(id);
        return ResponseEntity.noContent().build();
    }
}

