package server_lab.validator.teacher;

import server_lab.request.teacher.GetTeacherByIdRequest;
import server_lab.validator.Validator;
import server_lab.validator.primitive.ValidatorId;

import java.util.ArrayList;
import java.util.List;

public class GetTeacherByIdValidator implements Validator<GetTeacherByIdRequest> {
    private ValidatorId validatorId;

    @Override
    public List<String> validator(GetTeacherByIdRequest request) {
        List<String> errors = new ArrayList<>();

        validatorId.validateIdNotZero(request.getId(), errors, "Id", "zero");

        return errors;
    }
}
