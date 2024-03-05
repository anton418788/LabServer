package server_lab.validator.lesson;

import server_lab.request.lesson.GetLessonByIdRequest;
import server_lab.validator.Validator;
import server_lab.validator.primitive.ValidatorId;

import java.util.ArrayList;
import java.util.List;

public class GetLessonByIdValidator implements Validator<GetLessonByIdRequest> {
    private ValidatorId validatorId;

    @Override
    public List<String> validator(GetLessonByIdRequest request) {
        List<String> errors = new ArrayList<>();

        validatorId.validateIdNotZero(request.getId(), errors, "id", "zero");

        return errors;
    }
}
