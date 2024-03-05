package server_lab.response.teacher;


public class GetTeacherByIdResponse {
    private String surname;
    private String name;
    private String patronymic;

    public GetTeacherByIdResponse() {}

    public  GetTeacherByIdResponse(String name, String surname, String patronymic) {

        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
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
}
