package server_lab.response.group;


public class AddStudentGroupsResponse {
    private Long id;

    public AddStudentGroupsResponse() {}

    public AddStudentGroupsResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
