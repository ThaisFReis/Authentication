package com.authentication.controller;

import com.authentication.service.tokenService;
import com.authentication.model.tokenModel;

public class tokenController {
    private static tokenService tokenService;

    public tokenController() {
        tokenService = new tokenService();
    }

    public static tokenModel createToken(int user) throws Exception {
        tokenModel token = new tokenModel();
        tokenService.createToken(token, user);
        return token;
    }

    public boolean isTokenValid(int userId, String token) throws Exception {
        // Check if token is not expired
        tokenModel tokenModel = com.authentication.service.tokenService.getTokenByUserId(userId);
        if (tokenModel == null) {
            return false;
        }

        return tokenModel.getToken().equals(token);
    }

    public void deleteToken(int id) throws Exception {
        com.authentication.service.tokenService.deleteToken(id);
    }

    public tokenModel getTokenByUserId(int id) throws Exception {
        return com.authentication.service.tokenService.getTokenByUserId(id);
    }

    public tokenModel getTokenByToken(String token) throws Exception {
        return com.authentication.service.tokenService.getTokenByToken(token);
    }
}
