package com.gopal.portfolio.model;

import java.util.List;

public record RoleEntry(
        String title,
        String organization,
        String period,
        List<String> highlights
) {
}
