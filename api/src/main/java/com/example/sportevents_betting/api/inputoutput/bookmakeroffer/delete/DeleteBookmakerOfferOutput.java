package com.example.sportevents_betting.api.inputoutput.bookmakeroffer.delete;

import com.example.sportevents_betting.api.base.OperationResult;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteBookmakerOfferOutput implements OperationResult {

    private Boolean success;

}
