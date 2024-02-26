package com.example.sportevents_betting.api.inputoutput.bookmaker.delete;

import com.example.sportevents_betting.api.base.OperationResult;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteBookmakerOutput implements OperationResult {

    private Boolean success;

}
