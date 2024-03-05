package server_lab.server.handlers.group;

import com.fasterxml.jackson.databind.ObjectMapper;
import server_lab.controllers.ComonResponse;
import server_lab.controllers.ResponseEntity;
import server_lab.controllers.group.ControllerGroup;
import server_lab.exception.HandleException;
import server_lab.request.group.AddStudentGroupsRequest;
import server_lab.response.group.AddStudentGroupsResponse;
import server_lab.server.handlers.EndpointHandler;

public class AddStudentGroupsHandler implements EndpointHandler {
    private ControllerGroup controllerGroup;

    public AddStudentGroupsHandler(ControllerGroup controllerGroup) {
        this.controllerGroup = controllerGroup;
    }

    @Override
    public String handel(String json) throws HandleException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            AddStudentGroupsRequest request = mapper.readValue(json, AddStudentGroupsRequest.class);
            ResponseEntity<ComonResponse<AddStudentGroupsResponse>> res = controllerGroup.addStudentGroups(request);

            ComonResponse<AddStudentGroupsResponse> comonResponse = res.getAnswer();
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

