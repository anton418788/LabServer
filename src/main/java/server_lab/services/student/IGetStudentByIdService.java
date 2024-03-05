package server_lab.services.student;

import server_lab.exception.ServiceException;
import server_lab.request.student.GetStudentByIdRequest;
import server_lab.response.student.GetStudentByIdResponse;

public interface IGetStudentByIdService {
    GetStudentByIdResponse getStudentById(GetStudentByIdRequest request) throws ServiceException;
}
