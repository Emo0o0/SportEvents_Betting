package com.example.sportevents_betting.core.services.bettinguserbet;

import com.example.sportevents_betting.api.inputoutput.bettinguserbet.calculatebets.CalculateBetsInput;
import com.example.sportevents_betting.api.inputoutput.bettinguserbet.calculatebets.CalculateBetsOperation;
import com.example.sportevents_betting.api.inputoutput.bettinguserbet.calculatebets.CalculateBetsOutput;
import com.example.sportevents_betting.api.inputoutput.bettinguserbet.calculatebets.CalculateBetsSetOutput;
import com.example.sportevents_betting.persistence.entities.BettingUserBet;
import com.example.sportevents_betting.persistence.entities.BookmakerOffer;
import com.example.sportevents_betting.persistence.repositories.BettingUserBetRepository;
import com.example.sportevents_betting.persistence.repositories.BookmakerOfferRepository;
import com.example.sportevents_payment.api.inputoutput.betresult.ReceiveBetsInput;
import com.example.sportevents_payment.api.inputoutput.betresult.ReceiveBetsOutput;
import com.example.sportevents_payment.api.inputoutput.betresult.ReceiveBetsSetInput;
import com.example.sportevents_payment.restexport.SportEventsPaymentRestClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CalculateBetsOperationProcessor implements CalculateBetsOperation {

    private final BookmakerOfferRepository bookmakerOfferRepository;
    private final BettingUserBetRepository bettingUserBetRepository;
    private final SportEventsPaymentRestClient sportEventsPaymentRestClient;

    @Override
    public CalculateBetsSetOutput process(CalculateBetsInput input) {

        Set<BookmakerOffer> offers = bookmakerOfferRepository.findAllByEventId(input.getEventId());

        Set<BettingUserBet> bets = new HashSet<>();
        Set<CalculateBetsOutput> outputs = new HashSet<>();
        for (BookmakerOffer bo : offers) {
            bets.addAll(bettingUserBetRepository.findAllByBookmakerOfferId(bo.getId().toString()));
            for (BettingUserBet bub : bets) {
                outputs.add(CalculateBetsOutput.builder()
                        .userId(bub.getBettingUser().getId().toString())
                        .bookmakerOfferId(bo.getId().toString())
                        .betAmount(bub.getBetAmount())
                        .pickedTeam(bub.getPickedTeam())
                        .teamWon(input.getTeamWon())
                        .odds(bo.getOdds())
                        .build());
            }
            bets.clear();
        }

        Set<ReceiveBetsInput> sentBets = new HashSet<>();
        for (CalculateBetsOutput cbo : outputs) {
            sentBets.add(ReceiveBetsInput.builder()
                    .userId(cbo.getUserId())
                    .bookmakerOfferId(cbo.getBookmakerOfferId())
                    .betAmount(cbo.getBetAmount())
                    .pickedTeam(cbo.getPickedTeam())
                    .teamWon(cbo.getTeamWon())
                    .odds(cbo.getOdds())
                    .build());
        }
        sportEventsPaymentRestClient.receive(ReceiveBetsSetInput.builder()
                .receivedBets(sentBets)
                .build());

        return CalculateBetsSetOutput.builder()
                .betResults(outputs)
                .build();
    }
}
