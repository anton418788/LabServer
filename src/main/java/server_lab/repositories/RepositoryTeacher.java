package server_lab.repositories;

import server_lab.essence.Teacher;

import java.util.List;


public class RepositoryTeacher implements IRepositoryTeacher {
    private DataBase base;

    public RepositoryTeacher(DataBase base) { //шаг 2
        this.base = base;
    }

    @Override
    public long addTeacher(Teacher teacher) { //шаг 3
        long teacherId = base.nextTeacherId();
        base.getTeacherMap().put(teacherId, teacher);
        return teacherId;
    }

    @Override
    public void editTeacher(Teacher teacher) {
        System.out.println("Заглушка изменения");
    }

    @Override
    public void deleteTeacher(long id) {
        System.out.println("Заглушка удаления");
    }

    @Override
    public Teacher getTeacherById(long id) {
        return base.getTeacherMap().get(id);
    }

    @Override
    public List<Teacher> getTeachers() {
        return base.getTeacherMap().values().stream().toList();
    }
}
