package com.example.sportevents_betting.core.services.bettinguser;

import com.example.sportevents_betting.api.inputoutput.bettinguser.edit.EditBettingUserInput;
import com.example.sportevents_betting.api.inputoutput.bettinguser.edit.EditBettingUserOperation;
import com.example.sportevents_betting.api.inputoutput.bettinguser.edit.EditBettingUserOutput;
import com.example.sportevents_betting.core.exceptions.bettinguser.BettingUserNotFoundException;
import com.example.sportevents_betting.persistence.entities.BettingUser;
import com.example.sportevents_betting.persistence.repositories.BettingUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditBettingUserOperationProcessor implements EditBettingUserOperation {

    private final BettingUserRepository bettingUserRepository;

    @Override
    public EditBettingUserOutput process(EditBettingUserInput input) {

        BettingUser bettingUser = bettingUserRepository.findById(UUID.fromString(input.getId()))
                .orElseThrow(() -> new BettingUserNotFoundException("User not found"));

        if (!input.getFirstName().isBlank()) {
            bettingUser.setFirstName(input.getFirstName());
        }
        if (!input.getLastName().isBlank()) {
            bettingUser.setLastName(input.getLastName());
        }
        if (!input.getEmail().isBlank()) {
            bettingUser.setEmail(input.getEmail());
        }

        bettingUserRepository.save(bettingUser);

        return EditBettingUserOutput.builder()
                .firstName(bettingUser.getFirstName())
                .lastName(bettingUser.getLastName())
                .email(bettingUser.getEmail())
                .build();

    }
}
