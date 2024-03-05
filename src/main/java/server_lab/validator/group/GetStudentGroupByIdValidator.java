package server_lab.validator.group;

import server_lab.validator.Validator;
import server_lab.request.group.GetStudentGroupByIdRequest;
import server_lab.validator.primitive.ValidatorId;

import java.util.ArrayList;
import java.util.List;

public class GetStudentGroupByIdValidator implements Validator<GetStudentGroupByIdRequest> {
    private ValidatorId validatorId;

    public GetStudentGroupByIdValidator(ValidatorId validatorId) {
        this.validatorId = validatorId;
    }

    @Override
    public List<String> validator(GetStudentGroupByIdRequest request) {
        List<String> errors = new ArrayList<>();

        validatorId.validateIdNotZero(request.getId(), errors, "id", "zero");

        return errors;
    }
}
