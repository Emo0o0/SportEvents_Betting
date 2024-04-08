package com.example.sportevents_betting.core.services.bookmakeroffer;

import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.delete.DeleteBookmakerOfferInput;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.delete.DeleteBookmakerOfferOperation;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.delete.DeleteBookmakerOfferOutput;
import com.example.sportevents_betting.api.inputoutput.log.add.AddLogInput;
import com.example.sportevents_betting.api.inputoutput.log.add.AddLogOperation;
import com.example.sportevents_betting.core.exceptions.bookmakeroffer.BookmakerOfferHasBetsException;
import com.example.sportevents_betting.core.exceptions.bookmakeroffer.BookmakerOfferNotFoundException;
import com.example.sportevents_betting.persistence.entities.BookmakerOffer;
import com.example.sportevents_betting.persistence.repositories.BettingUserBetRepository;
import com.example.sportevents_betting.persistence.repositories.BookmakerOfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteBookmakerOfferOperationProcessor implements DeleteBookmakerOfferOperation {

    private final BookmakerOfferRepository bookmakerOfferRepository;
    private final BettingUserBetRepository bettingUserBetRepository;
    private final AddLogOperation addLogOperation;

    @Override
    public DeleteBookmakerOfferOutput process(DeleteBookmakerOfferInput input) {

        if (!bettingUserBetRepository.findAllByBookmakerOfferId(input.getId()).isEmpty())
            throw new BookmakerOfferHasBetsException("Cannot delete. This offer has placed bets");

        BookmakerOffer bookmakerOffer = bookmakerOfferRepository.findById(UUID.fromString(input.getId()))
                .orElseThrow(() -> new BookmakerOfferNotFoundException("Bookmaker offer with id [" + input.getId() + "] was not found"));

        addLogOperation.process(AddLogInput.builder()
                .logMessage("Deleted bookmaker offer with:" +
                        "\nid: " + bookmakerOffer.getId() +
                        "\nodds: " + bookmakerOffer.getOdds() +
                        "\nevent id: " + bookmakerOffer.getEventId() +
                        "\nbookmaker id: " + bookmakerOffer.getBookmaker().getId())
                .build());

        return null;
    }
}
