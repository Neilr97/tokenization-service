package com.example.tokenization;

import com.example.tokenization.model.TokenEntity;
import com.example.tokenization.repository.TokenRepository;
import com.example.tokenization.service.TokenService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TokenServiceTest {

    private final TokenRepository repository = Mockito.mock(TokenRepository.class);
    private final TokenService service = new TokenService(repository);

    @Test
    void testTokenize_shouldReturnTokens() {

        // given
        List<String> accounts = List.of(
                "4111-1111-1111-1111",
                "4444-3333-2222-1111"
        );

        when(repository.save(any(TokenEntity.class)))
                .thenAnswer(invocation -> (TokenEntity) invocation.getArgument(0));

        // when
        List<String> tokens = service.tokenize(accounts);

        // then
        assertNotNull(tokens);
        assertEquals(2, tokens.size());
        assertNotEquals(tokens.get(0), tokens.get(1));

        verify(repository, times(2)).save(any(TokenEntity.class));
    }

    @Test
    void testDetokenize_shouldReturnOriginalAccounts() {

        // given
        String token = "token123";
        TokenEntity entity = new TokenEntity(token, "4111-1111-1111-1111");

        when(repository.findById(token))
                .thenReturn(Optional.of(entity));

        // when
        List<String> result = service.detokenize(List.of(token));

        // then
        assertEquals(1, result.size());
        assertEquals("4111-1111-1111-1111", result.get(0));
    }

    @Test
    void testDetokenize_shouldReturnNotFound() {

        // given
        when(repository.findById("invalid-token"))
                .thenReturn(Optional.empty());

        // when
        List<String> result = service.detokenize(List.of("invalid-token"));

        // then
        assertEquals("NOT_FOUND", result.get(0));
    }
}