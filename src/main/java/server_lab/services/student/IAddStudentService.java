package server_lab.services.student;

import server_lab.exception.ServiceException;
import server_lab.request.student.AddStudentRequest;
import server_lab.response.student.AddStudentResponse;

public interface IAddStudentService {
    AddStudentResponse addStudent(AddStudentRequest request) throws ServiceException;
}
