package server_lab.request.classroom;

public class GetClassroomByBuildingRequest {
    private long id;

    public GetClassroomByBuildingRequest() {}

    public GetClassroomByBuildingRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

}
