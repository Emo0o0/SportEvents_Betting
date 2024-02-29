package com.example.sportevents_betting.api.inputoutput.bookmakeroffer.create;

import com.example.sportevents_betting.api.base.OperationInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookmakerOfferInput implements OperationInput {

    private String eventId;
    private String odds;
    private String bookmakerId;

}
