package com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getall;

import com.example.sportevents_betting.api.base.OperationResult;
import lombok.*;

import java.util.List;


@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllBookmakerOffersListOutput implements OperationResult {

    private List<GetAllBookmakerOffersOutput> bookmakerOffers;

}
