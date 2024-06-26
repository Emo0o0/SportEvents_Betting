package com.example.sportevents_betting.core.services.bookmaker;

import com.example.sportevents_betting.api.inputoutput.bookmaker.delete.DeleteBookmakerInput;
import com.example.sportevents_betting.api.inputoutput.bookmaker.delete.DeleteBookmakerOperation;
import com.example.sportevents_betting.api.inputoutput.bookmaker.delete.DeleteBookmakerOutput;
import com.example.sportevents_betting.api.inputoutput.log.add.AddLogInput;
import com.example.sportevents_betting.api.inputoutput.log.add.AddLogOperation;
import com.example.sportevents_betting.core.exceptions.bookmaker.BookmakerIncorrectPasswordException;
import com.example.sportevents_betting.core.exceptions.bookmaker.BookmakerNotFoundException;
import com.example.sportevents_betting.persistence.entities.Bookmaker;
import com.example.sportevents_betting.persistence.repositories.BookmakerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteBookmakerOperationProcessor implements DeleteBookmakerOperation {

    private final BookmakerRepository bookmakerRepository;
    private final PasswordEncoder passwordEncoder;
    private final AddLogOperation addLogOperation;

    @Override
    public DeleteBookmakerOutput process(DeleteBookmakerInput input) {

        validate(input);

        Bookmaker bookmaker = bookmakerRepository.findById(UUID.fromString(input.getId()))
                .orElseThrow(() -> new BookmakerNotFoundException("Bookmaker not found"));

        bookmakerRepository.delete(bookmaker);

        addLogOperation.process(AddLogInput.builder()
                .logMessage("Deleted bookmaker with:" +
                        "\nid: " + bookmaker.getId().toString() +
                        "\nfirst name: " + bookmaker.getFirstName() +
                        "\nlast name: " + bookmaker.getLastName() +
                        "\nemail: " + bookmaker.getEmail() +
                        "\nphone: " + bookmaker.getPhone())
                .build());

        return DeleteBookmakerOutput.builder()
                .success(true)
                .build();


    }

    private Boolean validate(DeleteBookmakerInput input) {

        Bookmaker bookmaker = bookmakerRepository.findById(UUID.fromString(input.getId()))
                .orElseThrow(() -> new BookmakerNotFoundException("Bookmaker not found"));

        if (!passwordEncoder.matches(input.getPassword(), bookmaker.getPassword())) {
            throw new BookmakerIncorrectPasswordException("Incorrect password");
        }

        return true;

    }
}
