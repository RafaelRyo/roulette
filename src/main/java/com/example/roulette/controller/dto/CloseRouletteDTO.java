package com.example.roulette.controller.dto;

import com.example.roulette.domain.entity.Bet;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CloseRouletteDTO {
    private String id;
    private List<Bet> bets;
    private Integer winerNumber;
}
