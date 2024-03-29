package com.example.sportevents_betting.api.inputoutput.bookmakeroffer.delete;

import com.example.sportevents_betting.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteBookmakerOfferInput implements OperationInput {

    @NotBlank(message = "bookmaker ID cannot be blank")
    private String id;

}
