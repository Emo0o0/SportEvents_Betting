package com.example.sportevents_betting.core.services.bettinguser;

import com.example.sportevents_betting.api.inputoutput.bettinguser.getbyid.GetBettingUserByIdInput;
import com.example.sportevents_betting.api.inputoutput.bettinguser.getbyid.GetBettingUserByIdOperation;
import com.example.sportevents_betting.api.inputoutput.bettinguser.getbyid.GetBettingUserByIdOutput;
import com.example.sportevents_betting.api.inputoutput.bettinguser.mapbets.MapBettingUserBetsInput;
import com.example.sportevents_betting.api.inputoutput.bettinguser.mapbets.MapBettingUserBetsOperation;
import com.example.sportevents_betting.core.exceptions.bettinguser.BettingUserNotFoundException;
import com.example.sportevents_betting.persistence.entities.BettingUser;
import com.example.sportevents_betting.persistence.repositories.BettingUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetBettingUserByIdOperationProcessor implements GetBettingUserByIdOperation {

    private final BettingUserRepository bettingUserRepository;
    private final MapBettingUserBetsOperation mapBettingUserBetsOperation;

    @Override
    public GetBettingUserByIdOutput process(GetBettingUserByIdInput input) {

        BettingUser bettingUser = bettingUserRepository.findById(UUID.fromString(input.getId()))
                .orElseThrow(() -> new BettingUserNotFoundException("user not found"));


        return GetBettingUserByIdOutput.builder()
                .firstName(bettingUser.getFirstName())
                .lastName(bettingUser.getLastName())
                .email(bettingUser.getEmail())
                .bets(new HashSet<>(mapBettingUserBetsOperation.process(MapBettingUserBetsInput.builder().bets(bettingUser.getBets()).build()).getMappedBets()))
                .build();

    }
}
