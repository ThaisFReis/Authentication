package com.authentication.service;

import com.authentication.repository.tokenRepository;
import com.authentication.model.tokenModel;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.time.LocalDateTime;
import io.jsonwebtoken.JwtException;

public class tokenService {
    public void createToken (tokenModel token, int user) throws Exception {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String jwt = Jwts.builder()
                .setSubject(user.getEmail())
                .signWith(key)
                .compact();
        token.setToken(jwt);
        tokenRepository.createToken(token, user);
    }

    public boolean isTokenValid(int userId, String token) throws Exception {
        tokenModel userToken = getTokenByUserId(userId);

        if (userToken == null || userToken.getToken() == null || userToken.getToken().isEmpty()) {
            return false;
        }

        if (userToken.getExpiration().isBefore(LocalDateTime.now())) {
            return false;
        }

        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
        } catch (JwtException e) {
            return false;
        }

        return true;
    }

    public static void deleteToken(int id) throws Exception {
        tokenRepository.deleteToken(id);
    }

    public static tokenModel getTokenByUserId(int id) throws Exception {
        return tokenRepository.getTokenByUserId(id);
    }

    public static tokenModel getTokenByToken(String token) throws Exception {
        return tokenRepository.getTokenByToken(token);
    }
}
