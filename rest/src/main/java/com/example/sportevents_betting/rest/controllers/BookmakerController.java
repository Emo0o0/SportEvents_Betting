package com.example.sportevents_betting.rest.controllers;

import com.example.sportevents_betting.api.inputoutput.bookmaker.create.CreateBookmakerInput;
import com.example.sportevents_betting.api.inputoutput.bookmaker.create.CreateBookmakerOperation;
import com.example.sportevents_betting.api.inputoutput.bookmaker.create.CreateBookmakerOutput;
import com.example.sportevents_betting.api.inputoutput.bookmaker.delete.DeleteBookmakerInput;
import com.example.sportevents_betting.api.inputoutput.bookmaker.delete.DeleteBookmakerOperation;
import com.example.sportevents_betting.api.inputoutput.bookmaker.delete.DeleteBookmakerOutput;
import com.example.sportevents_betting.api.inputoutput.bookmaker.edit.EditBookmakerInput;
import com.example.sportevents_betting.api.inputoutput.bookmaker.edit.EditBookmakerOperation;
import com.example.sportevents_betting.api.inputoutput.bookmaker.edit.EditBookmakerOutput;
import com.example.sportevents_betting.api.inputoutput.bookmaker.getall.GetAllBookmakersInput;
import com.example.sportevents_betting.api.inputoutput.bookmaker.getall.GetAllBookmakersListOutput;
import com.example.sportevents_betting.api.inputoutput.bookmaker.getall.GetAllBookmakersOperation;
import com.example.sportevents_betting.api.inputoutput.bookmaker.getbyid.GetBookmakerByIdInput;
import com.example.sportevents_betting.api.inputoutput.bookmaker.getbyid.GetBookmakerByIdOperation;
import com.example.sportevents_betting.api.inputoutput.bookmaker.getbyid.GetBookmakerByIdOutput;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookmaker")
@RequiredArgsConstructor
public class BookmakerController {

    private final CreateBookmakerOperation createBookmakerOperation;
    private final DeleteBookmakerOperation deleteBookmakerOperation;
    private final EditBookmakerOperation editBookmakerOperation;
    private final GetAllBookmakersOperation getAllBookmakersOperation;
    private final GetBookmakerByIdOperation getBookmakerByIdOperation;


    @PostMapping(path = "/create")
    public ResponseEntity<CreateBookmakerOutput> createBookmaker(@Valid @RequestBody CreateBookmakerInput input) {
        return ResponseEntity.status(201).body(createBookmakerOperation.process(input));
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<DeleteBookmakerOutput> deleteBookmaker(@RequestBody DeleteBookmakerInput input) {
        return ResponseEntity.status(200).body(deleteBookmakerOperation.process(input));
    }

    @PatchMapping("/edit")
    public ResponseEntity<EditBookmakerOutput> editBookmaker(@RequestBody EditBookmakerInput input) {
        return ResponseEntity.status(200).body(editBookmakerOperation.process(input));
    }

    @GetMapping("/getById/{uuid}")
    public ResponseEntity<GetBookmakerByIdOutput> getBookmakerById(@PathVariable String uuid) {
        GetBookmakerByIdInput input = GetBookmakerByIdInput.builder()
                .id(uuid)
                .build();
        return ResponseEntity.status(200).body(getBookmakerByIdOperation.process(input));
    }

    @GetMapping("/getAll")
    public ResponseEntity<GetAllBookmakersListOutput> getAllBookmakers(
            @RequestParam String itemsPerPage,
            @RequestParam String pageNumber) {

        GetAllBookmakersInput input = GetAllBookmakersInput.builder()
                .itemsPerPage(itemsPerPage)
                .pageNumber(pageNumber)
                .build();
        return ResponseEntity.status(200).body(getAllBookmakersOperation.process(input));

    }


}
