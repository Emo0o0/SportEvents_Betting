package com.example.sportevents_betting.api.inputoutput.bookmaker.getall;

import com.example.sportevents_betting.api.base.OperationInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllBookmakersInput implements OperationInput {

    private String pageNumber;
    private String itemsPerPage;

}
