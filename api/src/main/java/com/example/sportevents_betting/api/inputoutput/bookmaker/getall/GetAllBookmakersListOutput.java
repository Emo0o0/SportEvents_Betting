package com.example.sportevents_betting.api.inputoutput.bookmaker.getall;

import com.example.sportevents_betting.api.base.OperationResult;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllBookmakersListOutput implements OperationResult {

    private List<GetAllBookmakersOutput> bookmakers;

}
