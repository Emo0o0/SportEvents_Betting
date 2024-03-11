package com.example.sportevents_betting.core.services.bettinguserbet;

import com.example.sportevents_betting.api.inputoutput.bettinguserbet.getall.GetAllBettingUserBetsInput;
import com.example.sportevents_betting.api.inputoutput.bettinguserbet.getall.GetAllBettingUserBetsListOutput;
import com.example.sportevents_betting.api.inputoutput.bettinguserbet.getall.GetAllBettingUserBetsOperation;
import com.example.sportevents_betting.api.inputoutput.bettinguserbet.getall.GetAllBettingUserBetsOutput;
import com.example.sportevents_betting.persistence.repositories.BettingUserBetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllBettingUserBetsOperationProcessor implements GetAllBettingUserBetsOperation {

    private final BettingUserBetRepository bettingUserBetRepository;

    @Override
    public GetAllBettingUserBetsListOutput process(GetAllBettingUserBetsInput input) {


        PageRequest pageRequest = PageRequest.of(Integer.parseInt(input.getPageNumber()), Integer.parseInt(input.getItemsPerPage()));

        List<GetAllBettingUserBetsOutput> bets = bettingUserBetRepository.findAll(pageRequest).stream()
                .map(bet -> GetAllBettingUserBetsOutput.builder()
                        .bookmakerOfferId(bet.getBookmakerOfferId())
                        .betAmount(bet.getBetAmount().toString())
                        .pickedTeam(String.valueOf(bet.getPickedTeam()))
                        .bettingUserId(bet.getBettingUser().getId().toString())
                        .build())
                .toList();

        return GetAllBettingUserBetsListOutput.builder()
                .bets(bets)
                .build();


    }
}
