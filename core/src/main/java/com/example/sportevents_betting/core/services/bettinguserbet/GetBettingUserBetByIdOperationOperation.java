package com.example.sportevents_betting.core.services.bettinguserbet;

import com.example.sportevents_betting.api.inputoutput.bettinguserbet.getbyid.GetBettingUserBetByIdInput;
import com.example.sportevents_betting.api.inputoutput.bettinguserbet.getbyid.GetBettingUserBetByIdOperation;
import com.example.sportevents_betting.api.inputoutput.bettinguserbet.getbyid.GetBettingUserBetByIdOutput;
import com.example.sportevents_betting.api.inputoutput.log.add.AddLogInput;
import com.example.sportevents_betting.api.inputoutput.log.add.AddLogOperation;
import com.example.sportevents_betting.core.exceptions.bettinguserbet.BettingUserBetNotFoundException;
import com.example.sportevents_betting.persistence.entities.BettingUserBet;
import com.example.sportevents_betting.persistence.repositories.BettingUserBetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetBettingUserBetByIdOperationOperation implements GetBettingUserBetByIdOperation {

    private final BettingUserBetRepository bettingUserBetRepository;
    private final AddLogOperation addLogOperation;
    @Override
    public GetBettingUserBetByIdOutput process(GetBettingUserBetByIdInput input) {

        BettingUserBet bet = bettingUserBetRepository.findById(UUID.fromString(input.getId()))
                .orElseThrow(() -> new BettingUserBetNotFoundException("Bet with id [" + input.getId() + "] was not found"));

        addLogOperation.process(AddLogInput.builder()
                .logMessage("Request to get bet with id [" + bet.getId() + "] was made")
                .build());

        return GetBettingUserBetByIdOutput.builder()
                .bookmakerOfferId(bet.getBookmakerOfferId())
                .betAmount(bet.getBetAmount().toString())
                .pickedTeam(String.valueOf(bet.getPickedTeam()))
                .bettingUserId(bet.getBettingUser().getId().toString())
                .build();
    }
}
