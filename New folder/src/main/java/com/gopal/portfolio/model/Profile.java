package com.gopal.portfolio.model;

public record Profile(
        String name,
        String title,
        String university,
        String location,
        String email,
        String phone,
        String linkedin,
        String resumePath
) {
}
