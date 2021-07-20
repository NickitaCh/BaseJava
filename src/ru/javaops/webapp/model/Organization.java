package ru.javaops.webapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Organization extends AbstractSection {
    private static final long serialVersionUID = 1L;
    private List<Experience> companies;

    public Organization() {
    }

    public Organization(List<Experience> companies) {
        Objects.requireNonNull(companies, "companies must not be null");
        this.companies = companies;
    }

    public Organization(Experience... companies) {
        this(Arrays.asList(companies));
    }

    public List<Experience> getExperience() {
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
