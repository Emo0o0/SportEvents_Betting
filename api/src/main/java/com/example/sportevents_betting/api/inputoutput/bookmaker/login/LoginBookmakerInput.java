package com.example.sportevents_betting.api.inputoutput.bookmaker.login;

import com.example.sportevents_betting.api.base.OperationInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginBookmakerInput implements OperationInput {

    private String email;
    private String password;

}
