package server_lab.server.handlers.group;

import com.fasterxml.jackson.databind.ObjectMapper;
import server_lab.controllers.ComonResponse;
import server_lab.controllers.ResponseEntity;
import server_lab.controllers.group.ControllerGroup;
import server_lab.exception.HandleException;
import server_lab.request.group.DeleteStudentGroupRequest;
import server_lab.response.group.DeleteStudentGroupResponse;
import server_lab.server.handlers.EndpointHandler;

public class DeleteStudentGroupHandler implements EndpointHandler {
    private ControllerGroup controllerGroup;

    public DeleteStudentGroupHandler(ControllerGroup controllerGroup) {
        this.controllerGroup = controllerGroup;
    }
    @Override
    public String handel(String json) throws HandleException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            DeleteStudentGroupRequest request = mapper.readValue(json, DeleteStudentGroupRequest.class);
            ResponseEntity<ComonResponse<DeleteStudentGroupResponse>> res = controllerGroup.deleteStudentGroup(request);

            ComonResponse<DeleteStudentGroupResponse> comonResponse = res.getAnswer();
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
