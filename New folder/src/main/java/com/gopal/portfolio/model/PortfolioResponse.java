package com.gopal.portfolio.model;

import java.util.List;

public record PortfolioResponse(
        Profile profile,
        String tagline,
        String overview,
        List<String> focusAreas,
        List<Metric> metrics,
        List<EducationEntry> education,
        List<ProjectEntry> projects,
        List<RoleEntry> roles,
        List<String> achievements,
        List<SkillCategory> skills,
        List<String> certifications
) {
}
