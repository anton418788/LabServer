package server_lab.services.student;

import server_lab.exception.ServiceException;
import server_lab.repositories.RepositoryStudent;
import server_lab.request.student.DeleteStudentRequest;
import server_lab.response.student.DeleteStudentResponse;

public class DeleteStudentService implements IDeleteStudentService {
    private RepositoryStudent repositoryStudent;

    public DeleteStudentService(RepositoryStudent repositoryStudent) {
        this.repositoryStudent = repositoryStudent;
    }

    @Override
    public DeleteStudentResponse deleteStudent(DeleteStudentRequest request) throws ServiceException {
        repositoryStudent.deleteStudent(request.getId());
        return new DeleteStudentResponse();
    }
}
