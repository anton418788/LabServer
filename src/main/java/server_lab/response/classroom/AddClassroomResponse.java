package server_lab.response.classroom;

public class AddClassroomResponse {
    private Long id;

    public AddClassroomResponse() {}

    public AddClassroomResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
