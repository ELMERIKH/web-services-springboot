package com.example.orderservice.web;


import com.example.orderservice.entities.Order;
import com.example.orderservice.model.Customer;
import com.example.orderservice.model.Product;
import com.example.orderservice.repositories.OrderRepository;
import com.example.orderservice.repositories.ProductItemRepository;
import com.example.orderservice.services.CustomerRestClientService;
import com.example.orderservice.services.InventoryRestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerRestClientService customerRestClientService;
    @Autowired
    private InventoryRestClientService inventoryRestClientService;

    public OrderRestController(OrderRepository orderRepository, ProductItemRepository productItemRepository, CustomerRestClientService customerRestClientService, InventoryRestClientService inventoryRestClientService) {
        this.orderRepository = orderRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClientService = customerRestClientService;
        this.inventoryRestClientService = inventoryRestClientService;
    }

   @GetMapping("/fullOrder/{id}")
    public Order getOrder(@PathVariable Long id){
        Order order=orderRepository.findById(id).get();
        Customer customer=customerRestClientService.customerById(order.getCustomerId());
        order.setCustomer(customer);
        order.getProductItems().forEach(pi->{
            Product product=inventoryRestClientService.productById(pi.getProductId());
            pi.setProduct(product);
        });
        return order;
    }
}
