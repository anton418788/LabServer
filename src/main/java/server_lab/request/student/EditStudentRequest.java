package server_lab.request.student;


public class EditStudentRequest {
    private long id;
    private String groupId;
    private String surname;
    private String name;
    private String patronymic;
    private String status;

    public EditStudentRequest() {}

    public EditStudentRequest(Long id, String groupId, String surname, String name, String patronymic, String status) {
        this.id = id;
        this.groupId = groupId;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.status = status;
    }

    public Long getId() {
        return id;
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
