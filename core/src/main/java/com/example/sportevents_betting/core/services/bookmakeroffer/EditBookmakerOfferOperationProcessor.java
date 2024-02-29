package com.example.sportevents_betting.core.services.bookmakeroffer;

import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.edit.EditBookmakerOfferInput;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.edit.EditBookmakerOfferOperation;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.edit.EditBookmakerOfferOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditBookmakerOfferOperationProcessor implements EditBookmakerOfferOperation {
    @Override
    public EditBookmakerOfferOutput process(EditBookmakerOfferInput input) {
        return null;
    }
}
