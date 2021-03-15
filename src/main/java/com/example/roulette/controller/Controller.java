package com.example.roulette.controller;

import com.example.roulette.controller.dto.BetDTO;
import com.example.roulette.controller.dto.RouletteDTO;
import com.example.roulette.domain.service.RouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class Controller {

    @Autowired
    private RouletteService rouletteService;

    @RequestMapping(path = "/v1/Roulette", method = RequestMethod.GET)
    public ResponseEntity<List<RouletteDTO>> getRoulette() {
        return ResponseEntity.ok(rouletteService.getRoulettes());
    }

    @RequestMapping(path = "/v1/Roulette", method = RequestMethod.POST)
    public ResponseEntity<String> createRoulette() {
        return ResponseEntity.ok(rouletteService.createRoulette());
    }

    @RequestMapping(path = "/v1/Roulette/{idRoulette}/activate", method = RequestMethod.PUT)
    public ResponseEntity<String> openRoulette(@PathVariable(name = "idRoulette") String id) {
        return ResponseEntity.ok(rouletteService.openRoulette(id));
    }

    @RequestMapping(path = "/v1/Roulette/{idRoulette}/close", method = RequestMethod.PUT)
    public ResponseEntity closeRoulette(@PathVariable(name = "idRoulette") String id) {
        try {
            return ResponseEntity.ok(rouletteService.closeRoulette(id));
        } catch (Exception e) {
            return ResponseEntity.status(503).body(e.getMessage());
        }
    }

    @RequestMapping(path = "/v1/Bet", method = RequestMethod.POST)
    public ResponseEntity<String> createBet(@RequestBody BetDTO betDTO) {
        return ResponseEntity.ok(rouletteService.createBet(betDTO));
    }
}
