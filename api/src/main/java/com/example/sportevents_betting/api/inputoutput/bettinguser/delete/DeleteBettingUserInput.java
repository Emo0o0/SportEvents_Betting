package com.example.sportevents_betting.api.inputoutput.bettinguser.delete;

import com.example.sportevents_betting.api.base.OperationInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteBettingUserInput implements OperationInput {

    private String id;

}
