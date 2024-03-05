package server_lab.services.group;

import server_lab.entity.Group;
import server_lab.exception.ServiceException;
import server_lab.repositories.RepositoryGroup;
import server_lab.request.group.GetStudentGroupsRequest;
import server_lab.response.group.GetStudentGroupsResponse;

import java.util.ArrayList;
import java.util.List;

public class GetStudentGroupsService implements IGetStudentGroupsService {
    private RepositoryGroup repositoryGroup;

    public GetStudentGroupsService(RepositoryGroup repositoryGroup) {
        this.repositoryGroup = repositoryGroup;
    }

    @Override
    public GetStudentGroupsResponse getStudentGroups(GetStudentGroupsRequest request) throws ServiceException {
        try {
            List<String> groups = new ArrayList<>();
            for (Group group : repositoryGroup.getStudentGroups()) {
                groups.add(group.getName());
            }
            return new GetStudentGroupsResponse(groups);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
