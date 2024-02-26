package com.example.sportevents_betting.api.inputoutput.bookmaker.mapoffers;

import com.example.sportevents_betting.api.base.OperationInput;
import com.example.sportevents_betting.persistence.entities.BookmakerOffer;
import lombok.*;

import java.util.Set;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MapBookmakerOffersInput implements OperationInput {

    private Set<BookmakerOffer> bookmakerOffers;

}
