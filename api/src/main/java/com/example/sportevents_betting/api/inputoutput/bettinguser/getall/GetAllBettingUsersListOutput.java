package com.example.sportevents_betting.api.inputoutput.bettinguser.getall;

import com.example.sportevents_betting.api.base.OperationResult;
import lombok.*;

import java.util.Set;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllBettingUsersListOutput implements OperationResult {

    private Set<GetAllBettingUsersOutput> users;

}
