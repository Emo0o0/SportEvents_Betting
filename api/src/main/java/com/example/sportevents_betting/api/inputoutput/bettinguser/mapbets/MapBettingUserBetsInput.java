package com.example.sportevents_betting.api.inputoutput.bettinguser.mapbets;

import com.example.sportevents_betting.api.base.OperationInput;
import com.example.sportevents_betting.persistence.entities.BettingUserBet;
import lombok.*;

import java.util.Set;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MapBettingUserBetsInput implements OperationInput {

    private Set<BettingUserBet> bets;

}
