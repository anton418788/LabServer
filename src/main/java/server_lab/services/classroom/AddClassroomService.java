package server_lab.services.classroom;

import server_lab.entity.Classroom;
import server_lab.repositories.RepositoryClassroom;
import server_lab.request.classroom.AddClassroomRequest;
import server_lab.response.classroom.AddClassroomResponse;


public class AddClassroomService {
    private RepositoryClassroom repositoryClassroom;

    public AddClassroomService(RepositoryClassroom repositoryClassroom) {
        this.repositoryClassroom = repositoryClassroom;
    }

    public AddClassroomResponse addClassroom(AddClassroomRequest request) {
        return new AddClassroomResponse(repositoryClassroom.addClassroom(new Classroom(request.getClassroom_number(),request.getCapacity(), request.getNumber_building())));
    }
}
