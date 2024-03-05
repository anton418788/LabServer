package server_lab.validator.group;

import server_lab.validator.Validator;
import server_lab.request.group.EditStudentGroupsRequest;
import server_lab.validator.primitive.ValidateString;
import server_lab.validator.primitive.ValidatorId;

import java.util.ArrayList;
import java.util.List;

public class EditStudentGroupsValidator implements Validator<EditStudentGroupsRequest> {
    private ValidateString validateString;
    private ValidatorId validatorId;

    public EditStudentGroupsValidator(ValidateString validateString, ValidatorId validatorId) {
        this.validateString = validateString;
        this.validatorId = validatorId;
    }

    @Override
    public List<String> validator(EditStudentGroupsRequest request) {
        List<String> errors = new ArrayList<>();

        validateString.validateStringNotEmpty(request.getName(), errors, "name", "empty");
        validateString.validateStringNotNull(request.getName(), errors, "name", "null");
        validateString.validateStringBig(request.getName(), errors, "name", "big", 15);

        validatorId.validateIdNotZero(request.getId(), errors, "id", "zero");

        return errors;
    }
}
