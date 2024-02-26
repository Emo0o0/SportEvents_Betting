package com.example.sportevents_betting.api.inputoutput.bookmaker.delete;

import com.example.sportevents_betting.api.base.OperationInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteBookmakerInput implements OperationInput {

    private String id;
    private String password;

}
