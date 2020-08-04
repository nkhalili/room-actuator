package com.example.boot.essentials.roomactuator;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
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
    private final Counter greetingCounter;

    @Autowired
    public ApiController(PresidentRepository presidentRepository, MeterRegistry registry) {

        this.presidentRepository = presidentRepository;
        this.greetingCounter = Counter.builder("api.greeting").register(registry);
    }

    @GetMapping("greeting")
    public String getGreeting() {
        greetingCounter.increment();
        return "Hello there!";
    }

    @GetMapping("presidents")
    @Timed(value="api.getAllPresidents")
    public List<President> getAllPresidents(){
        List<President> presidents = new ArrayList<>();
        this.presidentRepository.findAll().forEach(presidents::add);
        return presidents;
    }
}
