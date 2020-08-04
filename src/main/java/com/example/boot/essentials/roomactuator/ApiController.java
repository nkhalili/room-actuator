package com.example.boot.essentials.roomactuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class ApiController {
    private final PresidentRepository presidentRepository;

    @Autowired
    public ApiController(PresidentRepository presidentRepository) {
        this.presidentRepository = presidentRepository;
    }

    @GetMapping("greeting")
    public String getGreeting() {return "Hello there!";}

    @GetMapping("presidents")
    public List<President> getAllPresidents(){
        List<President> presidents = new ArrayList<>();
        this.presidentRepository.findAll().forEach(presidents::add);
        return presidents;
    }
}
