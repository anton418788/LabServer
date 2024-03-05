package server_lab.services.student;

import server_lab.essence.Student;
import server_lab.exception.ServiceException;
import server_lab.repositories.RepositoryStudent;
import server_lab.request.student.EditStudentRequest;
import server_lab.response.student.EditStudentResponse;

public class EditStudentService implements IEditStudentService {
    private RepositoryStudent repositoryStudent;

    public EditStudentService(RepositoryStudent repositoryStudent) {
        this.repositoryStudent = repositoryStudent;
    }

    @Override
    public EditStudentResponse editStudent(EditStudentRequest request) throws ServiceException {
        repositoryStudent.editStudent(new Student(request.getId(), Long.parseLong(request.getGroupId()), request.getSurname(), request.getName(),request.getPatronymic(), request.getStatus()));
        return new EditStudentResponse();
    }
}
