package server_lab.validator.student;

import server_lab.validator.Validator;
import server_lab.request.student.GetStudentByIdRequest;
import server_lab.validator.primitive.ValidatorId;

import java.util.ArrayList;
import java.util.List;

public class GetStudentByIdValidator implements Validator<GetStudentByIdRequest> {
    private ValidatorId validatorId;

    public GetStudentByIdValidator(ValidatorId validatorId) {
        this.validatorId = validatorId;
    }

    @Override
    public List<String> validator( GetStudentByIdRequest request) {
        List<String> errors = new ArrayList<>();

        validatorId.validateIdNotZero(request.getId(), errors, "id", "zero");

        return errors;
    }
}
