package com.example.sportevents_betting.rest.controllers;

import com.example.sportevents_betting.api.inputoutput.bettinguser.create.CreateBettingUserInput;
import com.example.sportevents_betting.api.inputoutput.bettinguser.create.CreateBettingUserOperation;
import com.example.sportevents_betting.api.inputoutput.bettinguser.create.CreateBettingUserOutput;
import com.example.sportevents_betting.api.inputoutput.bettinguser.delete.DeleteBettingUserInput;
import com.example.sportevents_betting.api.inputoutput.bettinguser.delete.DeleteBettingUserOperation;
import com.example.sportevents_betting.api.inputoutput.bettinguser.delete.DeleteBettingUserOutput;
import com.example.sportevents_betting.api.inputoutput.bettinguser.edit.EditBettingUserInput;
import com.example.sportevents_betting.api.inputoutput.bettinguser.edit.EditBettingUserOperation;
import com.example.sportevents_betting.api.inputoutput.bettinguser.edit.EditBettingUserOutput;
import com.example.sportevents_betting.api.inputoutput.bettinguser.getall.GetAllBettingUsersInput;
import com.example.sportevents_betting.api.inputoutput.bettinguser.getall.GetAllBettingUsersListOutput;
import com.example.sportevents_betting.api.inputoutput.bettinguser.getall.GetAllBettingUsersOperation;
import com.example.sportevents_betting.api.inputoutput.bettinguser.getbyid.GetBettingUserByIdInput;
import com.example.sportevents_betting.api.inputoutput.bettinguser.getbyid.GetBettingUserByIdOperation;
import com.example.sportevents_betting.api.inputoutput.bettinguser.getbyid.GetBettingUserByIdOutput;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bettinguser")
@RequiredArgsConstructor
public class BettingUserController {

    private final CreateBettingUserOperation createBettingUserOperation;
    private final DeleteBettingUserOperation deleteBettingUserOperation;
    private final EditBettingUserOperation editBettingUserOperation;
    private final GetBettingUserByIdOperation getBettingUserByIdOperation;
    private final GetAllBettingUsersOperation getAllBettingUsersOperation;

    @PostMapping
    public ResponseEntity<CreateBettingUserOutput> createBettingUser(@Valid @RequestBody CreateBettingUserInput input) {
        return ResponseEntity.status(201).body(createBettingUserOperation.process(input));
    }

    @DeleteMapping
    public ResponseEntity<DeleteBettingUserOutput> deleteBettingUser(@RequestBody DeleteBettingUserInput input) {
        return ResponseEntity.status(200).body(deleteBettingUserOperation.process(input));
    }

    @PatchMapping
    public ResponseEntity<EditBettingUserOutput> editBettingUser(@RequestBody EditBettingUserInput input) {
        return ResponseEntity.status(200).body(editBettingUserOperation.process(input));
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<GetBettingUserByIdOutput> getBettingUserById(@PathVariable String id) {

        GetBettingUserByIdInput input = GetBettingUserByIdInput.builder()
                .id(id)
                .build();
        return ResponseEntity.status(200).body(getBettingUserByIdOperation.process(input));
    }

    @GetMapping("getAll")
    public ResponseEntity<GetAllBettingUsersListOutput> getAllBettingUsers(
            @RequestParam String pageNumber,
            @RequestParam String itemsPerPage) {

        GetAllBettingUsersInput input = GetAllBettingUsersInput.builder()
                .pageNumber(pageNumber)
                .itemsPerPage(itemsPerPage)
                .build();
        return ResponseEntity.status(200).body(getAllBettingUsersOperation.process(input));
    }

}
