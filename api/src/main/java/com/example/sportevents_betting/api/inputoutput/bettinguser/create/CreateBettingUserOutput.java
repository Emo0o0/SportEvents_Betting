package com.example.sportevents_betting.api.inputoutput.bettinguser.create;

import com.example.sportevents_betting.api.base.OperationResult;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBettingUserOutput implements OperationResult {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
