package com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getallbybookmaker;

import com.example.sportevents_betting.api.base.OperationResult;
import lombok.*;

import java.util.List;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllOffersByBookmakerListOutput implements OperationResult {

    private List<GetAllOffersByBookmakerOutput> offers;

}
