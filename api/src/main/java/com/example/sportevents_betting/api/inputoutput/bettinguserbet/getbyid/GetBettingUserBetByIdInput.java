package com.example.sportevents_betting.api.inputoutput.bettinguserbet.getbyid;

import com.example.sportevents_betting.api.base.OperationInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetBettingUserBetByIdInput implements OperationInput {

    private String id;

}
