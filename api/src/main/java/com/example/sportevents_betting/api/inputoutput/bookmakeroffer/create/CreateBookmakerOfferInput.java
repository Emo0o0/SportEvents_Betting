package com.example.sportevents_betting.api.inputoutput.bookmakeroffer.create;

import com.example.sportevents_betting.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookmakerOfferInput implements OperationInput {

    @NotBlank(message = "event id cannot be blank")
    private String eventId;
    @NotBlank(message = "odds cannot be blank")
    private String odds;
    @NotBlank(message = "bookmaker ID cannot be blank")
    private String bookmakerId;

}
