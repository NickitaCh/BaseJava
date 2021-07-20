package ru.javaops.webapp.model;

import ru.javaops.webapp.util.LocalDateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static ru.javaops.webapp.util.DateUtil.forNow;
import static ru.javaops.webapp.util.DateUtil.of;

@XmlAccessorType(XmlAccessType.FIELD)
public class Experience implements Serializable {
    private static final long serialVersionUID = 1L;
    private Link homePage;
    private List<Position> positions = new ArrayList<>();

    public Experience() {
    }

    public Experience(Link homePage, List<Position> positions) {
        this.homePage = homePage;
        this.positions = positions;
    }

    public Experience(String name, String url, Position... positions) {
        this(new Link(name, url), Arrays.asList(positions));
    }

    public Link getHomePage() {
        return homePage;
    }

    public List<Position> getPositions() {
        return positions;
    }

    @Override
    public String toString() {
        return "Experience:" + homePage + "," + positions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Experience experience = (Experience) o;
        return Objects.equals(homePage, experience.homePage) && Objects.equals(positions, experience.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, positions);
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Position implements Serializable {
        @XmlJavaTypeAdapter(LocalDateAdapter.class)
        private LocalDate startWork;
        @XmlJavaTypeAdapter(LocalDateAdapter.class)
        private LocalDate endWork;
        private String workPosition;
        private String description;

        public Position() {
        }

        public Position(int startYear, Month startMonth, String title, String description) {
            this(of(startYear, startMonth), forNow, title, description);
        }

        public Position(int startYear, Month startMonth, int endYear, Month endMonth, String title, String description) {
            this(of(startYear, startMonth), of(endYear, endMonth), title, description);
        }

        public Position(LocalDate startDate, LocalDate endDate, String title, String description) {
            Objects.requireNonNull(startDate, "startDate must not be null");
            Objects.requireNonNull(endDate, "endDate must not be null");
            Objects.requireNonNull(title, "title must not be null");
            this.startWork = startDate;
            this.endWork = endDate;
            this.workPosition = title;
            this.description = description == null ? "" : description;
        }

        public LocalDate getStartWork() {
            return startWork;
        }

        public LocalDate getEndWork() {
            return endWork;
        }

        public String getWorkPosition() {
            return workPosition;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return Objects.equals(startWork, position.startWork) &&
                    Objects.equals(endWork, position.endWork) &&
                    Objects.equals(workPosition, position.workPosition) &&
                    Objects.equals(description, position.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startWork, endWork, workPosition, description);
        }

        @Override
        public String toString() {
            return "\nPosition:" + startWork + ',' + endWork + '\n' + workPosition + '\n' + description;
        }

    }
}