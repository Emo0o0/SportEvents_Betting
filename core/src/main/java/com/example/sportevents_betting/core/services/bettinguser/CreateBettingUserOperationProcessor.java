package com.example.sportevents_betting.core.services.bettinguser;

import com.example.sportevents_betting.api.inputoutput.bettinguser.create.CreateBettingUserInput;
import com.example.sportevents_betting.api.inputoutput.bettinguser.create.CreateBettingUserOperation;
import com.example.sportevents_betting.api.inputoutput.bettinguser.create.CreateBettingUserOutput;
import com.example.sportevents_betting.persistence.entities.BettingUser;
import com.example.sportevents_betting.persistence.repositories.BettingUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateBettingUserOperationProcessor implements CreateBettingUserOperation {

    private final BettingUserRepository bettingUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public CreateBettingUserOutput process(CreateBettingUserInput input) {

        BettingUser bettingUser = BettingUser.builder()
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .email(input.getEmail())
                .password(passwordEncoder.encode(input.getPassword()))
                .build();

        bettingUserRepository.save(bettingUser);

        return CreateBettingUserOutput.builder()
                .id(bettingUser.getId().toString())
                .firstName(bettingUser.getFirstName())
                .lastName(bettingUser.getLastName())
                .email(bettingUser.getEmail())
                .build();


    }
}
