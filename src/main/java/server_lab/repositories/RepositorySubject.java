package server_lab.repositories;

import server_lab.essence.Subject;

import java.util.List;

public class RepositorySubject implements IRepositorySubject {
    private DataBase base;

    @Override
    public long addSubject(Subject subject) {
        System.out.println("Заглушка добавления");
        return 6;
    }

    @Override
    public void editSubject(Subject subject) {
        System.out.println("Заглушка изменения");
    }

    @Override
    public void deleteSubject(long id) {
        System.out.println("Заглушка удаления");
    }

    @Override
    public Subject getSubjectById(long id) {
        return base.getSubjectMap().get(id);
    }

    @Override
    public List<Subject> getSubjects() {
        return base.getSubjectMap().values().stream().toList();
    }
}
