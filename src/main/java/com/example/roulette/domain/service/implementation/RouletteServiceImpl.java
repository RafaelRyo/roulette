package com.example.roulette.domain.service.implementation;

import com.example.roulette.controller.dto.RouletteDTO;
import com.example.roulette.domain.entity.Roulette;
import com.example.roulette.domain.repository.RouletteRepository;
import com.example.roulette.domain.service.RouletteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class RouletteServiceImpl implements RouletteService {
    @Autowired
    private RouletteRepository rouletteRepository;


    @Override
    public List<RouletteDTO> getRoulettes() {
        List<RouletteDTO> roulettes = new ArrayList<>();
        for (Roulette roulette : rouletteRepository.findAll()) {
            roulettes.add(RouletteDTO.builder().id(roulette.getId()).status(roulette.getStatus()).build());
        }
        return roulettes;
    }

    @Override
    public String createRoulette() {
        Roulette newRoulette = new Roulette();
        rouletteRepository.insert(newRoulette);
        return newRoulette.getId();
    }

    @Override
    public String openRoulette(String idRoulette) {

        Optional<Roulette> roulette = rouletteRepository.findById(idRoulette);
        if (roulette.isEmpty()) {
           return "Roulette does not exist!";
        }else{
            Roulette newRoulette = new Roulette(idRoulette, "ACTIVE");
            rouletteRepository.save(newRoulette);
            return newRoulette.getStatus();
        }

    }


}
