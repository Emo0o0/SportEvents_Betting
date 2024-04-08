package com.example.sportevents_betting.api.inputoutput.bettinguserbet.calculatebets;

import com.example.sportevents_betting.api.base.OperationResult;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalculateBetsOutput implements OperationResult {

    private String userId;
    private String bookmakerOfferId;
    private BigDecimal betAmount;
    private int pickedTeam;
    private int teamWon;
    private String odds;

}
