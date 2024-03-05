package server_lab.response.student;


public class AddStudentResponse {
    private Long id;

    public AddStudentResponse() {}

    public AddStudentResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
