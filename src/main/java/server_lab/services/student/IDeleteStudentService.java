package server_lab.services.student;

import server_lab.exception.ServiceException;
import server_lab.request.student.DeleteStudentRequest;
import server_lab.response.student.DeleteStudentResponse;

public interface IDeleteStudentService {
    DeleteStudentResponse deleteStudent(DeleteStudentRequest request) throws ServiceException;
}
