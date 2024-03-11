package com.example.sportevents_betting.api.inputoutput.bettinguserbet.getbyuser;

import com.example.sportevents_betting.api.base.OperationInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllBettingUserBetsByUserInput implements OperationInput {

    private String bettingUserId;


}
