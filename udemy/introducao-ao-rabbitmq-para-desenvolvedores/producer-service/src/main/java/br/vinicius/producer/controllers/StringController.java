package br.vinicius.producer.controllers;

import br.vinicius.producer.services.StringService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/produces")
@RequiredArgsConstructor
public class StringController {

    private final StringService service;

    @PostMapping
    public ResponseEntity<String> produces(@RequestBody String message) {
        service.produce(message);
        return ResponseEntity.ok("Sending message");
    }
}
