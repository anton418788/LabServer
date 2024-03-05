package server_lab.server.handlers.classroom;

import com.fasterxml.jackson.databind.ObjectMapper;
import server_lab.controllers.ComonResponse;
import server_lab.controllers.ResponseEntity;


import server_lab.controllers.classroom.ControllerClassroom;
import server_lab.exception.HandleException;


import server_lab.request.classroom.AddClassroomRequest;
import server_lab.response.classroom.AddClassroomResponse;
import server_lab.server.handlers.EndpointHandler;

public class AddClassroomHandler implements EndpointHandler {
    private ControllerClassroom controllerClassroom;

    public AddClassroomHandler(ControllerClassroom controllerClassroom) {
        this.controllerClassroom = controllerClassroom;
    }

    @Override
    public String handel(String json) throws HandleException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            AddClassroomRequest request = mapper.readValue(json, AddClassroomRequest.class);
            ResponseEntity<ComonResponse<AddClassroomResponse>> res = controllerClassroom.addClassroom(request);

            ComonResponse<AddClassroomResponse> comonResponse = res.getAnswer();
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
