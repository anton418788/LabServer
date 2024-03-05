package server_lab.request.lesson;


public class GetLessonsByTeacherRequest {
    private String teacherId;
    private String startDate;
    private String endDate;

    public GetLessonsByTeacherRequest(String groupId, String startDate, String endDate) {
        this.teacherId = groupId;
        this.endDate = endDate;
        this.startDate = startDate;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
