package com.example.sportevents_betting.persistence.repositories;

import com.example.sportevents_betting.persistence.entities.InternalLogger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InternalLoggerRepository extends JpaRepository<InternalLogger, UUID> {
}
