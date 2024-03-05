package server_lab.request.student;


public class GetStudentByGroupRequest {
    private long groupId;

    public GetStudentByGroupRequest() {}

    public GetStudentByGroupRequest(long id) {
        this.groupId = id;
    }

    public Long getGroupId() {
        return groupId;
    }
}
