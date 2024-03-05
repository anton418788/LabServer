package server_lab.response.subject;


public class AddSubjectsResponse {
    private long id;

    public AddSubjectsResponse() {}

    public AddSubjectsResponse(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
