package com.example.roulette.domain.repository;

import com.example.roulette.domain.entity.Roulette;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RouletteRepository extends MongoRepository<Roulette, String> {}
