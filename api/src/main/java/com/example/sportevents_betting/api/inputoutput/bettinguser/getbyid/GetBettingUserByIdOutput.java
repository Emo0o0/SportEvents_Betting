package com.example.sportevents_betting.api.inputoutput.bettinguser.getbyid;

import com.example.sportevents_betting.api.base.OperationResult;
import com.example.sportevents_betting.api.inputoutput.bookmaker.mapoffers.MapBookmakerOffersOutput;
import lombok.*;

import java.util.Set;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetBettingUserByIdOutput implements OperationResult {


    private String firstName;
    private String lastName;
    private String email;
    private Set<MapBookmakerOffersOutput> bets;
}
