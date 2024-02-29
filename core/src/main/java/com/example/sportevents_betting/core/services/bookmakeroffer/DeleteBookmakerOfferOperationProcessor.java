package com.example.sportevents_betting.core.services.bookmakeroffer;

import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.delete.DeleteBookmakerOfferInput;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.delete.DeleteBookmakerOfferOperation;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.delete.DeleteBookmakerOfferOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteBookmakerOfferOperationProcessor implements DeleteBookmakerOfferOperation {
    @Override
    public DeleteBookmakerOfferOutput process(DeleteBookmakerOfferInput input) {
        return null;
    }
}
