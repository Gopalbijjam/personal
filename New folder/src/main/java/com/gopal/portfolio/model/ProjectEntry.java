package com.gopal.portfolio.model;

import java.util.List;

public record ProjectEntry(
        String name,
        String period,
        String role,
        String summary,
        List<String> stack,
        List<String> highlights
) {
}
