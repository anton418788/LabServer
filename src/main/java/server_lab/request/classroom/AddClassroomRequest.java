package server_lab.request.classroom;

public class AddClassroomRequest {
    private String classroom_number;
    private Integer capacity;
    private Integer number_building;

    public AddClassroomRequest(){}
    public AddClassroomRequest(String classroom_number, Integer capacity, Integer number_building){
        this.classroom_number = classroom_number;
        this.capacity = capacity;
        this.number_building = number_building;
    }

    public String getClassroom_number() {
        return classroom_number;
    }
    public Integer getCapacity() {
        return capacity;
    }
    public Integer getNumber_building() {
        return number_building;
    }
}
