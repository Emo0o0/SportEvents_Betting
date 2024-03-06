package com.example.sportevents_betting.api.inputoutput.bettinguser.getall;

import com.example.sportevents_betting.api.base.OperationInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllBettingUsersInput implements OperationInput {

    private String pageNumber;
    private String itemsPerPage;

}
