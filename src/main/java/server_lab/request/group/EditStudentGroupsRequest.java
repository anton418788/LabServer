package server_lab.request.group;


public class EditStudentGroupsRequest {
    private long id;
    private String name;

    public EditStudentGroupsRequest() {}

    public EditStudentGroupsRequest(Long id, String name) {
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
