package com.example.sportevents_betting.api.inputoutput.bettinguser.edit;

import com.example.sportevents_betting.api.base.OperationResult;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditBettingUserOutput implements OperationResult {

    private String firstName;
    private String lastName;
    private String email;

}
