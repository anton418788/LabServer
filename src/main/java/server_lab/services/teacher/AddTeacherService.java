package server_lab.services.teacher;

import server_lab.essence.Teacher;
import server_lab.repositories.RepositoryTeacher;
import server_lab.request.teacher.AddTeacherRequest;
import server_lab.response.teacher.AddTeacherResponse;

public class AddTeacherService {
    private RepositoryTeacher repositoryTeacher;

    public AddTeacherService(RepositoryTeacher repositoryTeacher) {
        this.repositoryTeacher = repositoryTeacher;
    }

    public AddTeacherResponse addTeacher(AddTeacherRequest request) {
        return new AddTeacherResponse(repositoryTeacher.addTeacher(new Teacher(request.getSurname(),request.getName(), request.getPatronymic())));
    }
}
