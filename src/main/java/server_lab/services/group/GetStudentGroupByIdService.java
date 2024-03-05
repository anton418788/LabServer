package server_lab.services.group;

import server_lab.exception.ServiceException;
import server_lab.repositories.RepositoryGroup;
import server_lab.request.group.GetStudentGroupByIdRequest;
import server_lab.response.group.GetStudentGroupByIdResponse;

public class GetStudentGroupByIdService implements IGetStudentGroupByIdService {
    private RepositoryGroup repositoryGroup;

    public GetStudentGroupByIdService(RepositoryGroup repositoryGroup) {
        this.repositoryGroup = repositoryGroup;
    }

    @Override
    public GetStudentGroupByIdResponse getStudentGroupById(GetStudentGroupByIdRequest request) throws ServiceException {
        try {
            return new GetStudentGroupByIdResponse(repositoryGroup.getStudentGroupById(request.getId()).getName());
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
