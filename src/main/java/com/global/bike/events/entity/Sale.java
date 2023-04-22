package com.global.bike.events.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("sales")
@Data
public class Sale {

    private String id;
    private String model;
}
