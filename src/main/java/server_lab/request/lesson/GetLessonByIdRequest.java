package server_lab.request.lesson;


public class GetLessonByIdRequest {
    private long id;

    public GetLessonByIdRequest() {}

    public GetLessonByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
