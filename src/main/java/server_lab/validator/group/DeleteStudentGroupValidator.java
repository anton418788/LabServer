package server_lab.validator.group;

import server_lab.validator.Validator;
import server_lab.request.group.DeleteStudentGroupRequest;
import server_lab.validator.primitive.ValidatorId;

import java.util.ArrayList;
import java.util.List;

public class DeleteStudentGroupValidator implements Validator<DeleteStudentGroupRequest> {
    private ValidatorId validatorId;

    public DeleteStudentGroupValidator(ValidatorId validatorId) {
        this.validatorId = validatorId;
    }

    @Override
    public List<String> validator(DeleteStudentGroupRequest request) {
        List<String> errors = new ArrayList<>();

        validatorId.validateIdNotZero(request.getId(), errors, "id", "zero");

        return errors;
    }
}

