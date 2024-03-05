package server_lab.response.lesson;

import server_lab.entity.Student;

import java.time.LocalDate;
import java.util.Map;

public class GetLessonByIdResponse {
    private String GROUPame;
    private String teacherName;
    private String teacherSurname;
    private String teacherPatronymic;
    private LocalDate data;
    private Integer time;

    private Map<Student, Boolean> students;

    public GetLessonByIdResponse(String GROUPame, String teacherName, String teacherSurname, String teacherPatronymic,
                                     LocalDate data, Integer time, Map<Student, Boolean> students) {
        this.GROUPame = GROUPame;
        this.teacherName = teacherName;
        this.teacherSurname = teacherSurname;
        this.teacherPatronymic = teacherPatronymic;
        this.data = data;
        this.time = time;
        this.students = students;
    }

    public Map<Student, Boolean> getStudents() {
        return students;
    }

    public void setStudents(Map<Student, Boolean> students) {
        this.students = students;
    }

    public String getGROUPame() {
        return GROUPame;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTeacherPatronymic() {
        return teacherPatronymic;
    }

    public void setTeacherPatronymic(String teacherPatronymic) {
        this.teacherPatronymic = teacherPatronymic;
    }

    public String getTeacherSurname() {
        return teacherSurname;
    }

    public void setTeacherSurname(String teacherSurname) {
        this.teacherSurname = teacherSurname;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setGROUPame(String GROUPame) {
        this.GROUPame = GROUPame;
    }




}
