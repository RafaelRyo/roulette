package com.example.roulette.domain.service.implementation;

import com.example.roulette.controller.dto.BetDTO;
import com.example.roulette.controller.dto.CloseRouletteDTO;
import com.example.roulette.controller.dto.RouletteDTO;
import com.example.roulette.domain.entity.Bet;
import com.example.roulette.domain.entity.Roulette;
import com.example.roulette.domain.repository.BetRepository;
import com.example.roulette.domain.repository.RouletteRepository;
import com.example.roulette.domain.service.RouletteService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RouletteServiceImpl implements RouletteService {

    private static final Logger logger = LoggerFactory.getLogger(RouletteServiceImpl.class);

    @Autowired
    private RouletteRepository rouletteRepository;

    @Autowired
    private BetRepository betRepository;


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
            logger.error("Roulette does not exist!");
           return "Roulette does not exist!";
        }else{
            Roulette newRoulette = new Roulette(idRoulette, "ACTIVE");
            rouletteRepository.save(newRoulette);
            return newRoulette.getStatus();
        }

    }

    @Override
    public CloseRouletteDTO closeRoulette(String id) throws Exception {
        try {
            validateRoulette(id);
            Integer winnerNumber = getRandomNumber();
            List<Bet> bets = betRepository.findAll().stream()
                    .filter(b-> b.getIdRoulette().equals(id)).collect(Collectors.toList());
            CloseRouletteDTO result = CloseRouletteDTO.builder()
                    .id(id)
                    .bets(bets)
                    .winerNumber(winnerNumber)
                    .build();
            Roulette newRoulette = new Roulette(id, "CLOSE");
            rouletteRepository.save(newRoulette);
            logger.info("Bet close satisfactorily");
            return result;

        } catch (Exception e) {
            String message ="Error to close the bet: " + e.getMessage();
            logger.error(message);
            throw new Exception(message);
        }
    }

    @Override
    public String createBet(BetDTO betDTO) {
        String result = "";
        try {
            validateRoulette(betDTO.getIdRoulette());
            Bet bet = new Bet(betDTO.getNumber(), betDTO.getDollars(), betDTO.getIdRoulette());
            betRepository.insert(bet);
            result = "Bet created satisfactorily!";
        } catch (Exception e) {
            result = "Error to create the bet: " + e.getMessage();
        }
        return result;
    }

    private void validateRoulette(String idRoulette) throws Exception {
        Optional<Roulette> roulette = rouletteRepository.findById(idRoulette);
        if (roulette.isEmpty()) {
            throw new Exception("Roulette does not exist!");
        }
        if (roulette.get().getStatus().equals("INACTIVE")) {
            throw new Exception("Roulette is Inactive!");
        }
    }

    private Integer getRandomNumber() {
        return (int) Math.round(Math.random() * (36 + 1));
    }


}
