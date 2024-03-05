package server_lab.request.group;


public class AddStudentGroupsRequest {
    private String name;

    public AddStudentGroupsRequest() {}

    public AddStudentGroupsRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
