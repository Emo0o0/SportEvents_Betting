package com.example.sportevents_betting.api.inputoutput.bookmaker.edit;

import com.example.sportevents_betting.api.base.OperationResult;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditBookmakerOutput implements OperationResult {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

}
