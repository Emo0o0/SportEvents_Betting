package com.example.sportevents_betting.api.inputoutput.bookmakeroffer.edit;

import com.example.sportevents_betting.api.base.OperationInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditBookmakerOfferInput implements OperationInput {

    private String id;
    //private String eventId;
    private String odds;
    //private String bookmakerId;


}
