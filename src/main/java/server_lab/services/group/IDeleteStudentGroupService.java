package server_lab.services.group;

import server_lab.exception.ServiceException;
import server_lab.request.group.DeleteStudentGroupRequest;
import server_lab.response.group.DeleteStudentGroupResponse;

public interface IDeleteStudentGroupService {
    DeleteStudentGroupResponse deleteStudentGroup(DeleteStudentGroupRequest request) throws ServiceException;
}
