package com.example.roulette.domain.entity;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "Bet")
public class Bet {
    private Integer number;
    private String color;
    private Integer dollars;
    private String idRoulette;

    public Bet(Integer number, Integer dollars, String idRoulette) {

        if (number < 0 || number > 36) {
            throw new IllegalArgumentException("number is not valid!");
        }
        this.number = number;
        this.color = getColor(number);
        this.dollars = dollars;
        this.idRoulette = idRoulette;
    }

    private String getColor(Integer number){
        if (number%2==0)
            return "RED";
        else
            return "BLACK";
    }
}
