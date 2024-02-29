package com.example.sportevents_betting.api.inputoutput.bookmakeroffer.delete;

import com.example.sportevents_betting.api.base.OperationInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteBookmakerOfferInput implements OperationInput {

    private String id;

}
