package server_lab.entity;

import java.util.Objects;

public class Classroom {
    private Long id;
    private String classroom_number;
    private Integer capacity;
    private Integer number_building;

    public Classroom(){}
    public Classroom(String classroom_number, Integer capacity, Integer number_building){
        this.classroom_number = classroom_number;
        this.capacity = capacity;
        this.number_building = number_building;
    }
    public Classroom(Long id, String classroom_number, Integer capacity, Integer number_building){
        this.id = id;
        this.classroom_number = classroom_number;
        this.capacity = capacity;
        this.number_building = number_building;
    }

    public Long getId() {
        return id;
    }

    public String getClassroom_number() {
        return classroom_number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getNumber_building() {
        return number_building;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClassroom_number(String classroom_number) {
        this.classroom_number = classroom_number;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setNumber_building(Integer number_building) {
        this.number_building = number_building;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classroom classroom = (Classroom) o;
        return Objects.equals(id, classroom.id) && Objects.equals(classroom_number, classroom.classroom_number) && Objects.equals(capacity, classroom.capacity) && Objects.equals(number_building, classroom.number_building);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, classroom_number, capacity, number_building);
    }
}
