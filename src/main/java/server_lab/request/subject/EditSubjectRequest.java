package server_lab.request.subject;


public class EditSubjectRequest {
    private long id;
    private String name;

    public EditSubjectRequest() {}

    public EditSubjectRequest(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
