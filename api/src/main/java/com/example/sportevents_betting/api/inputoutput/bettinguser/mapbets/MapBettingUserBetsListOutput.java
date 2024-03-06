package com.example.sportevents_betting.api.inputoutput.bettinguser.mapbets;

import com.example.sportevents_betting.api.base.OperationResult;
import lombok.*;

import java.util.Set;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MapBettingUserBetsListOutput implements OperationResult {

    private Set<MapBettingUserBetsOutput> mappedBets;

}
