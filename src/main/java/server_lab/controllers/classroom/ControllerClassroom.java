package server_lab.controllers.classroom;

import server_lab.controllers.ComonResponse;
import server_lab.controllers.ResponseEntity;
import server_lab.request.classroom.AddClassroomRequest;
import server_lab.response.classroom.AddClassroomResponse;
import server_lab.services.classroom.AddClassroomService;
import server_lab.validator.classroom.AddClassroomValidator;

import java.util.List;

public class ControllerClassroom {
    private final AddClassroomService addClassroomService;
    private final AddClassroomValidator addClassroomValidator;

    public ControllerClassroom(AddClassroomService addClassroomService, AddClassroomValidator addClassroomValidator) {
        this.addClassroomService = addClassroomService;
        this.addClassroomValidator = addClassroomValidator;
    }
    public ResponseEntity<ComonResponse<AddClassroomResponse>> addClassroom(AddClassroomRequest request) {
        int status = 200;
        ComonResponse<AddClassroomResponse> comonResponse;

        List<String> errors = addClassroomValidator.validator(request);

        if (errors.isEmpty()) {
            try {
                comonResponse = new ComonResponse<>(addClassroomService.addClassroom(request));
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
