package com.example.sportevents_betting.core.services.bookmaker;

import com.example.sportevents_betting.api.inputoutput.bookmaker.edit.EditBookmakerInput;
import com.example.sportevents_betting.api.inputoutput.bookmaker.edit.EditBookmakerOperation;
import com.example.sportevents_betting.api.inputoutput.bookmaker.edit.EditBookmakerOutput;
import com.example.sportevents_betting.core.exceptions.BookmakerNotFoundException;
import com.example.sportevents_betting.persistence.entities.Bookmaker;
import com.example.sportevents_betting.persistence.repositories.BookmakerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditBookmakerOperationProcessor implements EditBookmakerOperation {

    private final BookmakerRepository bookmakerRepository;

    @Override
    public EditBookmakerOutput process(EditBookmakerInput input) {

        Bookmaker bookmaker = bookmakerRepository.findById(UUID.fromString(input.getId()))
                .orElseThrow(() -> new BookmakerNotFoundException("Bookmaker not found"));

        if (!input.getFirstName().isBlank()) {
            bookmaker.setFirstName(input.getFirstName());
        }
        if (!input.getLastName().isBlank()) {
            bookmaker.setLastName(input.getLastName());
        }
        if (!input.getEmail().isBlank()) {
            bookmaker.setEmail(input.getEmail());
        }
        if (!input.getPhone().isBlank()) {
            bookmaker.setPhone(input.getPhone());
        }

        bookmakerRepository.save(bookmaker);

        return EditBookmakerOutput.builder()
                .firstName(bookmaker.getFirstName())
                .lastName(bookmaker.getLastName())
                .email(bookmaker.getEmail())
                .phone(bookmaker.getPhone())
                .build();


    }
}
