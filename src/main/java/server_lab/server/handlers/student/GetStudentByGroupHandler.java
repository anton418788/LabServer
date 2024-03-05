package server_lab.server.handlers.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import server_lab.controllers.ComonResponse;
import server_lab.controllers.ResponseEntity;
import server_lab.controllers.student.ControllerStudent;
import server_lab.exception.HandleException;
import server_lab.request.student.GetStudentByGroupRequest;
import server_lab.response.student.GetStudentByGroupResponse;
import server_lab.server.handlers.EndpointHandler;

public class GetStudentByGroupHandler implements EndpointHandler {
    private ControllerStudent controllerStudent;

    public GetStudentByGroupHandler(ControllerStudent controllerStudent) {
        this.controllerStudent = controllerStudent;
    }
    @Override
    public String handel(String json) throws HandleException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            GetStudentByGroupRequest request = mapper.readValue(json, GetStudentByGroupRequest.class);
            ResponseEntity<ComonResponse<GetStudentByGroupResponse>> res = controllerStudent.getStudentByGroup(request);

            ComonResponse<GetStudentByGroupResponse> comonResponse = res.getAnswer();
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
