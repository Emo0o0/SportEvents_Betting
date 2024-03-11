package com.example.sportevents_betting.api.inputoutput.bettinguserbet.create;

import com.example.sportevents_betting.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBettingUserBetInput implements OperationInput {

    @NotBlank(message = "bookmakerOfferId cannot be blank")
    private String bookmakerOfferId;
    @NotBlank(message = "betAmount cannot be blank")
    private String betAmount;
    @NotBlank(message = "pickedTeam cannot be blank")
    private String pickedTeam;
    @NotBlank(message = "bettingUserid cannot be blank")
    private String bettingUserId;

}
