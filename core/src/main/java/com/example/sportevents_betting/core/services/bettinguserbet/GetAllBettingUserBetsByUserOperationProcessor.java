package com.example.sportevents_betting.core.services.bettinguserbet;

import com.example.sportevents_betting.api.inputoutput.bettinguserbet.getbyuser.GetAllBettingUserBetsByUserInput;
import com.example.sportevents_betting.api.inputoutput.bettinguserbet.getbyuser.GetAllBettingUserBetsByUserListOutput;
import com.example.sportevents_betting.api.inputoutput.bettinguserbet.getbyuser.GetAllBettingUserBetsByUserOperation;
import com.example.sportevents_betting.api.inputoutput.bettinguserbet.getbyuser.GetAllBettingUserBetsByUserOutput;
import com.example.sportevents_betting.api.inputoutput.log.add.AddLogInput;
import com.example.sportevents_betting.api.inputoutput.log.add.AddLogOperation;
import com.example.sportevents_betting.core.exceptions.bettinguser.BettingUserNotFoundException;
import com.example.sportevents_betting.persistence.entities.BettingUser;
import com.example.sportevents_betting.persistence.repositories.BettingUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetAllBettingUserBetsByUserOperationProcessor implements GetAllBettingUserBetsByUserOperation {

    private final BettingUserRepository bettingUserRepository;
    private final AddLogOperation addLogOperation;

    @Override
    public GetAllBettingUserBetsByUserListOutput process(GetAllBettingUserBetsByUserInput input) {

        BettingUser bettingUser = bettingUserRepository.findById(UUID.fromString(input.getBettingUserId()))
                .orElseThrow(() -> new BettingUserNotFoundException("Betting user with id [" + input.getBettingUserId() + "] was not found"));

        List<GetAllBettingUserBetsByUserOutput> bets = bettingUser.getBets().stream()
                .map(bet -> GetAllBettingUserBetsByUserOutput.builder()
                        .bookmakerOfferId(bet.getBookmakerOfferId())
                        .betAmount(bet.getBetAmount().toString())
                        .pickedTeam(String.valueOf(bet.getPickedTeam()))
                        .bettingUserId(bet.getBettingUser().getId().toString())
                        .build())
                .toList();

        addLogOperation.process(AddLogInput.builder()
                .logMessage("Request to get all bets of user with id [" + bettingUser.getId() + "] was made")
                .build());

        return GetAllBettingUserBetsByUserListOutput.builder()
                .bets(bets)
                .build();

    }
}
