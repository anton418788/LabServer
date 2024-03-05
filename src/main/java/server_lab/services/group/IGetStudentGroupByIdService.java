package server_lab.services.group;

import server_lab.exception.ServiceException;
import server_lab.request.group.GetStudentGroupByIdRequest;
import server_lab.response.group.GetStudentGroupByIdResponse;

public interface IGetStudentGroupByIdService {
    GetStudentGroupByIdResponse getStudentGroupById(GetStudentGroupByIdRequest request) throws ServiceException;
}
