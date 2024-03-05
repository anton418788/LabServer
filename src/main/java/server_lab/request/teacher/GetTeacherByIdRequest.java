package server_lab.request.teacher;


public class GetTeacherByIdRequest {
    private long id;

    public GetTeacherByIdRequest() {}

    public GetTeacherByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
