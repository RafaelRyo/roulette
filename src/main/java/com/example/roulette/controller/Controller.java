package com.example.roulette.controller;

import com.example.roulette.controller.dto.RouletteDTO;
import com.example.roulette.domain.service.RouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
public class Controller {

    @Autowired
    private RouletteService rouletteService;

    @RequestMapping(path = "/v1/Rulette", method = RequestMethod.GET)
    public ResponseEntity<List<RouletteDTO>> getRoulette() {
        return ResponseEntity.ok(rouletteService.getRoulettes());
    }

    @RequestMapping(path = "/v1/Rulette", method = RequestMethod.POST)
    public ResponseEntity<String> createRoulette() {
        return ResponseEntity.ok(rouletteService.createRoulette());
    }

    @RequestMapping(path = "/v1/Rulette/{idRoulette}/activate", method = RequestMethod.PUT)
    public ResponseEntity<String> openRoulette(@PathVariable(name = "idRoulette") String id) {
        return ResponseEntity.ok(rouletteService.openRoulette(id));
    }
}
