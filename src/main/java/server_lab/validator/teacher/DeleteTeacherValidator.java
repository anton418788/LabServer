package server_lab.validator.teacher;

import server_lab.request.teacher.DeleteTeacherRequest;
import server_lab.validator.Validator;
import server_lab.validator.primitive.ValidatorId;

import java.util.ArrayList;
import java.util.List;

public class DeleteTeacherValidator implements Validator<DeleteTeacherRequest> {
    private ValidatorId validatorId;

    @Override
    public List<String> validator(DeleteTeacherRequest request) {
        List<String> errors = new ArrayList<>();

        validatorId.validateIdNotZero(request.getId(), errors, "Id", "zero");

        return errors;
    }
}
