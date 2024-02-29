package com.example.sportevents_betting.core.services.bookmakeroffer;

import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getbyid.GetBookmakerOfferByIdInput;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getbyid.GetBookmakerOfferByIdOperation;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getbyid.GetBookmakerOfferByIdOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetBookmakerOfferByIdOperationProcessor implements GetBookmakerOfferByIdOperation {
    @Override
    public GetBookmakerOfferByIdOutput process(GetBookmakerOfferByIdInput input) {
        return null;
    }
}
