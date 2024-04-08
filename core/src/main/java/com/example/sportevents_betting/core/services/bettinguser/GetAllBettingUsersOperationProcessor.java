package com.example.sportevents_betting.core.services.bettinguser;

import com.example.sportevents_betting.api.inputoutput.bettinguser.getall.GetAllBettingUsersInput;
import com.example.sportevents_betting.api.inputoutput.bettinguser.getall.GetAllBettingUsersListOutput;
import com.example.sportevents_betting.api.inputoutput.bettinguser.getall.GetAllBettingUsersOperation;
import com.example.sportevents_betting.api.inputoutput.bettinguser.getall.GetAllBettingUsersOutput;
import com.example.sportevents_betting.api.inputoutput.bettinguser.mapbets.MapBettingUserBetsInput;
import com.example.sportevents_betting.api.inputoutput.bettinguser.mapbets.MapBettingUserBetsOperation;
import com.example.sportevents_betting.api.inputoutput.log.add.AddLogInput;
import com.example.sportevents_betting.api.inputoutput.log.add.AddLogOperation;
import com.example.sportevents_betting.persistence.repositories.BettingUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetAllBettingUsersOperationProcessor implements GetAllBettingUsersOperation {

    private final BettingUserRepository bettingUserRepository;
    private final MapBettingUserBetsOperation mapBettingUserBetsOperation;
    private final AddLogOperation addLogOperation;

    @Override
    public GetAllBettingUsersListOutput process(GetAllBettingUsersInput input) {

        PageRequest pageRequest = PageRequest.of(Integer.parseInt(input.getPageNumber()) - 1, Integer.parseInt(input.getItemsPerPage()));

        Set<GetAllBettingUsersOutput> outputSet = bettingUserRepository.findAll(pageRequest).stream()
                .map(bu -> GetAllBettingUsersOutput.builder()
                        .id(bu.getId().toString())
                        .firstName(bu.getFirstName())
                        .lastName(bu.getLastName())
                        .email(bu.getEmail())
                        .bets(new HashSet<>(mapBettingUserBetsOperation.process(MapBettingUserBetsInput.builder()
                                        .bets(bu.getBets())
                                        .build())
                                .getMappedBets()))
                        .build())
                .collect(Collectors.toSet());

        addLogOperation.process(AddLogInput.builder()
                .logMessage("Request to get all betting users was made")
                .build());

        return GetAllBettingUsersListOutput.builder()
                .users(outputSet)
                .build();

    }
}
