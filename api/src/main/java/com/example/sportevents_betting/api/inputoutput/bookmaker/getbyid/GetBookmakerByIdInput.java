package com.example.sportevents_betting.api.inputoutput.bookmaker.getbyid;

import com.example.sportevents_betting.api.base.OperationInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetBookmakerByIdInput implements OperationInput {

    private String id;

}
