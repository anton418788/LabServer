package server_lab.request.subject;


public class DeleteSubjectRequest {
    private long id;

    public DeleteSubjectRequest() {
    }
    public DeleteSubjectRequest(Long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
