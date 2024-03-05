package server_lab.server.handlers.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import server_lab.controllers.ComonResponse;
import server_lab.controllers.ResponseEntity;
import server_lab.controllers.student.ControllerStudent;
import server_lab.exception.HandleException;
import server_lab.request.student.DeleteStudentRequest;
import server_lab.response.student.DeleteStudentResponse;
import server_lab.server.handlers.EndpointHandler;

public class DeleteStudentHandler implements EndpointHandler {
    private ControllerStudent controllerStudent;

    public DeleteStudentHandler(ControllerStudent controllerStudent) {
        this.controllerStudent = controllerStudent;
    }
    @Override
    public String handel(String json) throws HandleException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            DeleteStudentRequest request = mapper.readValue(json, DeleteStudentRequest.class);
            ResponseEntity<ComonResponse<DeleteStudentResponse>> res = controllerStudent.deleteStudent(request);

            ComonResponse<DeleteStudentResponse> comonResponse = res.getAnswer();
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
