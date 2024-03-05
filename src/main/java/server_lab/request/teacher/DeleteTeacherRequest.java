package server_lab.request.teacher;


public class DeleteTeacherRequest {
    private long id;

    public DeleteTeacherRequest() {}

    public DeleteTeacherRequest(Long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
