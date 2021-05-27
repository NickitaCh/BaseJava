package ru.javaops.webapp.model;

import java.time.LocalDate;

public class Experience {
    private final Link homePage;
    private final LocalDate startWork;
    private final LocalDate endWork;
    private final String workPosition;
    private final String description;

    public Experience(String name, String url, LocalDate startDate, LocalDate endDate, String title, String description) {
        this.homePage = new Link(name, url);
        this.startWork = startDate;
        this.endWork = endDate;
        this.workPosition = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Link: " + homePage + ", Period: " + startWork + " - " + endWork + ", Position: " + workPosition + ", Description: " + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Experience experience = (Experience) o;
        if (!homePage.equals(experience.homePage)) return false;
        if (!startWork.equals(experience.startWork)) return false;
        if (!endWork.equals(experience.endWork)) return false;
        if (!workPosition.equals(experience.workPosition)) return false;
        return description != null ? description.equals(experience.description) : experience.description == null;
    }

    @Override
    public int hashCode() {
        return homePage.hashCode() + startWork.hashCode() + endWork.hashCode() + workPosition.hashCode() + description.hashCode();
    }
}
