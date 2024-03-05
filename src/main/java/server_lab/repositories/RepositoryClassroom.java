package server_lab.repositories;

import server_lab.entity.Classroom;
import server_lab.entity.Group;

import java.util.List;

public class RepositoryClassroom  {
    private DataBase base;

    public RepositoryClassroom(DataBase base) {
        this.base = base;
    }


    public long addClassroom(Classroom classroom) {
        long groupId = base.nextGroupId();
        base.getClassroomMap().put(groupId, classroom);
        return groupId;
    }


    public Group getClassroomByBuilding(Integer building) {
        if (!base.getClassroomMap().containsKey(building)) {
            throw new RuntimeException("Object with ID not found");
        }
        return base.getGroupMap().get(building);
    }

}
