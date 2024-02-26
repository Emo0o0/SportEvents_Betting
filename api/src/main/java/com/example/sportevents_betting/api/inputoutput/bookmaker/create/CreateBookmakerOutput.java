package com.example.sportevents_betting.api.inputoutput.bookmaker.create;

import com.example.sportevents_betting.api.base.OperationResult;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookmakerOutput implements OperationResult {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Boolean success;

}
