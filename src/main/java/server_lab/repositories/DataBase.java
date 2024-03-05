package server_lab.repositories;

import server_lab.entity.*;

import java.util.HashMap;
import java.util.Map;

/**
 * заглушка для работы репозиториев
 */
public class DataBase {
    private Map<Long, Student> studentMap;
    private long maxStudentId;
    private Map<Long, Teacher> teacherMap;
    private long maxTeacherId;
    private Map<Long, Group> groupMap;
    private long maxClassroomId;
    private Map<Long, Classroom> classroomMap;
    private long maxGroupId;
    private Map<Long, Subject> subjectMap;
    private Map<Long, Lesson> lessonMap;
    private Map<Long, VisitingLesson> visitingLessonMap;

    public DataBase() {
        this.studentMap = new HashMap<>();
        this.maxStudentId = 1;
        this.maxTeacherId = 1;
        this.teacherMap = new HashMap<>();
        this.groupMap = new HashMap<>();
        this.maxGroupId = 1;
    }
    public long nextStudentId() {
        long idRet = maxStudentId;
        this.maxStudentId++;
        return idRet;
    }
    public long nextTeacherId() {
        long idRet = maxTeacherId;
        this.maxTeacherId++;
        return idRet;
    }
    public long nextClassroomId() {
        long idRet = maxClassroomId;
        this.maxClassroomId++;
        return idRet;
    }

    public long nextGroupId() {
        long idRet = maxGroupId;
        this.maxGroupId++;
        return idRet;
    }

    public Map<Long, Student> getStudentMap() {
        return studentMap;
    }

    public Map<Long, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public Map<Long, Group> getGroupMap() {
        return groupMap;
    }
    public Map<Long, Classroom> getClassroomMap() {
        return classroomMap;
    }

    public Map<Long, Subject> getSubjectMap() {
        return subjectMap;
    }

    public Map<Long, Lesson> getLessonMap() {
        return lessonMap;
    }

    public Map<Long, VisitingLesson> getVisitingLessonMap() {
        return visitingLessonMap;
    }

}
