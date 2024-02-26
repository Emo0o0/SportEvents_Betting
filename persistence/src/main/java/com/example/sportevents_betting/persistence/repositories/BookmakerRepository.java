package com.example.sportevents_betting.persistence.repositories;

import com.example.sportevents_betting.persistence.entities.Bookmaker;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BookmakerRepository extends JpaRepository<Bookmaker, UUID> {

}
