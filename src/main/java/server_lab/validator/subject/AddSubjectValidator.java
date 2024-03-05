package server_lab.validator.subject;

import server_lab.request.subject.AddSubjectRequest;
import server_lab.validator.Validator;
import server_lab.validator.primitive.ValidateString;

import java.util.ArrayList;
import java.util.List;

public class AddSubjectValidator implements Validator<AddSubjectRequest> {
    private ValidateString validateString;

    @Override
    public List<String> validator(AddSubjectRequest request) {

        List<String> errors = new ArrayList<>();
        validateString.validateStringNotEmpty(request.getName(), errors, "name", "empty");
        validateString.validateStringNotNull(request.getName(), errors, "name", "null");
        validateString.validateStringBig(request.getName(), errors, "name", "big", 20);

        return errors;
    }
}
