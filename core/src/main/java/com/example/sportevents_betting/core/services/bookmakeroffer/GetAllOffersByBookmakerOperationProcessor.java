package com.example.sportevents_betting.core.services.bookmakeroffer;

import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getallbybookmaker.GetAllOffersByBookmakerInput;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getallbybookmaker.GetAllOffersByBookmakerListOutput;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getallbybookmaker.GetAllOffersByBookmakerOperation;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getallbybookmaker.GetAllOffersByBookmakerOutput;
import com.example.sportevents_betting.api.inputoutput.log.add.AddLogInput;
import com.example.sportevents_betting.api.inputoutput.log.add.AddLogOperation;
import com.example.sportevents_betting.core.exceptions.bookmaker.BookmakerNotFoundException;
import com.example.sportevents_betting.persistence.entities.Bookmaker;
import com.example.sportevents_betting.persistence.repositories.BookmakerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetAllOffersByBookmakerOperationProcessor implements GetAllOffersByBookmakerOperation {

    private final BookmakerRepository bookmakerRepository;
    private final AddLogOperation addLogOperation;

    @Override
    public GetAllOffersByBookmakerListOutput process(GetAllOffersByBookmakerInput input) {

        Bookmaker bookmaker = bookmakerRepository.findById(UUID.fromString(input.getBookmakerId()))
                .orElseThrow(() -> new BookmakerNotFoundException("Bookmaker with id [" + input.getBookmakerId() + "] was not found"));

        List<GetAllOffersByBookmakerOutput> offers = bookmaker.getBookmakerOffers().stream()
                .map(offer -> GetAllOffersByBookmakerOutput.builder()
                        .id(offer.getId().toString())
                        .eventId(offer.getEventId())
                        .odds(offer.getOdds())
                        .bookmakerId(offer.getBookmaker().getId().toString())
                        .build())
                .toList();

        addLogOperation.process(AddLogInput.builder()
                .logMessage("Request to get all offers of bookmaker with id [" + input.getBookmakerId() + "] was made")
                .build());

        return GetAllOffersByBookmakerListOutput.builder()
                .offers(offers)
                .build();
    }
}
