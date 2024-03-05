package server_lab.repositories;

import server_lab.essence.Teacher;
import server_lab.exception.RepositoryException;

import java.util.List;

public interface IRepositoryTeacher {
    /**
     * добавление преподавателя
     * @param teacher преподаватель (с id == null)
     * @return id (!= null) добавленого преподавателя
     */
    long addTeacher(Teacher teacher) throws RepositoryException;

    /**
     * редактирование преподавателя
     * @param teacher преподаватель (с id != null)
     */
    void editTeacher(Teacher teacher) throws RepositoryException;

    /**
     * удаление преподавателя
     * @param id id преподавателя
     */
    void deleteTeacher(long id) throws RepositoryException;

    /**
     * получение преподавателя по id
     * @param id id преподавателя
     * @return преподаватель
     */
    Teacher getTeacherById(long id) throws RepositoryException;

    /**
     * получение всех преподавателей
     * @return список всех преподавателей
     */
    List<Teacher> getTeachers() throws RepositoryException;
}
