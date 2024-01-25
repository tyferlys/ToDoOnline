package com.example.todoonline.responses;

public class AuthResponse {
    private String codeAuth;

    public AuthResponse(String codeAuth) {
        this.codeAuth = codeAuth;
    }

    public String getCodeAuth() {
        return codeAuth;
    }

    public void setCodeAuth(String codeAuth) {
        this.codeAuth = codeAuth;
    }
}
