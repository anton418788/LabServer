package server_lab.response.subject;

import java.util.List;

public class GetSubjectResponse {
    private List<String> listName;

    public GetSubjectResponse(List<String> listName) {
        this.listName = listName;
    }

    public List<String> getListName() {
        return listName;
    }

    public void setListName(List<String> listName) {
        this.listName = listName;
    }
}
