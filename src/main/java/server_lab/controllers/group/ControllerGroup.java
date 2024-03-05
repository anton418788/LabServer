package server_lab.controllers.group;

import server_lab.controllers.ComonResponse;
import server_lab.controllers.ResponseEntity;
import server_lab.request.group.*;
import server_lab.response.group.*;
import server_lab.services.group.*;
import server_lab.validator.group.*;

import java.util.ArrayList;
import java.util.List;

public class ControllerGroup {
    private final AddStudentGroupsService addStudentGroupsService;
    private final DeleteStudentGroupService deleteStudentGroupService;
    private final EditStudentGroupsService editStudentGroupsService;
    private final GetStudentGroupsService getStudentGroupsService;
    private final GetStudentGroupByIdService getStudentGroupByIdService;
    private final AddStudentGroupsValidator addStudentGroupsValidator;
    private final EditStudentGroupsValidator editStudentGroupsValidator;
    private final DeleteStudentGroupValidator deleteStudentGroupValidator;
    private final GetStudentGroupByIdValidator getStudentGroupByIdValidator;

    public ControllerGroup(AddStudentGroupsService addStudentGroupsService,
                           DeleteStudentGroupService deleteStudentGroupService,
                           EditStudentGroupsService editStudentGroupsService,
                           GetStudentGroupsService getStudentGroupsService,
                           GetStudentGroupByIdService getStudentGroupByIdService,
                           AddStudentGroupsValidator addStudentGroupsValidator,
                           EditStudentGroupsValidator editStudentGroupsValidator,
                           DeleteStudentGroupValidator deleteStudentGroupValidator,
                           GetStudentGroupByIdValidator getStudentGroupByIdValidator) {
        this.editStudentGroupsService = editStudentGroupsService;
        this.deleteStudentGroupService = deleteStudentGroupService;
        this.addStudentGroupsService = addStudentGroupsService;
        this.getStudentGroupByIdService = getStudentGroupByIdService;
        this.getStudentGroupsService = getStudentGroupsService;
        this.addStudentGroupsValidator = addStudentGroupsValidator;
        this.editStudentGroupsValidator = editStudentGroupsValidator;
        this.deleteStudentGroupValidator = deleteStudentGroupValidator;
        this.getStudentGroupByIdValidator = getStudentGroupByIdValidator;
    }
    public ResponseEntity<ComonResponse<AddStudentGroupsResponse>> addStudentGroups(AddStudentGroupsRequest request) {
        int status = 200;
        ComonResponse<AddStudentGroupsResponse> comonResponse;

        List<String> errors = addStudentGroupsValidator.validator(request);

        if (errors.isEmpty()) {
            try {
                comonResponse = new ComonResponse<>(addStudentGroupsService.addStudentGroups(request));
            } catch (Exception exception) {
                status = 422;
                comonResponse = new ComonResponse<>(6, exception.getMessage(), errors);
            }
        } else {
            status = 400;
            comonResponse = new ComonResponse<>(6, "Validation error", errors);
            //comonResponse = new ComonResponse<>(6, "Error", errors);
        }

        return new ResponseEntity<>(comonResponse, status);
    }

    public ResponseEntity<ComonResponse<EditStudentGroupsResponse>> editStudentGroups(EditStudentGroupsRequest request) {
        int status = 200;
        ComonResponse<EditStudentGroupsResponse> comonResponse;

        List<String> errors = editStudentGroupsValidator.validator(request);

        if (errors.isEmpty()) {
            try {
                comonResponse = new ComonResponse<>(editStudentGroupsService.editStudentGroups(request));
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

    public ResponseEntity<ComonResponse<DeleteStudentGroupResponse>> deleteStudentGroup(DeleteStudentGroupRequest request) {
        int status = 200;
        ComonResponse<DeleteStudentGroupResponse> comonResponse;

        List<String> errors = deleteStudentGroupValidator.validator(request);

        if (errors.isEmpty()) {
            try {
                comonResponse = new ComonResponse<>(deleteStudentGroupService.deleteStudentGroup(request));
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

    public ResponseEntity<ComonResponse<GetStudentGroupByIdResponse>> getStudentGroupById(GetStudentGroupByIdRequest request) {
        int status = 200;
        ComonResponse<GetStudentGroupByIdResponse> comonResponse;

        List<String> errors = getStudentGroupByIdValidator.validator(request);

        if (errors.isEmpty()) {
            try {
                comonResponse = new ComonResponse<>(getStudentGroupByIdService.getStudentGroupById(request));
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

    public ResponseEntity<ComonResponse<GetStudentGroupsResponse>> getStudentGroups(GetStudentGroupsRequest request) {
        int status = 200;
        ComonResponse<GetStudentGroupsResponse> comonResponse;

        try {
            comonResponse = new ComonResponse<>(getStudentGroupsService.getStudentGroups(request));
        } catch (Exception exception) {
            status = 422;
            comonResponse = new ComonResponse<>(6, "Error", new ArrayList<>()); // своё сообщение об ошибке
        }

        return new ResponseEntity<>(comonResponse, status);
    }
}
