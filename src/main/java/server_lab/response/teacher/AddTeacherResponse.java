package server_lab.response.teacher;


public class AddTeacherResponse {
    private Long id;

    public AddTeacherResponse() {}

    public AddTeacherResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
