package server_lab.request.subject;

public class AddSubjectRequest {
    private String name;

    public AddSubjectRequest() {}

    public AddSubjectRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
