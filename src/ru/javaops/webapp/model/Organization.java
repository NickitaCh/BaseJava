package ru.javaops.webapp.model;

import java.util.List;

public class Organization extends AbstractSection {
    private final List<Experience> companies;

    public Organization(List<Experience> companies) {
        this.companies = companies;
    }

    public List<Experience> getCompanies() {
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
        Organization organization = (Organization) o;
        return companies.equals(organization.companies);
    }

    @Override
    public int hashCode() {
        return companies.hashCode();
    }
}
