package server_lab.validator.group;

import server_lab.request.group.AddStudentGroupsRequest;
import server_lab.validator.primitive.ValidateString;
import server_lab.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class AddStudentGroupsValidator implements Validator<AddStudentGroupsRequest> {
    private ValidateString validateString;

    public AddStudentGroupsValidator(ValidateString validateString) {
        this.validateString = validateString;
    }

    @Override
    public List<String> validator(AddStudentGroupsRequest request) {

        List<String> errors = new ArrayList<>();
        validateString.validateStringNotEmpty(request.getName(), errors, "name", "empty");
        validateString.validateStringNotNull(request.getName(), errors, "name", "null");
        validateString.validateStringBig(request.getName(), errors, "name", "big", 15);

        return errors;
    }
}
