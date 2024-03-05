package server_lab.entity;

import java.util.Objects;

public class Student {
    private Long id;
    private Long groupId;
    private String surname;
    private String name;
    private String patronymic;
    private String status;

    //public Student(int i, String surname, String name, String status) {}

    public Student(Long id, Long groupId, String surname, String name, String patronymic, String status) {
        this.id = id;
        this.groupId = groupId;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.status = status;
    }

    public Student(long groupId, String surname, String name, String patronymic, String status) {
        this.groupId = groupId;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long id_group) {
        this.groupId = id_group;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void set(Student student) {
        setStatus(student.getStatus());
        setPatronymic(student.getPatronymic());
        setName(student.getName());
        setSurname(student.getSurname());
        setGroupId(student.getGroupId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(groupId, student.groupId) && Objects.equals(surname, student.surname) && Objects.equals(name, student.name) && Objects.equals(patronymic, student.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupId, surname, name, patronymic);
    }
}
