package server_lab.validator.lesson;

import server_lab.request.lesson.GetLessonsByGroupRequest;
import server_lab.validator.primitive.ValidateDate;
import server_lab.validator.Validator;
import server_lab.validator.primitive.ValidateString;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class GetLessonsByGroupValidator implements Validator<GetLessonsByGroupRequest> {
    private ValidateString validateString;
    private ValidateDate validateDate;

    @Override
    public List<String> validator(GetLessonsByGroupRequest request) {
        List<String> errors = new ArrayList<>();

        validateString.validateStringNotEmpty(request.getGroupId(), errors, "groupId", "empty");
        validateString.validateStringNotNull(request.getGroupId(), errors, "groupId", "null");
        validateString.validateStringInt(request.getGroupId(), errors, "groupId", "no id");

        validateString.validateStringNotEmpty(request.getStartDate(), errors, "startDate", "empty");
        validateString.validateStringNotNull(request.getStartDate(), errors, "startDate", "null");
        validateDate.validateStringDate(request.getStartDate(), errors, "startDate", "no date");

        validateString.validateStringNotEmpty(request.getEndDate(), errors, "endDate", "empty");
        validateString.validateStringNotNull(request.getEndDate(), errors, "endDate", "null");
        validateDate.validateStringDate(request.getEndDate(), errors, "endDate", "no date");

        try {
            validateDate.validateDateNotExceed(request.getStartDate(), request.getEndDate(),
                    errors, "startDate", "more endDate");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return errors;
    }
}
