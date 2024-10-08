package com.lengper.cap2024.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "orders")

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @Column(name = "user_id", insertable = false, updatable = false )
    private Integer userId;

    @Column(name = "order_date") //this was put as title instead of data lol
    private Date orderDate;

    @Column(name = "status") //THIS IS FOR THE CART NEWLY ADDED!!!!
    private String status;

    @ManyToOne(fetch = FetchType.LAZY) // Correct
    @JoinColumn(name = "user_id") private User user;

    @ToString.Exclude
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL) private List<OrderDetail> orderDetails;




}
