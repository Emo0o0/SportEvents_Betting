package com.example.sportevents_betting.core.services.bookmaker;

import com.example.sportevents_betting.api.inputoutput.bookmaker.getall.GetAllBookmakersInput;
import com.example.sportevents_betting.api.inputoutput.bookmaker.getall.GetAllBookmakersListOutput;
import com.example.sportevents_betting.api.inputoutput.bookmaker.getall.GetAllBookmakersOperation;
import com.example.sportevents_betting.api.inputoutput.bookmaker.getall.GetAllBookmakersOutput;
import com.example.sportevents_betting.api.inputoutput.bookmaker.mapoffers.MapBookmakerOffersInput;
import com.example.sportevents_betting.api.inputoutput.bookmaker.mapoffers.MapBookmakerOffersOperation;
import com.example.sportevents_betting.persistence.entities.Bookmaker;
import com.example.sportevents_betting.persistence.repositories.BookmakerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetAllBookmakersOperationProcessor implements GetAllBookmakersOperation {

    private final BookmakerRepository bookmakerRepository;
    private final MapBookmakerOffersOperation mapBookmakerOffersOperation;

    @Override
    public GetAllBookmakersListOutput process(GetAllBookmakersInput input) {


        PageRequest pageRequest = PageRequest.of(Integer.parseInt(input.getPageNumber()) - 1, Integer.parseInt(input.getItemsPerPage()));

        List<GetAllBookmakersOutput> outputList = bookmakerRepository.findAll(pageRequest).stream()
                .map(bm -> GetAllBookmakersOutput.builder()
                        .id(bm.getId())
                        .firstName(bm.getFirstName())
                        .lastName(bm.getLastName())
                        .email(bm.getEmail())
                        .phone(bm.getPhone())
                        .bookmakerOffers(mapBookmakerOffersOperation.process(
                                        MapBookmakerOffersInput.builder()
                                                .bookmakerOffers(bm.getBookmakerOffers())
                                                .build())
                                .getBookmakerOffers())
                        .build())
                .collect(Collectors.toList());

        return GetAllBookmakersListOutput.builder()
                .bookmakers(outputList)
                .build();

    }
}
