package server_lab.request.teacher;


public class AddTeacherRequest {
    private String surname;
    private String name;
    private String patronymic;

    public AddTeacherRequest() {}

    public AddTeacherRequest(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
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




}
