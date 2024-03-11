package com.example.sportevents_betting.core.services.bookmakeroffer;

import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.edit.EditBookmakerOfferInput;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.edit.EditBookmakerOfferOperation;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.edit.EditBookmakerOfferOutput;
import com.example.sportevents_betting.core.exceptions.bookmakeroffer.BookmakerOfferNotFoundException;
import com.example.sportevents_betting.persistence.entities.BookmakerOffer;
import com.example.sportevents_betting.persistence.repositories.BookmakerOfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditBookmakerOfferOperationProcessor implements EditBookmakerOfferOperation {

    private final BookmakerOfferRepository bookmakerOfferRepository;
    //private final BookmakerRepository bookmakerRepository;

    @Override
    public EditBookmakerOfferOutput process(EditBookmakerOfferInput input) {

        BookmakerOffer bookmakerOffer = bookmakerOfferRepository.findById(UUID.fromString(input.getId()))
                .orElseThrow(() -> new BookmakerOfferNotFoundException("Offer with id [" + input.getId() + "] was not found"));

        //Bookmaker bookmaker = bookmakerRepository.findById(bookmakerOffer.getBookmaker().getId())
        //        .orElseThrow(() -> new BookmakerNotFoundException("Bookmaker with id [" + bookmakerOffer.getBookmaker().getId() + "] was not found"));

        if (!input.getOdds().isBlank()) {
            bookmakerOffer.setOdds(input.getOdds());
        }

        bookmakerOfferRepository.save(bookmakerOffer);

        return EditBookmakerOfferOutput.builder()
                .bookmakerId(bookmakerOffer.getBookmaker().getId().toString())
                .eventId(bookmakerOffer.getEventId())
                .odds(bookmakerOffer.getOdds())
                .build();
    }
}
