package server_lab.services.group;

import server_lab.exception.ServiceException;
import server_lab.request.group.AddStudentGroupsRequest;
import server_lab.response.group.AddStudentGroupsResponse;

public interface IAddStudentGroupsService {
    AddStudentGroupsResponse addStudentGroups(AddStudentGroupsRequest request) throws ServiceException;
}
