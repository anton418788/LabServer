package server_lab.repositories;

import server_lab.entity.Student;
import server_lab.exception.RepositoryException;

import java.util.List;

public interface IRepositoryStudent {
    /**
     * добавление студента
     * @param student студент (с id == null)
     * @return id (!= null) добавленого студента
     */
    long addStudent(Student student) throws RepositoryException;

    /**
     * редактирование студента
     * @param student студент (с id != null)
     */
    void editStudent(Student student) throws RepositoryException;

    /**
     * удаление студента
     * @param id id студента
     */
    void deleteStudent(long id) throws RepositoryException;

    /**
     * получение студента по id
     * @param id id студента
     * @return студент
     */
    Student getStudentById(long id) throws RepositoryException;

    /**
     * получение студентов по id группы
     * @param idGroup id группы
     * @return список студентов из группы
     */
    List<Student> getStudentByGroup(long idGroup) throws RepositoryException;
}
