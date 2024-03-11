package com.example.sportevents_betting.api.inputoutput.bettinguserbet.getbyuser;

import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllBettingUserBetsByUserOutput {

    private String bookmakerOfferId;
    private String betAmount;
    private String pickedTeam;
    private String bettingUserId;

}
