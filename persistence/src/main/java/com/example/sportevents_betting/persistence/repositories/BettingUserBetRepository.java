package com.example.sportevents_betting.persistence.repositories;

import com.example.sportevents_betting.persistence.entities.BettingUserBet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface BettingUserBetRepository extends JpaRepository<BettingUserBet, UUID> {

    Set<BettingUserBet> findAllByBookmakerOfferId(String id);


}
