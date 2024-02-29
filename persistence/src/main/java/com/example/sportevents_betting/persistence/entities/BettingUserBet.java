package com.example.sportevents_betting.persistence.entities;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BettingUserBet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String bookmakerOfferId;
    private BigDecimal betAmount;
    private int pickedTeam;

}
