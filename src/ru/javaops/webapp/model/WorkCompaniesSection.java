package ru.javaops.webapp.model;

import java.util.List;

public class WorkCompaniesSection extends AbstractSection {
    private final List<WorkCompanies> companies;

    public WorkCompaniesSection(List<WorkCompanies> companies) {
        this.companies = companies;
    }

    public List<WorkCompanies> getCompanies() {
        return companies;
    }

    @Override
    public String toString() {
        return companies.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkCompaniesSection workCompaniesSection = (WorkCompaniesSection) o;
        return companies.equals(workCompaniesSection.companies);
    }

    @Override
    public int hashCode() {
        return companies.hashCode();
    }
}
