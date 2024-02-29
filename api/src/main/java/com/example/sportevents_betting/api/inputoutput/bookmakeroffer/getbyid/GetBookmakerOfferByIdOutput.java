package com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getbyid;

import com.example.sportevents_betting.api.base.OperationResult;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetBookmakerOfferByIdOutput implements OperationResult {

    private String eventId;
    private String odds;
    private String bookmakerId;

}
