package server_lab.validator.student;

import server_lab.validator.Validator;
import server_lab.request.student.GetStudentByGroupRequest;
import server_lab.validator.primitive.ValidatorId;

import java.util.ArrayList;
import java.util.List;

public class GetStudentByGroupValidator implements Validator<GetStudentByGroupRequest> {
    private ValidatorId validatorId;

    public GetStudentByGroupValidator(ValidatorId validatorId) {
        this.validatorId = validatorId;
    }

    @Override
    public List<String> validator(GetStudentByGroupRequest request) {
        List<String> errors = new ArrayList<>();

        validatorId.validateIdNotZero(request.getGroupId(), errors, "groupId", "zero");

        return errors;
    }
}
