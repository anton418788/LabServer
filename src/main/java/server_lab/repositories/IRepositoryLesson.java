package server_lab.repositories;

import server_lab.essence.Lesson;
import server_lab.essence.VisitingLesson;
import server_lab.exception.RepositoryException;

import java.time.LocalDate;
import java.util.List;

public interface IRepositoryLesson {

    /**
     * добавление занятия
     * @param lesson занятие (с id == null)
     * @return id (!= null) добавленой занятия
     */
    long addLesson(Lesson lesson) throws RepositoryException;

    /**
     * изменение занятия
     * @param lesson занятие
     */
    void editLesson(Lesson lesson)throws RepositoryException;

    /**
     * удаление занятия
     * @param id id занятия
     */
    void deleteLesson(long id) throws RepositoryException;

    /**
     * получение занятия по id (с данными о посещаемости)
     * @param id id занятия
     * @return список посещения занятия с занятием
     */
    VisitingLesson GetLessonById(long id) throws RepositoryException;

    /**
     * получение списка занятий за период для группы (без информации о посещаемости)
     * @param idGroup id группы
     * @param startDate начальная дата
     * @param endDate конечная дата
     * @return занятие
     */
    List<Lesson> getLessonsByGroup(long idGroup, LocalDate startDate, LocalDate endDate) throws RepositoryException;

    /**
     * получение списка занятий за период для преподавателя (без информации о посещаемости)
     * @param teacherId id преподавателя
     * @param startDate начальная дата
     * @param endDate конечная дата
     * @return занятие
     */
    List<Lesson> getLessonsByTeacher(long teacherId, LocalDate startDate, LocalDate endDate) throws RepositoryException;






}
