package server_lab.services.group;

import server_lab.exception.ServiceException;
import server_lab.request.group.GetStudentGroupsRequest;
import server_lab.response.group.GetStudentGroupsResponse;

public interface IGetStudentGroupsService {
    GetStudentGroupsResponse getStudentGroups(GetStudentGroupsRequest request) throws ServiceException;
}
