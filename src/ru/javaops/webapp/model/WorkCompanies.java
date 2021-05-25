package ru.javaops.webapp.model;

import java.time.LocalDate;

public class WorkCompanies {
    private final Link homePage;
    private final LocalDate startWork;
    private final LocalDate endWork;
    private final String workPosition;
    private final String description;

    public WorkCompanies(String name, String url, LocalDate startDate, LocalDate endDate, String title, String description) {
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
        WorkCompanies workCompanies = (WorkCompanies) o;
        if (!homePage.equals(workCompanies.homePage)) return false;
        if (!startWork.equals(workCompanies.startWork)) return false;
        if (!endWork.equals(workCompanies.endWork)) return false;
        if (!workPosition.equals(workCompanies.workPosition)) return false;
        return description != null ? description.equals(workCompanies.description) : workCompanies.description == null;
    }

    @Override
    public int hashCode() {
        return homePage.hashCode() + startWork.hashCode() + endWork.hashCode() + workPosition.hashCode() + description.hashCode();
    }
}
