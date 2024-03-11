package com.example.sportevents_betting.api.inputoutput.bettinguserbet.getall;

import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllBettingUserBetsOutput {

    private String bookmakerOfferId;
    private String betAmount;
    private String pickedTeam;
    private String bettingUserId;

}
