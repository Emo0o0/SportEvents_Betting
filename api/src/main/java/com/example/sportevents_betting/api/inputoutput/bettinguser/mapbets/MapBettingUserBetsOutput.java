package com.example.sportevents_betting.api.inputoutput.bettinguser.mapbets;

import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MapBettingUserBetsOutput {

    private String betId;
    private String bookmakerOfferId;
    private String betAmount;
    private String pickedTeam;

}
