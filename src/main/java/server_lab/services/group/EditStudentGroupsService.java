package server_lab.services.group;

import server_lab.essence.Group;
import server_lab.exception.ServiceException;
import server_lab.repositories.RepositoryGroup;
import server_lab.request.group.EditStudentGroupsRequest;
import server_lab.response.group.EditStudentGroupsResponse;

public class EditStudentGroupsService implements IEditStudentGroupsService {
    private RepositoryGroup repositoryGroup;

    public EditStudentGroupsService(RepositoryGroup repositoryGroup) {
        this.repositoryGroup = repositoryGroup;
    }

    @Override
    public EditStudentGroupsResponse editStudentGroups(EditStudentGroupsRequest request) throws ServiceException {
        try {
            repositoryGroup.editStudentGroup(new Group(request.getId(), request.getName()));
            return new EditStudentGroupsResponse();
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
