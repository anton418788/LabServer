package server_lab.server.handlers.group;

import com.fasterxml.jackson.databind.ObjectMapper;
import server_lab.controllers.ComonResponse;
import server_lab.controllers.ResponseEntity;
import server_lab.controllers.group.ControllerGroup;
import server_lab.exception.HandleException;
import server_lab.request.group.EditStudentGroupsRequest;
import server_lab.response.group.EditStudentGroupsResponse;
import server_lab.server.handlers.EndpointHandler;

public class EditStudentGroupsHandler implements EndpointHandler {
    private ControllerGroup controllerGroup;

    public EditStudentGroupsHandler(ControllerGroup controllerGroup) {
        this.controllerGroup = controllerGroup;
    }
    @Override
    public String handel(String json) throws HandleException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            EditStudentGroupsRequest request = mapper.readValue(json, EditStudentGroupsRequest.class);
            ResponseEntity<ComonResponse<EditStudentGroupsResponse>> res = controllerGroup.editStudentGroups(request);

            ComonResponse<EditStudentGroupsResponse> comonResponse = res.getAnswer();
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
