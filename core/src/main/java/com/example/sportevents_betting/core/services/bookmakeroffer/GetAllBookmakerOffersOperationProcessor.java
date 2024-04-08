package com.example.sportevents_betting.core.services.bookmakeroffer;

import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getall.GetAllBookmakerOffersInput;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getall.GetAllBookmakerOffersListOutput;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getall.GetAllBookmakerOffersOperation;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getall.GetAllBookmakerOffersOutput;
import com.example.sportevents_betting.api.inputoutput.log.add.AddLogInput;
import com.example.sportevents_betting.api.inputoutput.log.add.AddLogOperation;
import com.example.sportevents_betting.persistence.repositories.BookmakerOfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllBookmakerOffersOperationProcessor implements GetAllBookmakerOffersOperation {

    private final BookmakerOfferRepository bookmakerOfferRepository;
    private final AddLogOperation addLogOperation;

    @Override
    public GetAllBookmakerOffersListOutput process(GetAllBookmakerOffersInput input) {

        PageRequest pageRequest = PageRequest.of(Integer.parseInt(input.getPageNumber()) - 1, Integer.parseInt(input.getItemsPerPage()));

        List<GetAllBookmakerOffersOutput> offers = bookmakerOfferRepository.findAll(pageRequest).stream()
                .map(offer -> GetAllBookmakerOffersOutput.builder()
                        .id(offer.getId().toString())
                        .eventId(offer.getEventId())
                        .odds(offer.getOdds())
                        .bookmakerId(offer.getBookmaker().getId().toString())
                        .build())
                .toList();

        addLogOperation.process(AddLogInput.builder()
                .logMessage("Request to get all bookmaker offers was made")
                .build());

        return GetAllBookmakerOffersListOutput.builder()
                .bookmakerOffers(offers)
                .build();
    }
}
