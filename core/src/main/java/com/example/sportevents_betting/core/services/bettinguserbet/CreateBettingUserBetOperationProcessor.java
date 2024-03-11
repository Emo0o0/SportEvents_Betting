package com.example.sportevents_betting.core.services.bettinguserbet;

import com.example.sportevents_betting.api.inputoutput.bettinguserbet.create.CreateBettingUserBetInput;
import com.example.sportevents_betting.api.inputoutput.bettinguserbet.create.CreateBettingUserBetOperation;
import com.example.sportevents_betting.api.inputoutput.bettinguserbet.create.CreateBettingUserBetOutput;
import com.example.sportevents_betting.core.exceptions.bettinguser.BettingUserNotFoundException;
import com.example.sportevents_betting.core.exceptions.bookmakeroffer.BookmakerOfferNotFoundException;
import com.example.sportevents_betting.persistence.entities.BettingUser;
import com.example.sportevents_betting.persistence.entities.BettingUserBet;
import com.example.sportevents_betting.persistence.repositories.BettingUserBetRepository;
import com.example.sportevents_betting.persistence.repositories.BettingUserRepository;
import com.example.sportevents_betting.persistence.repositories.BookmakerOfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateBettingUserBetOperationProcessor implements CreateBettingUserBetOperation {

    private final BettingUserBetRepository bettingUserBetRepository;
    private final BookmakerOfferRepository bookmakerOfferRepository;
    private final BettingUserRepository bettingUserRepository;

    @Override
    public CreateBettingUserBetOutput process(CreateBettingUserBetInput input) {

        if (!bookmakerOfferRepository.existsById(UUID.fromString(input.getBookmakerOfferId()))) {
            throw new BookmakerOfferNotFoundException("Bookmaker offer with id [" + input.getBookmakerOfferId() + "] was not found");
        }

        BettingUser bettingUser = bettingUserRepository.findById(UUID.fromString(input.getBettingUserId()))
                .orElseThrow(() -> new BettingUserNotFoundException("Betting user with id [" + input.getBettingUserId() + "] was not found"));


        BettingUserBet bet = BettingUserBet.builder()
                .bookmakerOfferId(input.getBookmakerOfferId())
                .betAmount(new BigDecimal(input.getBetAmount()))
                .pickedTeam(Integer.parseInt(input.getPickedTeam()))
                .bettingUser(bettingUser)
                .build();

        bettingUserBetRepository.save(bet);

        return CreateBettingUserBetOutput.builder()
                .id(bet.getId().toString())
                .bookmakerOfferId(bet.getBookmakerOfferId())
                .betAmount(bet.getBetAmount().toString())
                .pickedTeam(String.valueOf(bet.getPickedTeam()))
                .bettingUserId(bet.getBettingUser().getId().toString())
                .build();


    }
}
