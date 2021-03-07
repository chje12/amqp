package com.example.amqp.dto;

import lombok.Data;

public  @Data class Order {

    private String orderId;
    private String menu;
    private int quantity;
    private int price;


}
