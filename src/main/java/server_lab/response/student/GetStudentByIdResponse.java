package server_lab.response.student;


public class GetStudentByIdResponse {
    private Long groupId;
    private String surname;
    private String name;
    private String patronymic;
    private String status;

    public GetStudentByIdResponse() {}

    public  GetStudentByIdResponse(Long groupId, String name, String surname, String patronymic, String status) {
        this.groupId = groupId;
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
