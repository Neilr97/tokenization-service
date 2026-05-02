package com.example.tokenization.repository;

import com.example.tokenization.model.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<TokenEntity, String> {
}