package server_lab.services.group;

import server_lab.essence.Group;
import server_lab.repositories.RepositoryGroup;
import server_lab.request.group.AddStudentGroupsRequest;
import server_lab.response.group.AddStudentGroupsResponse;

public class AddStudentGroupsService implements IAddStudentGroupsService {
    private RepositoryGroup repositoryGroup;

    public AddStudentGroupsService(RepositoryGroup repositoryGroup) {
        this.repositoryGroup = repositoryGroup;
    }

    @Override
    public AddStudentGroupsResponse addStudentGroups(AddStudentGroupsRequest request) {
        return new AddStudentGroupsResponse(repositoryGroup.addStudentGroup(new Group(request.getName())));
    }
}
