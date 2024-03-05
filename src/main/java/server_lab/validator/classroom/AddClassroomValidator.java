package server_lab.validator.classroom;
import server_lab.request.classroom.AddClassroomRequest;
import server_lab.validator.Validator;
import server_lab.validator.primitive.ValidateString;

import java.util.ArrayList;
import java.util.List;

public class AddClassroomValidator {
    private ValidateString validateString;

    public AddClassroomValidator(ValidateString validateString) {
        this.validateString = validateString;
    }

    public List<String> validator(AddClassroomRequest request) {
        List<String> errors = new ArrayList<>();

        validateString.validateStringNotEmpty(request.getClassroom_number(), errors, "name", "empty");
        validateString.validateStringNotNull(request.getClassroom_number(), errors, "name", "null");
        return errors;
    }
}
