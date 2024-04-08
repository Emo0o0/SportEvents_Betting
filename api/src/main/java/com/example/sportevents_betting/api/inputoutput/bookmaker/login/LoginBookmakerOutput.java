package com.example.sportevents_betting.api.inputoutput.bookmaker.login;

import com.example.sportevents_betting.api.base.OperationResult;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginBookmakerOutput implements OperationResult {

    private String jwt;

}
