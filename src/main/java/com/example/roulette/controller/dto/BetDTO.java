package com.example.roulette.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BetDTO {
    private Integer number;
    private String color;
    private Integer dollars;
    private String idRoulette;
}
