package com.example.sportevents_betting.core.services.bettinguser;

import com.example.sportevents_betting.api.inputoutput.bettinguser.mapbets.MapBettingUserBetsInput;
import com.example.sportevents_betting.api.inputoutput.bettinguser.mapbets.MapBettingUserBetsListOutput;
import com.example.sportevents_betting.api.inputoutput.bettinguser.mapbets.MapBettingUserBetsOperation;
import com.example.sportevents_betting.api.inputoutput.bettinguser.mapbets.MapBettingUserBetsOutput;
import com.example.sportevents_betting.persistence.entities.BettingUserBet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MapBettingUserBetsOperationProcessor implements MapBettingUserBetsOperation {
    @Override
    public MapBettingUserBetsListOutput process(MapBettingUserBetsInput input) {

        Set<MapBettingUserBetsOutput> outputSet = new HashSet<>();

        for (BettingUserBet bub : input.getBets()) {

            outputSet.add(MapBettingUserBetsOutput.builder()
                    .betId(bub.getId().toString())
                    .bookmakerOfferId(bub.getBookmakerOfferId())
                    .betAmount(bub.getBetAmount().toString())
                    .pickedTeam(Integer.toString(bub.getPickedTeam()))
                    .build());
        }

        return MapBettingUserBetsListOutput.builder()
                .mappedBets(outputSet)
                .build();


    }
}
