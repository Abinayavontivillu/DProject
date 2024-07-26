package com.example.product.demoprojectproduct.Service;

import com.example.product.demoprojectproduct.Model.Order;
import com.example.product.demoprojectproduct.Model.ShippingDetails;
import com.example.product.demoprojectproduct.Model.User;
import com.example.product.demoprojectproduct.Repository.OrderRepository;
import com.example.product.demoprojectproduct.Repository.ShippingDetailsRepository;
import com.example.product.demoprojectproduct.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ShippingDetailsRepository shippingDetailsRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(String orderId) {
        return orderRepository.findById(orderId);
    }

    public Order createOrder(Order order) {
        Order savedOrder = orderRepository.save(order);
        ShippingDetails shippingDetails = new ShippingDetails();
       //shippingDetails.setOrder(savedOrder.getOrderId());
        shippingDetails.setStatus("Pending");
        // Set other shipping details as necessary

        shippingDetailsRepository.save(shippingDetails);
        return savedOrder;
    }

    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(String orderId) {
        orderRepository.deleteById(orderId);
    }
}
