package server_lab.repositories;

import server_lab.entity.Classroom;
import server_lab.entity.Classroom;

import java.util.List;

public class RepositoryClassroom  {
    private DataBase base;

    public RepositoryClassroom(DataBase base) {
        this.base = base;
    }


    public long addClassroom(Classroom classroom) {
        long classroomId = base.nextClassroomId();
        base.getClassroomMap().put(classroomId, classroom);
        return classroomId;
    }


    public Classroom getClassroomByBuilding(Integer building) {
        if (!base.getClassroomMap().containsKey(building)) {
            throw new RuntimeException("Object with ID not found");
        }
        return base.getClassroomMap().get(building);
    }

}
