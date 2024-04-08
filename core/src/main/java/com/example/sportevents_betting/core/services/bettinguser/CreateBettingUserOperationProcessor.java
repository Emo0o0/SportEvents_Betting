package com.example.sportevents_betting.core.services.bettinguser;

import com.example.sportevents_betting.api.inputoutput.bettinguser.create.CreateBettingUserInput;
import com.example.sportevents_betting.api.inputoutput.bettinguser.create.CreateBettingUserOperation;
import com.example.sportevents_betting.api.inputoutput.bettinguser.create.CreateBettingUserOutput;
import com.example.sportevents_betting.api.inputoutput.log.add.AddLogInput;
import com.example.sportevents_betting.api.inputoutput.log.add.AddLogOperation;
import com.example.sportevents_betting.persistence.entities.BettingUser;
import com.example.sportevents_betting.persistence.repositories.BettingUserRepository;
import com.example.sportevents_payment.api.inputoutput.bettingusercard.create.CreateBettingUserCardInput;
import com.example.sportevents_payment.restexport.SportEventsPaymentRestClient;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateBettingUserOperationProcessor implements CreateBettingUserOperation {

    private final BettingUserRepository bettingUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final AddLogOperation addLogOperation;
    private final SportEventsPaymentRestClient sportEventsPaymentRestClient;

    @Override
    public CreateBettingUserOutput process(CreateBettingUserInput input) {

        BettingUser bettingUser = BettingUser.builder()
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .email(input.getEmail())
                .password(passwordEncoder.encode(input.getPassword()))
                .build();

        bettingUserRepository.save(bettingUser);

        addLogOperation.process(AddLogInput.builder()
                .logMessage("Created betting user with:" +
                        "\nid: " + bettingUser.getId().toString() +
                        "\nfirst name: " + bettingUser.getFirstName() +
                        "\nlast name: " + bettingUser.getLastName() +
                        "\nemail: " + bettingUser.getEmail())
                .build());


        sportEventsPaymentRestClient.createCard(CreateBettingUserCardInput.builder()
                .userId(bettingUser.getId().toString())
                .build());

        return CreateBettingUserOutput.builder()
                .id(bettingUser.getId().toString())
                .firstName(bettingUser.getFirstName())
                .lastName(bettingUser.getLastName())
                .email(bettingUser.getEmail())
                .build();


    }
}
