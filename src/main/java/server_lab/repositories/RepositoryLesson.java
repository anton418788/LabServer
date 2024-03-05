package server_lab.repositories;

import server_lab.entity.Lesson;
import server_lab.entity.VisitingLesson;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * заглушки
 */
public class RepositoryLesson implements IRepositoryLesson {
    private DataBase base;

    @Override
    public long addLesson(Lesson lesson) {
        System.out.println("Заглушка добавления");
        return 6;
    }

    @Override
    public void editLesson(Lesson lesson) {
        System.out.println("Заглушка изменения");
    }

    @Override
    public void deleteLesson(long id) {
        System.out.println("Заглушка удаления");
    }

    @Override
    public VisitingLesson GetLessonById(long id) {
        return base.getVisitingLessonMap().get(id);
    }

    @Override
    public List<Lesson> getLessonsByGroup(long idGroup, LocalDate startDate, LocalDate endDate) {
        List<Lesson> lessons = new ArrayList<>();
        for (Lesson lesson : base.getLessonMap().values()) {
            if (lesson.getGroupId().equals(idGroup) && lesson.getData().isAfter(endDate) && lesson.getData().isBefore(startDate)) {
                lessons.add(lesson);
            }
        }
        return lessons;
    }

    @Override
    public List<Lesson> getLessonsByTeacher(long teacherId, LocalDate startDate, LocalDate endDate) {
        List<Lesson> lessons = new ArrayList<>();
        for (Lesson lesson : base.getLessonMap().values()) {
            if (lesson.getTeacherId().equals(teacherId) && lesson.getData().isAfter(endDate) && lesson.getData().isBefore(startDate)) {
                lessons.add(lesson);
            }
        }
        return lessons;
    }
}
