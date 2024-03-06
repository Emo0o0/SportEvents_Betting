package com.example.sportevents_betting.api.inputoutput.bettinguser.edit;

import com.example.sportevents_betting.api.base.OperationInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditBettingUserInput implements OperationInput {

    private String id;
    private String firstName;
    private String lastName;
    private String email;

}
