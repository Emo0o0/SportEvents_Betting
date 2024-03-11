package com.example.sportevents_betting.core.services.bookmakeroffer;

import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getbyid.GetBookmakerOfferByIdInput;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getbyid.GetBookmakerOfferByIdOperation;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getbyid.GetBookmakerOfferByIdOutput;
import com.example.sportevents_betting.core.exceptions.bookmakeroffer.BookmakerOfferNotFoundException;
import com.example.sportevents_betting.persistence.entities.BookmakerOffer;
import com.example.sportevents_betting.persistence.repositories.BookmakerOfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetBookmakerOfferByIdOperationProcessor implements GetBookmakerOfferByIdOperation {

    private final BookmakerOfferRepository bookmakerOfferRepository;

    @Override
    public GetBookmakerOfferByIdOutput process(GetBookmakerOfferByIdInput input) {

        BookmakerOffer bookmakerOffer = bookmakerOfferRepository.findById(UUID.fromString(input.getId()))
                .orElseThrow(() -> new BookmakerOfferNotFoundException("Offer with id [" + input.getId() + "] was not found"));

        return GetBookmakerOfferByIdOutput.builder()
                .eventId(bookmakerOffer.getEventId())
                .odds(bookmakerOffer.getOdds())
                .bookmakerId(bookmakerOffer.getBookmaker().getId().toString())
                .build();


    }
}
