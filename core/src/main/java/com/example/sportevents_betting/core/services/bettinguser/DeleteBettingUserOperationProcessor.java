package com.example.sportevents_betting.core.services.bettinguser;

import com.example.sportevents_betting.api.inputoutput.bettinguser.delete.DeleteBettingUserInput;
import com.example.sportevents_betting.api.inputoutput.bettinguser.delete.DeleteBettingUserOperation;
import com.example.sportevents_betting.api.inputoutput.bettinguser.delete.DeleteBettingUserOutput;
import com.example.sportevents_betting.core.exceptions.bettinguser.BettingUserNotFoundException;
import com.example.sportevents_betting.persistence.entities.BettingUser;
import com.example.sportevents_betting.persistence.repositories.BettingUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteBettingUserOperationProcessor implements DeleteBettingUserOperation {

    private final BettingUserRepository bettingUserRepository;

    @Override
    public DeleteBettingUserOutput process(DeleteBettingUserInput input) {

        BettingUser bettingUser = bettingUserRepository.findById(UUID.fromString(input.getId()))
                .orElseThrow(() -> new BettingUserNotFoundException("User not found"));

        bettingUserRepository.delete(bettingUser);

        return DeleteBettingUserOutput.builder()
                .success(true)
                .build();


    }
}
