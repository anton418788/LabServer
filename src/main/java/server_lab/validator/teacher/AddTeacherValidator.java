package server_lab.validator.teacher;

import server_lab.request.teacher.AddTeacherRequest;
import server_lab.validator.Validator;
import server_lab.validator.primitive.ValidateString;

import java.util.ArrayList;
import java.util.List;

public class AddTeacherValidator implements Validator<AddTeacherRequest> {
    private ValidateString validateString;

    public AddTeacherValidator(ValidateString validateString) {
        this.validateString = validateString;
    }

    @Override
    public List<String> validator(AddTeacherRequest request) {
        List<String> errors = new ArrayList<>();

        validateString.validateStringNotEmpty(request.getName(), errors, "name", "empty");
        validateString.validateStringNotNull(request.getName(), errors, "name", "null");
        validateString.validateStringBig(request.getName(), errors, "name", "big", 30);

        validateString.validateStringNotEmpty(request.getSurname(), errors, "surname", "empty");
        validateString.validateStringNotNull(request.getSurname(), errors, "surname", "null");
        validateString.validateStringBig(request.getSurname(), errors, "surname", "big", 30);

        validateString.validateStringNotEmpty(request.getPatronymic(), errors, "patronymic", "empty");
        validateString.validateStringNotNull(request.getPatronymic(), errors, "patronymic", "null");
        validateString.validateStringBig(request.getPatronymic(), errors, "patronymic", "big", 30);

        return errors;
    }
}
