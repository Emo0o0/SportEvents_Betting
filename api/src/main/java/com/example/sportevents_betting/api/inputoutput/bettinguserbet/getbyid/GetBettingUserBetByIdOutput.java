package com.example.sportevents_betting.api.inputoutput.bettinguserbet.getbyid;

import com.example.sportevents_betting.api.base.OperationResult;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetBettingUserBetByIdOutput implements OperationResult {

    private String bookmakerOfferId;
    private String betAmount;
    private String pickedTeam;
    private String bettingUserId;

}
