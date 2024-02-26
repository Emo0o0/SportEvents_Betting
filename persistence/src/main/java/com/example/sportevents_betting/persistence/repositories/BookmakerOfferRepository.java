package com.example.sportevents_betting.persistence.repositories;

import com.example.sportevents_betting.persistence.entities.BookmakerOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookmakerOfferRepository extends JpaRepository<BookmakerOffer, UUID> {
}
