package server_lab.repositories;

import server_lab.entity.Subject;
import server_lab.exception.RepositoryException;

import java.util.List;

public interface IRepositorySubject {
    /** обавление новой дисцеплины
     * @param subject дисцеплина (с id == null)
     * @return id (!= null) добавленой дисцеплины
     */
    long addSubject(Subject subject) throws RepositoryException;

    /**
     * редактирование дисцеплины
     * @param subject дисцеплина (с id != null)
     */
    void editSubject(Subject subject) throws RepositoryException;

    /**
     * удаление дисцеплины
     * @param id id дисцеплины
     */
    void deleteSubject(long id) throws RepositoryException;

    /**
     * получение дисцеплины по id
     * @param id id дисцеплины
     * @return дисцеплина
     */
    Subject getSubjectById(long id) throws RepositoryException;

    /**
     * получение всех дисцеплин
     * @return список всех дисцеплин
     */
    List<Subject> getSubjects() throws RepositoryException;
}
