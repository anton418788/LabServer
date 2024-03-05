package server_lab.server.handlers.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import server_lab.controllers.ComonResponse;
import server_lab.controllers.ResponseEntity;
import server_lab.controllers.student.ControllerStudent;
import server_lab.exception.HandleException;
import server_lab.request.student.EditStudentRequest;
import server_lab.response.student.EditStudentResponse;
import server_lab.server.handlers.EndpointHandler;

public class EditStudentHandler implements EndpointHandler {
    private ControllerStudent controllerStudent;

    public EditStudentHandler(ControllerStudent controllerStudent) {
        this.controllerStudent = controllerStudent;
    }
    @Override
    public String handel(String json) throws HandleException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            EditStudentRequest request = mapper.readValue(json, EditStudentRequest.class);
            ResponseEntity<ComonResponse<EditStudentResponse>> res = controllerStudent.editStudent(request);

            ComonResponse<EditStudentResponse> comonResponse = res.getAnswer();
            if (comonResponse.isOk()) {
                return mapper.writeValueAsString(res.getStatus()) + "::";
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
