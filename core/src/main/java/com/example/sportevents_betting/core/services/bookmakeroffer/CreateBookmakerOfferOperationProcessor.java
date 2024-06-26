package com.example.sportevents_betting.core.services.bookmakeroffer;


import com.example.sportevents.restexport.SportEventsRestClient;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.create.CreateBookmakerOfferInput;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.create.CreateBookmakerOfferOperation;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.create.CreateBookmakerOfferOutput;
import com.example.sportevents_betting.api.inputoutput.log.add.AddLogInput;
import com.example.sportevents_betting.api.inputoutput.log.add.AddLogOperation;
import com.example.sportevents_betting.core.exceptions.bookmaker.BookmakerNotFoundException;
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
    private final SportEventsRestClient sportEventsRestClient;
    private final AddLogOperation addLogOperation;

    @Override
    public CreateBookmakerOfferOutput process(CreateBookmakerOfferInput input) {

        Bookmaker bookmaker = bookmakerRepository.findById(UUID.fromString(input.getBookmakerId()))
                .orElseThrow(() -> new BookmakerNotFoundException("Bookmaker not found"));

        sportEventsRestClient.getSportEventById(input.getEventId());


        BookmakerOffer bookmakerOffer = BookmakerOffer.builder()
                .eventId(input.getEventId())
                .odds(input.getOdds())
                .bookmaker(bookmaker)
                .build();

        bookmakerOfferRepository.save(bookmakerOffer);

        addLogOperation.process(AddLogInput.builder()
                .logMessage("Created bookmaker offer with:" +
                        "\nid: " + bookmakerOffer.getId() +
                        "\nodds: " + bookmakerOffer.getOdds() +
                        "\nevent id: " + bookmakerOffer.getEventId() +
                        "\nbookmaker id: " + bookmakerOffer.getBookmaker().getId())
                .build());

        return CreateBookmakerOfferOutput.builder()
                .id(bookmakerOffer.getId().toString())
                .eventId(bookmakerOffer.getEventId())
                .odds(bookmakerOffer.getOdds())
                .bookmakerId(bookmakerOffer.getBookmaker().getId().toString())
                .build();


    }
}
