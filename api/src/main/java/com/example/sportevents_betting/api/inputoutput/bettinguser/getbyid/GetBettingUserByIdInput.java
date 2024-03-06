package com.example.sportevents_betting.api.inputoutput.bettinguser.getbyid;

import com.example.sportevents_betting.api.base.OperationInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetBettingUserByIdInput implements OperationInput {

    private String id;

}
