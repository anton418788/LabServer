package server_lab.essence;

import java.util.Objects;

public class Subject {
    private Long id;
    private String name;

    public Subject() {}

    public Subject(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject discipline = (Subject) o;
        return Objects.equals(id, discipline.id) && Objects.equals(name, discipline.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
