package com.example.sportevents_betting.rest.controllers;


import lombok.RequiredArgsConstructor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hello")
@EnableAsync
public class Hello {

    @Async
    @Scheduled(fixedRate = 5000)
    @GetMapping("/hi")
    public void hi() throws IOException {

        try {
            FileWriter myWriter = new FileWriter("file.txt");
            myWriter.write("b");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


}
