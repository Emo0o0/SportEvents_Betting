package com.example.sportevents_betting.core.services.bookmaker;

import com.example.sportevents_betting.api.inputoutput.bookmaker.getbyid.GetBookmakerByIdInput;
import com.example.sportevents_betting.api.inputoutput.bookmaker.getbyid.GetBookmakerByIdOperation;
import com.example.sportevents_betting.api.inputoutput.bookmaker.getbyid.GetBookmakerByIdOutput;
import com.example.sportevents_betting.api.inputoutput.bookmaker.mapoffers.MapBookmakerOffersInput;
import com.example.sportevents_betting.api.inputoutput.bookmaker.mapoffers.MapBookmakerOffersOperation;
import com.example.sportevents_betting.core.exceptions.bookmaker.BookmakerNotFoundException;
import com.example.sportevents_betting.persistence.entities.Bookmaker;
import com.example.sportevents_betting.persistence.repositories.BookmakerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetBookmakerByIdOperationProcessor implements GetBookmakerByIdOperation {

    private final BookmakerRepository bookmakerRepository;
    private final MapBookmakerOffersOperation mapBookmakerOffersOperation;

    @Override
    public GetBookmakerByIdOutput process(GetBookmakerByIdInput input) {

        Bookmaker bookmaker = bookmakerRepository.findById(UUID.fromString(input.getId()))
                .orElseThrow(() -> new BookmakerNotFoundException("Bookmaker not found"));

        return GetBookmakerByIdOutput.builder()
                .firstName(bookmaker.getFirstName())
                .lastName(bookmaker.getLastName())
                .email(bookmaker.getEmail())
                .phone(bookmaker.getPhone())
                .bookmakerOffers(mapBookmakerOffersOperation.process(
                                MapBookmakerOffersInput.builder()
                                        .bookmakerOffers(bookmaker.getBookmakerOffers())
                                        .build())
                        .getBookmakerOffers())
                .build();
    }
}
