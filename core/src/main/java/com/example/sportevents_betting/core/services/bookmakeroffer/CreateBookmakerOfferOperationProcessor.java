package com.example.sportevents_betting.core.services.bookmakeroffer;

import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.create.CreateBookmakerOfferInput;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.create.CreateBookmakerOfferOperation;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.create.CreateBookmakerOfferOutput;
import com.example.sportevents_betting.core.exceptions.BookmakerNotFoundException;
import com.example.sportevents_betting.persistence.entities.Bookmaker;
import com.example.sportevents_betting.persistence.entities.BookmakerOffer;
import com.example.sportevents_betting.persistence.repositories.BookmakerOfferRepository;
import com.example.sportevents_betting.persistence.repositories.BookmakerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateBookmakerOfferOperationProcessor implements CreateBookmakerOfferOperation {

    private final BookmakerOfferRepository bookmakerOfferRepository;
    private final BookmakerRepository bookmakerRepository;

    @Override
    public CreateBookmakerOfferOutput process(CreateBookmakerOfferInput input) {

        Bookmaker bookmaker = bookmakerRepository.findById(UUID.fromString(input.getBookmakerId()))
                .orElseThrow(() -> new BookmakerNotFoundException("Bookmaker not found"));


        BookmakerOffer bookmakerOffer = BookmakerOffer.builder()
                .eventId(input.getEventId())
                .odds(input.getOdds())
                .bookmaker(bookmaker)
                .build();

        bookmakerOfferRepository.save(bookmakerOffer);

        return CreateBookmakerOfferOutput.builder()
                .id(bookmakerOffer.getId().toString())
                .eventId(bookmakerOffer.getEventId())
                .odds(bookmakerOffer.getOdds())
                .bookmakerId(bookmakerOffer.getBookmaker().getId().toString())
                .build();


    }
}
