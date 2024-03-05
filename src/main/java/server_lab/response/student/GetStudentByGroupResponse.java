package server_lab.response.student;

import java.util.List;


public class GetStudentByGroupResponse {
    private List<String> listName;
    private List<String> listSurname;
    private List<String> listPatronymic;
    private List<String> listStatus;


    public GetStudentByGroupResponse(List<String> listName, List<String> listSurname, List<String> listPatronymic, List<String> listStatus) {
        this.listName = listName;
        this.listPatronymic = listPatronymic;
        this.listSurname = listSurname;
        this.listStatus = listStatus;
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

    public List<String> getListStatus() {
        return listStatus;
    }

    public void setListStatus(List<String> listStatus) {
        this.listStatus = listStatus;
    }
}
