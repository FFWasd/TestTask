package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MimimimetrController{
    private final Mimimimetr mimimimetr;

    public MimimimetrController(Mimimimetr mimimimetr) {
        this.mimimimetr = mimimimetr;
    }

    @GetMapping("/cats")
    public ArrayList<Cat> showCats() {
        return mimimimetr.getResult();
    }

    @GetMapping("/pair")
    public ArrayList<Cat> showCurrentPair() {
        return mimimimetr.getCurrentPair();
    }

    @PostMapping("/vote")
    public void vote(@RequestParam int choice) {
        mimimimetr.vote(choice);
    }
}