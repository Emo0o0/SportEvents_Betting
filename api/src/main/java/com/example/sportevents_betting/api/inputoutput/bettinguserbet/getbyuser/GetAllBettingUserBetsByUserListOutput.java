package com.example.sportevents_betting.api.inputoutput.bettinguserbet.getbyuser;

import com.example.sportevents_betting.api.base.OperationResult;
import lombok.*;

import java.util.List;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllBettingUserBetsByUserListOutput implements OperationResult {

    private List<GetAllBettingUserBetsByUserOutput> bets;

}
