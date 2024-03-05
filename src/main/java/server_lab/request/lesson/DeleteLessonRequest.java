package server_lab.request.lesson;


public class DeleteLessonRequest {
    private long id;

    public DeleteLessonRequest() {
    }

    public DeleteLessonRequest(Long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
