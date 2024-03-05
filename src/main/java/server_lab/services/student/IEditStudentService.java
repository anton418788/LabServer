package server_lab.services.student;

import server_lab.exception.ServiceException;
import server_lab.request.student.EditStudentRequest;
import server_lab.response.student.EditStudentResponse;

public interface IEditStudentService {
    EditStudentResponse editStudent(EditStudentRequest request) throws ServiceException;
}
