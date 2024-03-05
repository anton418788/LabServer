package server_lab.validator.subject;

import server_lab.request.subject.GetSubjectByIdRequest;
import server_lab.validator.Validator;
import server_lab.validator.primitive.ValidatorId;

import java.util.ArrayList;
import java.util.List;

public class GetSubjectByIdValidator implements Validator<GetSubjectByIdRequest> {
    private ValidatorId validatorId;

    @Override
    public List<String> validator(GetSubjectByIdRequest request) {
        List<String> errors = new ArrayList<>();

        validatorId.validateIdNotZero(request.getId(), errors, "id", "zero");

        return errors;
    }
}
