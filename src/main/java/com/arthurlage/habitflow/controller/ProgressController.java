package com.arthurlage.habitflow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/progress")
@RestController
public class ProgressController {
    @GetMapping
    public String getProgress() {
        return "hello progress";
    }
}
