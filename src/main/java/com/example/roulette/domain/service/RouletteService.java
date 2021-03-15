package com.example.roulette.domain.service;

import com.example.roulette.controller.dto.BetDTO;
import com.example.roulette.controller.dto.CloseRouletteDTO;
import com.example.roulette.controller.dto.RouletteDTO;

import java.util.List;

public interface RouletteService {

    List<RouletteDTO> getRoulettes();

    String createRoulette();

    String openRoulette(String id);

    CloseRouletteDTO closeRoulette(String id) throws Exception;

    String createBet(BetDTO betDTO);

}

