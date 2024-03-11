package com.example.sportevents_betting.api.inputoutput.bettinguserbet.create;

import com.example.sportevents_betting.api.base.OperationResult;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBettingUserBetOutput implements OperationResult {


    private String id;
    private String bookmakerOfferId;
    private String betAmount;
    private String pickedTeam;
    private String bettingUserId;

}
