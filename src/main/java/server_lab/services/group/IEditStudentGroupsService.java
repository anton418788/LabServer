package server_lab.services.group;

import server_lab.exception.ServiceException;
import server_lab.request.group.EditStudentGroupsRequest;
import server_lab.response.group.EditStudentGroupsResponse;

public interface IEditStudentGroupsService {
    EditStudentGroupsResponse editStudentGroups(EditStudentGroupsRequest request) throws ServiceException;
}
