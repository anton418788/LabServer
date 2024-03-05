package server_lab.server.handlers.teacher;

import com.fasterxml.jackson.databind.ObjectMapper;
import server_lab.controllers.ComonResponse;
import server_lab.controllers.ResponseEntity;

import server_lab.controllers.teacher.ControllerTeacher;
import server_lab.exception.HandleException;

import server_lab.request.teacher.AddTeacherRequest;

import server_lab.response.teacher.AddTeacherResponse;
import server_lab.server.handlers.EndpointHandler;

public class AddTeacherHandler implements EndpointHandler {
    private ControllerTeacher controllerTeacher;

    public AddTeacherHandler(ControllerTeacher controllerTeacher) {
        this.controllerTeacher = controllerTeacher;
    }

    @Override
    public String handel(String json) throws HandleException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            AddTeacherRequest request = mapper.readValue(json, AddTeacherRequest.class);
            ResponseEntity<ComonResponse<AddTeacherResponse>> res = controllerTeacher.addTeacher(request);

            ComonResponse<AddTeacherResponse> comonResponse = res.getAnswer();
            if (comonResponse.isOk()) {
                return mapper.writeValueAsString(res.getStatus()) + "::"
                        + mapper.writeValueAsString(comonResponse.getData());
            } else {
                return mapper.writeValueAsString(res.getStatus()) + "::"
                        + mapper.writeValueAsString(comonResponse.getCodeError()) + ":"
                        + mapper.writeValueAsString(comonResponse.getMessageError()) + ":"
                        + mapper.writeValueAsString(comonResponse.getDetails());
            }
        } catch (Exception e) {
            throw new HandleException(e.getMessage());
        }
    }
}
