package server_lab.request.student;


public class DeleteStudentRequest {
    private long id;

    public DeleteStudentRequest() {}

    public DeleteStudentRequest(Long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
