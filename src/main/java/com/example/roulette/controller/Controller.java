package com.example.roulette.controller;

import com.example.roulette.controller.dto.RouletteDTO;
import com.example.roulette.domain.service.RouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

}
