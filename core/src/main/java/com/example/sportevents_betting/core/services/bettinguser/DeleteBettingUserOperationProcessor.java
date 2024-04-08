package com.example.sportevents_betting.core.services.bettinguser;

import com.example.sportevents_betting.api.inputoutput.bettinguser.delete.DeleteBettingUserInput;
import com.example.sportevents_betting.api.inputoutput.bettinguser.delete.DeleteBettingUserOperation;
import com.example.sportevents_betting.api.inputoutput.bettinguser.delete.DeleteBettingUserOutput;
import com.example.sportevents_betting.api.inputoutput.log.add.AddLogInput;
import com.example.sportevents_betting.api.inputoutput.log.add.AddLogOperation;
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
    private final AddLogOperation addLogOperation;
    @Override
    public DeleteBettingUserOutput process(DeleteBettingUserInput input) {

        BettingUser bettingUser = bettingUserRepository.findById(UUID.fromString(input.getId()))
                .orElseThrow(() -> new BettingUserNotFoundException("User not found"));

        bettingUserRepository.delete(bettingUser);

        addLogOperation.process(AddLogInput.builder()
                .logMessage("Deleted betting user with:" +
                        "\nid: " + bettingUser.getId().toString() +
                        "\nfirst name: " + bettingUser.getFirstName() +
                        "\nlast name: " + bettingUser.getLastName() +
                        "\nemail: " + bettingUser.getEmail())
                .build());


        return DeleteBettingUserOutput.builder()
                .success(true)
                .build();


    }
}
