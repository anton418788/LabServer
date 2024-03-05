package server_lab.repositories;

import server_lab.essence.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class RepositoryStudent implements IRepositoryStudent {
    private DataBase base;

    public RepositoryStudent(DataBase base) {
        this.base = base;
    }

    @Override
    public long addStudent(Student student) {
        if (!base.getGroupMap().containsKey(student.getGroupId())) {
            throw new RuntimeException("Object with ID not found");
        }
        long studentId = base.nextStudentId();
        base.getStudentMap().put(studentId, student);
        return studentId;
    }

    @Override
    public void editStudent(Student student) {
        if (!base.getStudentMap().containsKey(student.getId()) || !base.getGroupMap().containsKey(student.getGroupId())) {
            throw new RuntimeException("Object with ID not found");
        }
        base.getStudentMap().get(student.getId()).set(student);
    }

    @Override
    public void deleteStudent(long id) {
        if (!base.getStudentMap().containsKey(id)) {
            throw new RuntimeException("Object with ID not found");
        }
        base.getStudentMap().remove(id);
    }

    @Override
    public Student getStudentById(long id) {
        if (!base.getStudentMap().containsKey(id)) {
            throw new RuntimeException("Object with ID not found");
        }
        return base.getStudentMap().get(id);
    }

    @Override
    public List<Student> getStudentByGroup(long idGroup) {
        if (!base.getGroupMap().containsKey(idGroup)) {
            throw new RuntimeException("Object with ID not found");
        }
        List<Student> studentsInGroup = new ArrayList<>();
        for (Map.Entry<Long, Student> m : base.getStudentMap().entrySet()) {
            if (m.getValue().getGroupId() == idGroup) {
                studentsInGroup.add(m.getValue());
            }
        }
        return studentsInGroup;
    }
}
