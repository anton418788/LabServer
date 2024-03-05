package server_lab.services.student;

import server_lab.exception.ServiceException;
import server_lab.entity.Student;
import server_lab.repositories.RepositoryStudent;
import server_lab.request.student.GetStudentByGroupRequest;
import server_lab.response.student.GetStudentByGroupResponse;

import java.util.ArrayList;
import java.util.List;

public class GetStudentByGroupService implements IGetStudentByGroupService {
    private RepositoryStudent repositoryStudent;

    public GetStudentByGroupService(RepositoryStudent repositoryStudent) {
        this.repositoryStudent = repositoryStudent;
    }

    @Override
    public GetStudentByGroupResponse getStudentByGroup(GetStudentByGroupRequest request) throws ServiceException {
        List<String> listName = new ArrayList<>();
        List<String> listSurname = new ArrayList<>();
        List<String> listPatronymic = new ArrayList<>();
        List<String> listStatus = new ArrayList<>();

        for (Student student : repositoryStudent.getStudentByGroup(request.getGroupId())) {
            listName.add(student.getName());
            listSurname.add(student.getSurname());
            listPatronymic.add(student.getPatronymic());
            listStatus.add(student.getStatus());
        }

        return new GetStudentByGroupResponse(listName, listSurname, listPatronymic, listStatus);
    }
}
