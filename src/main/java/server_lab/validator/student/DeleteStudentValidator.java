package server_lab.validator.student;

import server_lab.validator.Validator;
import server_lab.request.student.DeleteStudentRequest;
import server_lab.validator.primitive.ValidatorId;

import java.util.ArrayList;
import java.util.List;

public class DeleteStudentValidator implements Validator<DeleteStudentRequest> {
    private ValidatorId validatorId;

    public DeleteStudentValidator(ValidatorId validatorId) {
        this.validatorId = validatorId;
    }

    @Override
    public List<String> validator(DeleteStudentRequest request) {
        List<String> errors = new ArrayList<>();

        validatorId.validateIdNotZero(request.getId(), errors, "id", "zero");

        return errors;
    }
}
