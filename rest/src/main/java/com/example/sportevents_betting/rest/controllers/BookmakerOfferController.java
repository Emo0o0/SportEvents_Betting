package com.example.sportevents_betting.rest.controllers;

import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.create.CreateBookmakerOfferInput;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.create.CreateBookmakerOfferOperation;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.create.CreateBookmakerOfferOutput;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.delete.DeleteBookmakerOfferInput;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.delete.DeleteBookmakerOfferOperation;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.delete.DeleteBookmakerOfferOutput;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.edit.EditBookmakerOfferInput;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.edit.EditBookmakerOfferOperation;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.edit.EditBookmakerOfferOutput;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getall.GetAllBookmakerOffersInput;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getall.GetAllBookmakerOffersListOutput;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getall.GetAllBookmakerOffersOperation;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getallbybookmaker.GetAllOffersByBookmakerInput;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getallbybookmaker.GetAllOffersByBookmakerListOutput;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getallbybookmaker.GetAllOffersByBookmakerOperation;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getbyid.GetBookmakerOfferByIdInput;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getbyid.GetBookmakerOfferByIdOperation;
import com.example.sportevents_betting.api.inputoutput.bookmakeroffer.getbyid.GetBookmakerOfferByIdOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookmakeroffer")
@RequiredArgsConstructor
public class BookmakerOfferController {

    private final CreateBookmakerOfferOperation createBookmakerOfferOperation;
    private final DeleteBookmakerOfferOperation deleteBookmakerOfferOperation;
    private final EditBookmakerOfferOperation editBookmakerOfferInput;
    private final GetAllBookmakerOffersOperation getAllBookmakerOffersOperation;
    private final GetBookmakerOfferByIdOperation getBookmakerOfferByIdOperation;
    private final GetAllOffersByBookmakerOperation getAllOffersByBookmakerOperation;


    @PostMapping("/createOffer")
    public ResponseEntity<CreateBookmakerOfferOutput> createBookmakerOffer(@RequestBody CreateBookmakerOfferInput input) {
        return ResponseEntity.status(201).body(createBookmakerOfferOperation.process(input));
    }

    @DeleteMapping("/deleteOffer")
    public ResponseEntity<DeleteBookmakerOfferOutput> deleteBookmakerOffer(@RequestBody DeleteBookmakerOfferInput input) {
        return ResponseEntity.status(200).body(deleteBookmakerOfferOperation.process(input));
    }

    @PatchMapping("/editOffer")
    public ResponseEntity<EditBookmakerOfferOutput> editBookmakerOffer(@RequestBody EditBookmakerOfferInput input) {
        return ResponseEntity.status(200).body(editBookmakerOfferInput.process(input));
    }

    @GetMapping("/getAll")
    public ResponseEntity<GetAllBookmakerOffersListOutput> getAllOffers(
            @RequestParam String pageNumber,
            @RequestParam String itemsPerPage) {
        GetAllBookmakerOffersInput input = GetAllBookmakerOffersInput.builder()
                .pageNumber(pageNumber)
                .itemsPerPage(itemsPerPage)
                .build();
        return ResponseEntity.status(200).body(getAllBookmakerOffersOperation.process(input));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<GetBookmakerOfferByIdOutput> getOfferById(@PathVariable String id) {
        GetBookmakerOfferByIdInput input = GetBookmakerOfferByIdInput.builder()
                .id(id)
                .build();
        return ResponseEntity.status(200).body(getBookmakerOfferByIdOperation.process(input));
    }

    @GetMapping("/getByBookmaker/{id}")
    public ResponseEntity<GetAllOffersByBookmakerListOutput> getOffersByBookmaker(@PathVariable String id) {
        GetAllOffersByBookmakerInput input = GetAllOffersByBookmakerInput.builder()
                .bookmakerId(id)
                .build();
        return ResponseEntity.status(200).body(getAllOffersByBookmakerOperation.process(input));
    }

}
