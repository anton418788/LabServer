package server_lab.controllers.teacher;

import server_lab.controllers.ComonResponse;
import server_lab.controllers.ResponseEntity;
import server_lab.request.teacher.AddTeacherRequest;
import server_lab.response.teacher.AddTeacherResponse;
import server_lab.services.teacher.AddTeacherService;
import server_lab.validator.teacher.AddTeacherValidator;

import java.util.List;

public class ControllerTeacher {
    private final AddTeacherService addTeacherService;
    private final AddTeacherValidator addTeacherValidator;

    public ControllerTeacher(AddTeacherService addTeacherService, AddTeacherValidator addTeacherValidator) {
        this.addTeacherService = addTeacherService;
        this.addTeacherValidator = addTeacherValidator;
    }
    public ResponseEntity<ComonResponse<AddTeacherResponse>> addTeacher(AddTeacherRequest request) {
        int status = 200;
        ComonResponse<AddTeacherResponse> comonResponse;

        List<String> errors = addTeacherValidator.validator(request);

        if (errors.isEmpty()) {
            try {
                comonResponse = new ComonResponse<>(addTeacherService.addTeacher(request));
            } catch (Exception exception) {
                status = 422;
                comonResponse = new ComonResponse<>(6, exception.getMessage(), errors);
            }
        } else {
            status = 400;
            comonResponse = new ComonResponse<>(6, "Validation error", errors);
        }

        return new ResponseEntity<>(comonResponse, status);
    }
}
