package com.gopal.portfolio.service;

import com.gopal.portfolio.model.EducationEntry;
import com.gopal.portfolio.model.Metric;
import com.gopal.portfolio.model.PortfolioResponse;
import com.gopal.portfolio.model.Profile;
import com.gopal.portfolio.model.ProjectEntry;
import com.gopal.portfolio.model.RoleEntry;
import com.gopal.portfolio.model.SkillCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

    public PortfolioResponse getPortfolio() {
        return new PortfolioResponse(
                new Profile(
                        "Bijjam Gopal Reddy",
                        "Senior Undergraduate | Java Full-Stack Developer",
                        "Mohan Babu University",
                        "India",
                        "gopalreddybijjam846@gmail.com",
                        "+91-9346794329",
                        "https://linkedin.com/in/bijjam-gopal",
                        "/assets/resume-gopi.pdf"
                ),
                "Building student-focused digital products with Java, Spring Boot, JDBC, and cloud-backed workflows.",
                "I am a Computer Science undergraduate who enjoys turning real-world ideas into usable software. "
                        + "My work blends reliable backend engineering, practical database design, and clean user experiences, "
                        + "with a special interest in Java full-stack development, collaborative product building, and student-centered tools.",
                List.of(
                        "Java and Spring Boot application development",
                        "REST APIs, JDBC workflows, and MySQL persistence",
                        "Cloud-backed student products with Firebase integrations",
                        "Team-oriented full-stack delivery from concept to deployment"
                ),
                List.of(
                        new Metric("9.69", "Current CGPA", "B.Tech in Computer Science and Engineering at Mohan Babu University"),
                        new Metric("1000+", "Students Reached", "SARA-AI adoption achieved after deployment with Firebase-backed services"),
                        new Metric("220+", "DSA Problems Solved", "Practiced in Java on LeetCode to strengthen problem-solving depth"),
                        new Metric("2", "Featured Projects", "Resume-highlighted projects spanning web applications and Java database systems")
                ),
                List.of(
                        new EducationEntry(
                                "B.Tech",
                                "Computer Science and Engineering",
                                "Mohan Babu University",
                                "2022 - Present",
                                "9.69 CGPA"
                        ),
                        new EducationEntry(
                                "BIEAP",
                                "Physics, Chemistry, and Mathematics",
                                "Sri Chaitanya College",
                                "2022",
                                "942"
                        ),
                        new EducationEntry(
                                "SSC",
                                "State Board",
                                "Sri Chaitanya School",
                                "2020",
                                "597"
                        )
                ),
                List.of(
                        new ProjectEntry(
                                "Smart Academic Resource Assistant (SARA-AI)",
                                "April 2025",
                                "Backend-focused contributor in a six-member team",
                                "A full-stack student platform that combines academic resources, related videos, and mental-health chatbot support to improve everyday learning.",
                                List.of("HTML", "CSS", "JavaScript", "TypeScript", "Node.js", "Firebase"),
                                List.of(
                                        "Developed a full-stack learning application centered on student success, with subject PDFs, related video support, and guided assistance.",
                                        "Handled key backend responsibilities with Firebase for authentication, database access, and cloud-connected application flows.",
                                        "Contributed to mental-health chatbot integration so the product supported both academic and emotional wellbeing.",
                                        "Helped deploy the platform to a user base of more than 1000 active students."
                                )
                        ),
                        new ProjectEntry(
                                "Cricket Auction Website",
                                "January 2025",
                                "Java developer",
                                "A Java-based auction system that simulates buyer and seller activity with secure login, product listings, bid tracking, and persistence through MySQL.",
                                List.of("Java", "JDBC", "MySQL"),
                                List.of(
                                        "Built user registration, secure login, and password-recovery workflows for a console-driven auction system.",
                                        "Implemented buyer and seller actions including adding products, viewing listings, placing bids, and tracking highest bids.",
                                        "Used JDBC and MySQL for CRUD operations, prepared statements, and transaction-oriented finalization logic."
                                )
                        )
                ),
                List.of(
                        new RoleEntry(
                                "IEEE Student Branch Member",
                                "IEEE Mohan Babu University, Hyderabad Section",
                                "January 2025 - Present",
                                List.of(
                                        "Participated in professional development, networking, and technical events under IEEE.",
                                        "Worked with fellow engineering students on workshops, webinars, hackathons, and innovation-focused activities.",
                                        "Strengthened leadership, teamwork, and communication through community and technical engagement."
                                )
                        )
                ),
                List.of(
                        "Secured a participation certificate from Google Solution Challenge 2024.",
                        "Participated in the internal SIH 2024 hackathon.",
                        "Solved 220+ DSA problems in Java on LeetCode.",
                        "Earned the 50-day LeetCode badge."
                ),
                List.of(
                        new SkillCategory("Languages", List.of("Java", "Python", "C++")),
                        new SkillCategory("Web Technologies", List.of("Spring Boot", "HTML", "CSS", "JavaScript", "Node.js", "Firebase")),
                        new SkillCategory("Database", List.of("MySQL", "JDBC")),
                        new SkillCategory("Cloud", List.of("Google Cloud", "AWS")),
                        new SkillCategory("Tools", List.of("Figma", "VS Code", "Eclipse"))
                ),
                List.of(
                        "Full-Stack Web Development - Udemy",
                        "Basic Java - HackerRank"
                )
        );
    }
}
