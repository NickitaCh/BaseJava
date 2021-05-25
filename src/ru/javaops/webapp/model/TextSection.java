package ru.javaops.webapp.model;

public class TextSection extends AbstractSection {
    private final String text;

    public TextSection(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextSection textSection = (TextSection) o;
        return text.equals(textSection.text);
    }

    @Override
    public int hashCode() {
        return text.hashCode();
    }
}
