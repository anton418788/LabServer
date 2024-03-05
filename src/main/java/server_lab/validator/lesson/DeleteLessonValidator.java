package server_lab.validator.lesson;

import server_lab.request.lesson.DeleteLessonRequest;
import server_lab.validator.Validator;
import server_lab.validator.primitive.ValidatorId;

import java.util.ArrayList;
import java.util.List;

public class DeleteLessonValidator implements Validator<DeleteLessonRequest> {
    private ValidatorId validatorId;

    @Override
    public List<String> validator(DeleteLessonRequest request) {
        List<String> errors = new ArrayList<>();

        validatorId.validateIdNotZero(request.getId(), errors, "Id", "zero");

        return errors;
    }
}
