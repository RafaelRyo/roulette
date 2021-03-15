package com.example.roulette.domain.repository;

import com.example.roulette.domain.entity.Bet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BetRepository extends MongoRepository<Bet, String> {}
