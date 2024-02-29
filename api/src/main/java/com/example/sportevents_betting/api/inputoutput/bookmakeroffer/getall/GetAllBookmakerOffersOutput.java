package com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getall;

import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllBookmakerOffersOutput {

    private String id;
    private String eventId;
    private String odds;
    private String bookmakerId;

}
