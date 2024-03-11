package com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getallbybookmaker;

import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllOffersByBookmakerOutput {

    private String id;
    private String eventId;
    private String odds;
    private String bookmakerId;

}
