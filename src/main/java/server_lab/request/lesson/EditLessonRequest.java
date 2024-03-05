package server_lab.request.lesson;


public class EditLessonRequest {
    private long id;
    private String groupId;
    private String teacherId;
    private String data;
    private String time;

    public EditLessonRequest(long id,String groupId, String teacherId, String data, String time) {
        this.id = id;
        this.data = data;
        this.groupId = groupId;
        this.time = time;
        this.teacherId = teacherId;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getData() {
        return data;
    }

    public String getTime() {
        return time;
    }

    public long getId() {
        return id;
    }
}
