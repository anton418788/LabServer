package server_lab.services.student;

import server_lab.essence.Student;
import server_lab.repositories.RepositoryStudent;
import server_lab.request.student.GetStudentByIdRequest;
import server_lab.response.student.GetStudentByIdResponse;

public class GetStudentByIdService implements IGetStudentByIdService {
    private RepositoryStudent repositoryStudent;

    public GetStudentByIdService(RepositoryStudent repositoryStudent) {
        this.repositoryStudent = repositoryStudent;
    }

    @Override
    public GetStudentByIdResponse getStudentById(GetStudentByIdRequest request) {
        Student student = repositoryStudent.getStudentById(request.getId());
        return new GetStudentByIdResponse(student.getGroupId(), student.getName(), student.getSurname(), student.getPatronymic(), student.getStatus());
    }
}
