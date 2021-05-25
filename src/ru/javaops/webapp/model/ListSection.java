package ru.javaops.webapp.model;

import java.util.List;

public class ListSection extends AbstractSection {
    private final List<String> nameOfSection;

    public ListSection(List<String> nameOfSection) {
        this.nameOfSection = nameOfSection;
    }

    public List<String> getNameOfSection() {
        return nameOfSection;
    }

    @Override
    public String toString() {
        return nameOfSection.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListSection listSection = (ListSection) o;
        return nameOfSection.equals(listSection.nameOfSection);
    }

    @Override
    public int hashCode() {
        return nameOfSection.hashCode();
    }
}
