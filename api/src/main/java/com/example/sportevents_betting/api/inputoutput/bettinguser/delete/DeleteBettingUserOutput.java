package com.example.sportevents_betting.api.inputoutput.bettinguser.delete;

import com.example.sportevents_betting.api.base.OperationResult;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteBettingUserOutput implements OperationResult {

    private Boolean success;

}
