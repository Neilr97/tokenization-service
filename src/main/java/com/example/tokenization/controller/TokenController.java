package com.example.tokenization.controller;

import com.example.tokenization.service.TokenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TokenController {

    private final TokenService service;

    public TokenController(TokenService service) {
        this.service = service;
    }

    @PostMapping("/tokenize")
    public List<String> tokenize(@RequestBody List<String> accounts) {
        return service.tokenize(accounts);
    }

    @PostMapping("/detokenize")
    public List<String> detokenize(@RequestBody List<String> tokens) {
        return service.detokenize(tokens);
    }
}