package server_lab.validator;

import java.util.List;

/**
 * Валидатор для запросов
 * @param <T> класс запроса
 */
public interface Validator <T> {
    /**
     * Валидатор для запроса
     * @param request запрос
     * @return список ошибок
     */
    List<String> validator(T request);
}
