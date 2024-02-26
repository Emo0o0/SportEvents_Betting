package com.example.sportevents_betting.api.inputoutput.bookmaker.edit;

import com.example.sportevents_betting.api.base.OperationInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditBookmakerInput implements OperationInput {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

}
