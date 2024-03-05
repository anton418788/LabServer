package server_lab.controllers.student;

import server_lab.controllers.ComonResponse;
import server_lab.controllers.ResponseEntity;
import server_lab.request.student.*;
import server_lab.response.student.*;
import server_lab.services.student.*;
import server_lab.validator.student.*;

import java.util.List;

public class ControllerStudent {
    private AddStudentService addStudentService;
    private EditStudentService editStudentService;
    private DeleteStudentService deleteStudentService;
    private GetStudentByIdService getStudentByIdService;
    private GetStudentByGroupService getStudentByGroupService;
    private AddStudentValidator addStudentValidator;
    private EditStudentValidator editStudentValidator;
    private DeleteStudentValidator deleteStudentValidator;
    private GetStudentByIdValidator getStudentByIdValidator;
    private GetStudentByGroupValidator getStudentByGroupValidator;

    public ControllerStudent(AddStudentService addStudentService,
                             EditStudentService editStudentService,
                             DeleteStudentService deleteStudentService,
                             GetStudentByIdService getStudentByIdService,
                             GetStudentByGroupService getStudentByGroupService,
                             AddStudentValidator addStudentValidator,
                             EditStudentValidator editStudentValidator,
                             DeleteStudentValidator deleteStudentValidator,
                             GetStudentByIdValidator getStudentByIdValidator,
                             GetStudentByGroupValidator getStudentByGroupValidator) {
        this.addStudentService = addStudentService;
        this.editStudentService = editStudentService;
        this.deleteStudentService = deleteStudentService;
        this.getStudentByIdService = getStudentByIdService;
        this.getStudentByGroupService = getStudentByGroupService;
        this.addStudentValidator = addStudentValidator;
        this.editStudentValidator = editStudentValidator;
        this.deleteStudentValidator = deleteStudentValidator;
        this.getStudentByIdValidator = getStudentByIdValidator;
        this.getStudentByGroupValidator = getStudentByGroupValidator;
    }

    public ResponseEntity<ComonResponse<AddStudentResponse>> addStudent(AddStudentRequest request) {
        int status = 200;
        ComonResponse<AddStudentResponse> comonResponse;

        List<String> errors = addStudentValidator.validator(request);

        if (errors.isEmpty()) {
            try {
                comonResponse = new ComonResponse<>(addStudentService.addStudent(request));
            } catch (Exception exception) {
                status = 422;
                comonResponse = new ComonResponse<>(6, exception.getMessage(), errors); // своё сообщение об ошибке
            }
        } else {
            status = 400;
            comonResponse = new ComonResponse<>(6, "Validation error", errors); // своё сообщение об ошибке
        }

        return new ResponseEntity<>(comonResponse, status);
    }

    public ResponseEntity<ComonResponse<EditStudentResponse>> editStudent(EditStudentRequest request) {
        int status = 200;
        ComonResponse<EditStudentResponse> comonResponse;

        List<String> errors = editStudentValidator.validator(request);

        if (errors.isEmpty()) {
            try {
                comonResponse = new ComonResponse<>(editStudentService.editStudent(request));
            } catch (Exception exception) {
                status = 422;
                comonResponse = new ComonResponse<>(6, exception.getMessage(), errors); // своё сообщение об ошибке
            }
        } else {
            status = 400;
            comonResponse = new ComonResponse<>(6, "Validation error", errors); // своё сообщение об ошибке
        }

        return new ResponseEntity<>(comonResponse, status);
    }

    public ResponseEntity<ComonResponse<DeleteStudentResponse>> deleteStudent(DeleteStudentRequest request) {
        int status = 200;
        ComonResponse<DeleteStudentResponse> comonResponse;

        List<String> errors = deleteStudentValidator.validator(request);

        if (errors.isEmpty()) {
            try {
                comonResponse = new ComonResponse<>(deleteStudentService.deleteStudent(request));
            } catch (Exception exception) {
                status = 422;
                comonResponse = new ComonResponse<>(6, exception.getMessage(), errors); // своё сообщение об ошибке
            }
        } else {
            status = 400;
            comonResponse = new ComonResponse<>(6, "Validation error", errors); // своё сообщение об ошибке
        }

        return new ResponseEntity<>(comonResponse, status);
    }

    public ResponseEntity<ComonResponse<GetStudentByIdResponse>> getStudentById(GetStudentByIdRequest request) {
        int status = 200;
        ComonResponse<GetStudentByIdResponse> comonResponse;

        List<String> errors = getStudentByIdValidator.validator(request);

        if (errors.isEmpty()) {
            try {
                comonResponse = new ComonResponse<>(getStudentByIdService.getStudentById(request));
            } catch (Exception exception) {
                status = 422;
                comonResponse = new ComonResponse<>(6, exception.getMessage(), errors); // своё сообщение об ошибке
            }
        } else {
            status = 400;
            comonResponse = new ComonResponse<>(6, "Validation error", errors); // своё сообщение об ошибке
        }

        return new ResponseEntity<>(comonResponse, status);
    }

    public ResponseEntity<ComonResponse<GetStudentByGroupResponse>> getStudentByGroup(GetStudentByGroupRequest request) {
        int status = 200;
        ComonResponse<GetStudentByGroupResponse> comonResponse;

        List<String> errors = getStudentByGroupValidator.validator(request);

        if (errors.isEmpty()) {
            try {
                comonResponse = new ComonResponse<>(getStudentByGroupService.getStudentByGroup(request));
            } catch (Exception exception) {
                status = 422;
                comonResponse = new ComonResponse<>(6, exception.getMessage(), errors); // своё сообщение об ошибке
            }
        } else {
            status = 400;
            comonResponse = new ComonResponse<>(6, "Validation error", errors); // своё сообщение об ошибке
        }

        return new ResponseEntity<>(comonResponse, status);
    }
}
