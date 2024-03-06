package com.example.sportevents_betting.api.inputoutput.bettinguser.getall;

import com.example.sportevents_betting.api.inputoutput.bettinguser.mapbets.MapBettingUserBetsOutput;
import lombok.*;

import java.util.Set;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllBettingUsersOutput {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Set<MapBettingUserBetsOutput> bets;

}
