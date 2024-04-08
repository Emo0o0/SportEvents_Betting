package com.example.sportevents_betting.api.inputoutput.log.add;

import com.example.sportevents_betting.api.base.OperationInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddLogInput implements OperationInput {

    private String logMessage;

}
