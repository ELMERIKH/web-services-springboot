package com.example.orderservice.entities;

import com.example.orderservice.enums.OrderStatus;
import com.example.orderservice.model.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private OrderStatus status;
    private Long customerId;
    @Transient //parce que Customer nest pas un entite(on demande de ne pas le prendre en consideration)
    private Customer customer;
    @OneToMany(mappedBy = "order")
    private List<ProductItem> productItems;

    public double getTotal(){
        double somme=0;
        for(ProductItem pi:productItems){
            somme+=pi.getAmount();
        }
        return somme;
    }
}
