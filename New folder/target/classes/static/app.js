const appState = {
    data: null
};

async function loadPortfolio() {
    const response = await fetch("/api/portfolio");

    if (!response.ok) {
        throw new Error("Unable to load portfolio data.");
    }

    return response.json();
}

function escapeHtml(value) {
    return value
        .replaceAll("&", "&amp;")
        .replaceAll("<", "&lt;")
        .replaceAll(">", "&gt;")
        .replaceAll('"', "&quot;")
        .replaceAll("'", "&#39;");
}

function renderActionLinks(profile) {
    return `
        <a class="action-link primary" href="${profile.resumePath}" target="_blank" rel="noreferrer">View Resume</a>
        <a class="action-link" href="mailto:${profile.email}">Email Me</a>
        <a class="action-link" href="${profile.linkedin}" target="_blank" rel="noreferrer">LinkedIn</a>
    `;
}

function renderContactStrip(profile) {
    return `
        <span>${escapeHtml(profile.university)}</span>
        <span>${escapeHtml(profile.location)}</span>
        <a href="tel:${profile.phone.replaceAll(" ", "")}">${escapeHtml(profile.phone)}</a>
    `;
}

function renderFocusAreas(focusAreas) {
    return focusAreas
        .map((item) => `<span class="chip">${escapeHtml(item)}</span>`)
        .join("");
}

function renderMetrics(metrics) {
    return metrics
        .map((metric) => `
            <article class="metric-card">
                <p class="metric-value">${escapeHtml(metric.value)}</p>
                <p class="metric-label">${escapeHtml(metric.label)}</p>
                <p>${escapeHtml(metric.description)}</p>
            </article>
        `)
        .join("");
}

function renderEducation(education) {
    return education
        .map((entry) => `
            <article class="timeline-card">
                <p class="timeline-meta">${escapeHtml(entry.period)}</p>
                <h3>${escapeHtml(entry.degree)}</h3>
                <p>${escapeHtml(entry.specialization)}</p>
                <p>${escapeHtml(entry.institute)}</p>
                <span class="timeline-score">${escapeHtml(entry.score)}</span>
            </article>
        `)
        .join("");
}

function renderProject(project) {
    const stack = project.stack
        .map((item) => `<span class="project-chip">${escapeHtml(item)}</span>`)
        .join("");

    const highlights = project.highlights
        .map((item) => `<li>${escapeHtml(item)}</li>`)
        .join("");

    return `
        <article class="project-card">
            <p class="project-meta">${escapeHtml(project.period)} | ${escapeHtml(project.role)}</p>
            <h3>${escapeHtml(project.name)}</h3>
            <p>${escapeHtml(project.summary)}</p>
            <div class="project-stack">${stack}</div>
            <ul class="project-list">${highlights}</ul>
        </article>
    `;
}

function renderProjects(projects) {
    return projects.map(renderProject).join("");
}

function renderRoles(roles) {
    return roles
        .map((role) => {
            const highlights = role.highlights
                .map((item) => `<li>${escapeHtml(item)}</li>`)
                .join("");

            return `
                <article class="stack-card">
                    <p class="stack-meta">${escapeHtml(role.period)}</p>
                    <h3>${escapeHtml(role.title)}</h3>
                    <p>${escapeHtml(role.organization)}</p>
                    <ul class="stack-list">${highlights}</ul>
                </article>
            `;
        })
        .join("");
}

function renderBulletCards(items) {
    return items
        .map((item) => `
            <article class="stack-card">
                <p>${escapeHtml(item)}</p>
            </article>
        `)
        .join("");
}

function renderSkills(skills) {
    return skills
        .map((skill) => {
            const chips = skill.items
                .map((item) => `<span class="skill-chip">${escapeHtml(item)}</span>`)
                .join("");

            return `
                <article class="skill-card">
                    <h3>${escapeHtml(skill.name)}</h3>
                    <div class="skill-chip-group">${chips}</div>
                </article>
            `;
        })
        .join("");
}

function hydratePortfolio(data) {
    appState.data = data;

    document.getElementById("name").textContent = data.profile.name;
    document.getElementById("title").textContent = `${data.profile.title} at ${data.profile.university}`;
    document.getElementById("tagline").textContent = data.tagline;
    document.getElementById("overview").textContent = data.overview;
    document.getElementById("footer-name").textContent = data.profile.name;

    document.getElementById("hero-actions").innerHTML = renderActionLinks(data.profile);
    document.getElementById("footer-actions").innerHTML = renderActionLinks(data.profile);
    document.getElementById("contact-strip").innerHTML = renderContactStrip(data.profile);
    document.getElementById("focus-areas").innerHTML = renderFocusAreas(data.focusAreas);
    document.getElementById("metrics").innerHTML = renderMetrics(data.metrics);
    document.getElementById("education").innerHTML = renderEducation(data.education);
    document.getElementById("projects").innerHTML = renderProjects(data.projects);
    document.getElementById("roles").innerHTML = renderRoles(data.roles);
    document.getElementById("achievements").innerHTML = renderBulletCards(data.achievements);
    document.getElementById("skills").innerHTML = renderSkills(data.skills);
    document.getElementById("certifications").innerHTML = renderBulletCards(data.certifications);
}

function initReveal() {
    const items = document.querySelectorAll(".reveal");

    if (window.matchMedia("(prefers-reduced-motion: reduce)").matches) {
        items.forEach((item) => item.classList.add("visible"));
        return;
    }

    const observer = new IntersectionObserver((entries) => {
        entries.forEach((entry) => {
            if (entry.isIntersecting) {
                entry.target.classList.add("visible");
                observer.unobserve(entry.target);
            }
        });
    }, { threshold: 0.18 });

    items.forEach((item) => observer.observe(item));
}

function showFallbackMessage(error) {
    document.getElementById("name").textContent = "Portfolio temporarily unavailable";
    document.getElementById("tagline").textContent = error.message;
}

document.addEventListener("DOMContentLoaded", async () => {
    try {
        const data = await loadPortfolio();
        hydratePortfolio(data);
    } catch (error) {
        showFallbackMessage(error);
    } finally {
        initReveal();
    }
});
