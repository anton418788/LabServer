package server_lab.request.student;


public class AddStudentRequest {
    private String groupId;
    private String surname;
    private String name;
    private String patronymic;
    private String status;


    public AddStudentRequest() {}

    public AddStudentRequest(String groupId, String surname, String name, String patronymic, String status) {
        this.groupId = groupId;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.status = status;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getStatus() {
        return status;
    }
}
