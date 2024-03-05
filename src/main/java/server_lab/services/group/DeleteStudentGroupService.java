package server_lab.services.group;

import server_lab.exception.ServiceException;
import server_lab.repositories.RepositoryGroup;
import server_lab.request.group.DeleteStudentGroupRequest;
import server_lab.response.group.DeleteStudentGroupResponse;

public class DeleteStudentGroupService implements IDeleteStudentGroupService {

    private RepositoryGroup repositoryGroup;

    public DeleteStudentGroupService(RepositoryGroup repositoryGroup) {
        this.repositoryGroup = repositoryGroup;
    }

    @Override
    public DeleteStudentGroupResponse deleteStudentGroup(DeleteStudentGroupRequest request) throws ServiceException {
        try {
            repositoryGroup.deleteStudentGroup(request.getId());
            return new DeleteStudentGroupResponse();
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
