package com.gopal.portfolio.model;

import java.util.List;

public record SkillCategory(
        String name,
        List<String> items
) {
}
