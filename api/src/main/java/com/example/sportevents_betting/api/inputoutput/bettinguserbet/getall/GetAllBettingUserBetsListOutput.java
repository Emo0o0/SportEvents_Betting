package com.example.sportevents_betting.api.inputoutput.bettinguserbet.getall;

import com.example.sportevents_betting.api.base.OperationResult;
import lombok.*;

import java.util.List;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllBettingUserBetsListOutput implements OperationResult {

    private List<GetAllBettingUserBetsOutput> bets;

}
