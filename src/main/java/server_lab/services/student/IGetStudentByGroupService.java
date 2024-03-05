package server_lab.services.student;

import server_lab.exception.ServiceException;
import server_lab.request.student.GetStudentByGroupRequest;
import server_lab.response.student.GetStudentByGroupResponse;

public interface IGetStudentByGroupService {
    GetStudentByGroupResponse getStudentByGroup(GetStudentByGroupRequest request) throws ServiceException;
}
