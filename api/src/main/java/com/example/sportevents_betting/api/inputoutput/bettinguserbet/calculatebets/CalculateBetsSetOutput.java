package com.example.sportevents_betting.api.inputoutput.bettinguserbet.calculatebets;

import com.example.sportevents_betting.api.base.OperationResult;
import lombok.*;

import java.util.Set;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalculateBetsSetOutput implements OperationResult {

    private Set<CalculateBetsOutput> betResults;
}
