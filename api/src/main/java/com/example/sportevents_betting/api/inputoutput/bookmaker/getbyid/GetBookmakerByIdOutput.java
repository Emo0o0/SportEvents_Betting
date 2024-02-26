package com.example.sportevents_betting.api.inputoutput.bookmaker.getbyid;

import com.example.sportevents_betting.api.base.OperationResult;
import com.example.sportevents_betting.api.inputoutput.bookmaker.mapoffers.MapBookmakerOffersOutput;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetBookmakerByIdOutput implements OperationResult {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Set<MapBookmakerOffersOutput> bookmakerOffers;

}
