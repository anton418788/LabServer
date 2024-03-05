package server_lab.services.student;

import server_lab.entity.Student;
import server_lab.repositories.RepositoryStudent;
import server_lab.request.student.AddStudentRequest;
import server_lab.response.student.AddStudentResponse;

public class AddStudentService implements IAddStudentService {
    private RepositoryStudent repositoryStudent;

    public AddStudentService(RepositoryStudent repositoryStudent) {
        this.repositoryStudent = repositoryStudent;
    }

    @Override
    public AddStudentResponse addStudent(AddStudentRequest request) {
        return new AddStudentResponse(repositoryStudent.addStudent(new Student(Long.parseLong(request.getGroupId()),
                request.getSurname(), request.getName(),request.getPatronymic(), request.getStatus())));
    }
}
