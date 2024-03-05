package server_lab.entity;

import java.util.Map;

public class VisitingLesson {
    private Lesson lesson;
    private Map<Student, Boolean> students;
    public VisitingLesson(Lesson lesson, Map<Student, Boolean> students) {
        this.lesson = lesson;
        this.students = students;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Map<Student, Boolean> getStudents() {
        return students;
    }

    public void setStudents(Map<Student, Boolean> students) {
        this.students = students;
    }
}
