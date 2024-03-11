package com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getallbybookmaker;

import com.example.sportevents_betting.api.base.OperationInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllOffersByBookmakerInput implements OperationInput {

    private String bookmakerId;

}
