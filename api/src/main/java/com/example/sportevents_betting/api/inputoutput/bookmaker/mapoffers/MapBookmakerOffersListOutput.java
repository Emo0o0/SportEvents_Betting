package com.example.sportevents_betting.api.inputoutput.bookmaker.mapoffers;

import com.example.sportevents_betting.api.base.OperationResult;
import lombok.*;

import java.util.Set;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MapBookmakerOffersListOutput implements OperationResult {

    private Set<MapBookmakerOffersOutput> bookmakerOffers;

}
