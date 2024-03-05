package server_lab.validator.subject;

import server_lab.request.subject.DeleteSubjectRequest;
import server_lab.validator.Validator;
import server_lab.validator.primitive.ValidatorId;

import java.util.ArrayList;
import java.util.List;

public class DeleteSubjectValidator implements Validator<DeleteSubjectRequest> {
    private ValidatorId validatorId;

    @Override
    public List<String> validator(DeleteSubjectRequest request) {
        List<String> errors = new ArrayList<>();

        validatorId.validateIdNotZero(request.getId(), errors, "Id", "zero");

        return errors;
    }
}
