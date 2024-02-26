package com.example.sportevents_betting.core.services.bookmaker;

import com.example.sportevents_betting.api.inputoutput.bookmaker.create.CreateBookmakerInput;
import com.example.sportevents_betting.api.inputoutput.bookmaker.create.CreateBookmakerOperation;
import com.example.sportevents_betting.api.inputoutput.bookmaker.create.CreateBookmakerOutput;
import com.example.sportevents_betting.persistence.entities.Bookmaker;
import com.example.sportevents_betting.persistence.repositories.BookmakerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateBookmakerOperationProcessor implements CreateBookmakerOperation {

    private final BookmakerRepository bookmakerRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public CreateBookmakerOutput process(CreateBookmakerInput input) {


        Bookmaker bookmaker = Bookmaker.builder()
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .email(input.getEmail())
                .phone(input.getPhone())
                .password(passwordEncoder.encode(input.getPassword()))
                .build();

        bookmakerRepository.save(bookmaker);

        return CreateBookmakerOutput.builder()
                .firstName(bookmaker.getFirstName())
                .lastName(bookmaker.getLastName())
                .email(bookmaker.getEmail())
                .phone(bookmaker.getPhone())
                .success(true)
                .build();
    }
}
