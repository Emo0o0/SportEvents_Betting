package com.example.sportevents_betting.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookmakerOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String eventId;
    private String odds;
    @ManyToOne
    @JoinColumn(columnDefinition = "bookmaker_id", nullable = false)
    private Bookmaker bookmaker;


}
