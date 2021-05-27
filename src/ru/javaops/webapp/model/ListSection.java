package ru.javaops.webapp.model;

import java.util.List;

public class ListSection extends AbstractSection {
    private final List<String> content;

    public ListSection(List<String> nameOfSection) {
        this.content = nameOfSection;
    }

    public List<String> getСontent() {
        return content;
    }

    @Override
    public String toString() {
        return content.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListSection listSection = (ListSection) o;
        return content.equals(listSection.content);
    }

    @Override
    public int hashCode() {
        return content.hashCode();
    }
}
