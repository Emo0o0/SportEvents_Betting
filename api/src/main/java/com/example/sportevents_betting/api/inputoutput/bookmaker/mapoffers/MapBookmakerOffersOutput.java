package com.example.sportevents_betting.api.inputoutput.bookmaker.mapoffers;

import com.example.sportevents_betting.api.base.OperationResult;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MapBookmakerOffersOutput implements OperationResult {

    private String id;
    private String eventId;
    private String odds;

}
