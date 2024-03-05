package server_lab.response.teacher;

import java.util.List;


public class GetTeachersResponse {
    // спросить про id
    private List<String> listName;
    private List<String> listSurname;
    private List<String> listPatronymic;


    public GetTeachersResponse(List<String> listName, List<String> listSurname, List<String> listPatronymic) {
        this.listName = listName;
        this.listPatronymic = listPatronymic;
        this.listSurname = listSurname;
    }

    public List<String> getListName() {
        return listName;
    }

    public void setListName(List<String> listName) {
        this.listName = listName;
    }

    public List<String> getListSurname() {
        return listSurname;
    }

    public void setListSurname(List<String> listSurname) {
        this.listSurname = listSurname;
    }

    public List<String> getListPatronymic() {
        return listPatronymic;
    }

    public void setListPatronymic(List<String> listPatronymic) {
        this.listPatronymic = listPatronymic;
    }
}
