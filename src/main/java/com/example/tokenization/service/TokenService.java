package com.example.tokenization.service;

import com.example.tokenization.model.TokenEntity;
import com.example.tokenization.repository.TokenRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TokenService {

    private final TokenRepository repository;

    public TokenService(TokenRepository repository) {
        this.repository = repository;
    }

    // TOKENIZE: accounts tokens
    public List<String> tokenize(List<String> accounts) {

        return accounts.stream().map(acc -> {

            String token = UUID.randomUUID()
                    .toString()
                    .replace("-", "");

            repository.save(new TokenEntity(token, acc));

            return token;

        }).toList();
    }

    // DETOKENIZE: tokens → accounts
    public List<String> detokenize(List<String> tokens) {

        return tokens.stream()
                .map(token -> repository.findById(token)
                        .map(TokenEntity::getAccountNumber)
                        .orElse("NOT_FOUND"))
                .toList();
    }
}