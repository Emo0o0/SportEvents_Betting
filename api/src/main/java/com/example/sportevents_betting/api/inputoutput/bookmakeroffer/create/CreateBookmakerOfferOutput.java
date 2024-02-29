package com.example.sportevents_betting.api.inputoutput.bookmakeroffer.create;

import com.example.sportevents_betting.api.base.OperationResult;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookmakerOfferOutput implements OperationResult {

    private String id;
    private String eventId;
    private String odds;
    private String bookmakerId;

}
