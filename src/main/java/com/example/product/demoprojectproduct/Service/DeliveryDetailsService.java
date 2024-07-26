package com.example.product.demoprojectproduct.Service;


import com.example.product.demoprojectproduct.Model.DeliveryDetails;
import com.example.product.demoprojectproduct.Repository.DeliveryDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryDetailsService {
    @Autowired
    private DeliveryDetailsRepository detailsRepository;

    public DeliveryDetails saveDeliveryDeatils(DeliveryDetails deliveryDetails)
    {
        return detailsRepository.save(deliveryDetails);
    }

    public List<DeliveryDetails> getAllDeliveryDetails()
    {
        return detailsRepository.findAll();
    }
    public Optional<DeliveryDetails>getDeliveryDetailsById(String id)
    {
        return detailsRepository.findById(id);
    }
    public void deleteDeliveryDetailsById(String id)
    {
        detailsRepository.deleteById(id);
    }
}
