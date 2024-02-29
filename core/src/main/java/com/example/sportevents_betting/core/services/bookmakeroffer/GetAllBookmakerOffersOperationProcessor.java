package com.example.sportevents_betting.core.services.bookmakeroffer;

import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getall.GetAllBookmakerOffersInput;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getall.GetAllBookmakerOffersListOutput;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getall.GetAllBookmakerOffersOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllBookmakerOffersOperationProcessor implements GetAllBookmakerOffersOperation {
    @Override
    public GetAllBookmakerOffersListOutput process(GetAllBookmakerOffersInput input) {
        return null;
    }
}
