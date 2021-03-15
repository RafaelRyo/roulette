package com.example.roulette.domain.entity;

import org.springframework.data.annotation.Id;
import java.util.UUID;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "Roulette")
public class Roulette {

    @Id
    private String id;

    private String status;

    public Roulette() {
        this.id = UUID.randomUUID().toString();
        this.status = "INACTIVE";
    }

    public Roulette(String id, String status) {
        this.id = id;
        this.status = status;
    }
}

