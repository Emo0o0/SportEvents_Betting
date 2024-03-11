package com.example.sportevents_betting.rest.controllers;

import com.example.sportevents_betting.api.inputoutput.bettinguserbet.create.CreateBettingUserBetInput;
import com.example.sportevents_betting.api.inputoutput.bettinguserbet.create.CreateBettingUserBetOperation;
import com.example.sportevents_betting.api.inputoutput.bettinguserbet.create.CreateBettingUserBetOutput;
import com.example.sportevents_betting.api.inputoutput.bettinguserbet.getall.GetAllBettingUserBetsInput;
import com.example.sportevents_betting.api.inputoutput.bettinguserbet.getall.GetAllBettingUserBetsListOutput;
import com.example.sportevents_betting.api.inputoutput.bettinguserbet.getall.GetAllBettingUserBetsOperation;
import com.example.sportevents_betting.api.inputoutput.bettinguserbet.getbyid.GetBettingUserBetByIdInput;
import com.example.sportevents_betting.api.inputoutput.bettinguserbet.getbyid.GetBettingUserBetByIdOperation;
import com.example.sportevents_betting.api.inputoutput.bettinguserbet.getbyid.GetBettingUserBetByIdOutput;
import com.example.sportevents_betting.api.inputoutput.bettinguserbet.getbyuser.GetAllBettingUserBetsByUserInput;
import com.example.sportevents_betting.api.inputoutput.bettinguserbet.getbyuser.GetAllBettingUserBetsByUserListOutput;
import com.example.sportevents_betting.api.inputoutput.bettinguserbet.getbyuser.GetAllBettingUserBetsByUserOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bettingUserBets")
@RequiredArgsConstructor
public class BettingUserBetController {

    private final CreateBettingUserBetOperation createBettingUserBetOperation;
    private final GetAllBettingUserBetsOperation getAllBettingUserBetsOperation;
    private final GetBettingUserBetByIdOperation getBettingUserBetByIdOperation;
    private final GetAllBettingUserBetsByUserOperation getAllBettingUserBetsByUserOperation;

    @PostMapping("/placeBet")
    public ResponseEntity<CreateBettingUserBetOutput> createBet(@RequestBody CreateBettingUserBetInput input) {
        return ResponseEntity.status(201).body(createBettingUserBetOperation.process(input));
    }

    @GetMapping("/getAll")
    public ResponseEntity<GetAllBettingUserBetsListOutput> getAllBets(
            @RequestParam String pageNumber,
            @RequestParam String itemsPerPage) {
        GetAllBettingUserBetsInput input = GetAllBettingUserBetsInput.builder()
                .pageNumber(pageNumber)
                .itemsPerPage(itemsPerPage)
                .build();
        return ResponseEntity.status(200).body(getAllBettingUserBetsOperation.process(input));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<GetBettingUserBetByIdOutput> getBetById(@PathVariable String id) {
        GetBettingUserBetByIdInput input = GetBettingUserBetByIdInput.builder()
                .id(id)
                .build();
        return ResponseEntity.status(200).body(getBettingUserBetByIdOperation.process(input));
    }

    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity<GetAllBettingUserBetsByUserListOutput> getAllByUser(@PathVariable String userId) {
        GetAllBettingUserBetsByUserInput input = GetAllBettingUserBetsByUserInput.builder()
                .bettingUserId(userId)
                .build();
        return ResponseEntity.status(200).body(getAllBettingUserBetsByUserOperation.process(input));
    }
}
