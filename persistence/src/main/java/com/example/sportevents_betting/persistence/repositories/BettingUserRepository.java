package com.example.sportevents_betting.persistence.repositories;

import com.example.sportevents_betting.persistence.entities.BettingUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BettingUserRepository extends JpaRepository<BettingUser, UUID> {
}
