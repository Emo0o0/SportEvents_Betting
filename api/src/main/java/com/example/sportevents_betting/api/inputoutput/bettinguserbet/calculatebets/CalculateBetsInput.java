package com.example.sportevents_betting.api.inputoutput.bettinguserbet.calculatebets;

import com.example.sportevents_betting.api.base.OperationInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalculateBetsInput implements OperationInput {

    private String eventId;
    private int teamWon;

}
