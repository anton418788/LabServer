package server_lab.validator.student;

import server_lab.validator.Validator;
import server_lab.request.student.EditStudentRequest;
import server_lab.validator.primitive.ValidateString;
import server_lab.validator.primitive.ValidatorId;

import java.util.ArrayList;
import java.util.List;

public class EditStudentValidator implements Validator<EditStudentRequest> {
    private ValidateString validateString;
    private ValidatorId validatorId;

    public EditStudentValidator(ValidateString validateString, ValidatorId validatorId) {
        this.validateString = validateString;
        this.validatorId = validatorId;
    }
    @Override
    public List<String> validator(EditStudentRequest request) {
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

        validateString.validateStringNotEmpty(request.getStatus(), errors, "status", "empty");
        validateString.validateStringNotNull(request.getStatus(), errors, "status", "null");
        validateString.validateStringStatus(request.getStatus(), errors, "status", "no status");

        validatorId.validateIdNotZero(request.getId(), errors, "id", "zero");

        validateString.validateStringNotEmpty(request.getGroupId(), errors, "groupId", "empty");
        validateString.validateStringNotNull(request.getGroupId(), errors, "groupId", "null");
        validateString.validateStringInt(request.getGroupId(), errors, "groupId", "no id");

        return errors;

    }
}
