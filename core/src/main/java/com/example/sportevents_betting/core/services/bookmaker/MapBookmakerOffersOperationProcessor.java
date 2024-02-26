package com.example.sportevents_betting.core.services.bookmaker;

import com.example.sportevents_betting.api.inputoutput.bookmaker.mapoffers.MapBookmakerOffersInput;
import com.example.sportevents_betting.api.inputoutput.bookmaker.mapoffers.MapBookmakerOffersListOutput;
import com.example.sportevents_betting.api.inputoutput.bookmaker.mapoffers.MapBookmakerOffersOperation;
import com.example.sportevents_betting.api.inputoutput.bookmaker.mapoffers.MapBookmakerOffersOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MapBookmakerOffersOperationProcessor implements MapBookmakerOffersOperation {
    @Override
    public MapBookmakerOffersListOutput process(MapBookmakerOffersInput input) {

        Set<MapBookmakerOffersOutput> listOutput = input.getBookmakerOffers().stream()
                .map(bo -> MapBookmakerOffersOutput.builder()
                        .id(bo.getUuid().toString())
                        .eventId(bo.getEventId())
                        .odds(bo.getOdds())
                        .build())
                .collect(Collectors.toSet());

        return MapBookmakerOffersListOutput.builder()
                .bookmakerOffers(listOutput)
                .build();
    }
}
