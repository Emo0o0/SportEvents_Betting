package com.example.sportevents_betting.api.inputoutput.log.add;

import com.example.sportevents_betting.api.base.OperationResult;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddLogOutput implements OperationResult {

    private String id;
    private String logMessage;
    private String timestamp;

}
