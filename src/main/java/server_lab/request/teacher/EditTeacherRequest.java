package server_lab.request.teacher;


public class EditTeacherRequest {
    private Long id;
    private String surname;
    private String name;
    private String patronymic;

    public EditTeacherRequest() {}

    public EditTeacherRequest(Long id, String surname, String name, String patronymic) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public Long getId() {
        return id;
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
