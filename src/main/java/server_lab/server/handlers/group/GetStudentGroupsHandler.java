package server_lab.server.handlers.group;

import com.fasterxml.jackson.databind.ObjectMapper;
import server_lab.controllers.ComonResponse;
import server_lab.controllers.ResponseEntity;
import server_lab.controllers.group.ControllerGroup;
import server_lab.exception.HandleException;
import server_lab.request.group.GetStudentGroupsRequest;
import server_lab.response.group.GetStudentGroupsResponse;
import server_lab.server.handlers.EndpointHandler;

public class GetStudentGroupsHandler implements EndpointHandler {
    private ControllerGroup controllerGroup;

    public GetStudentGroupsHandler(ControllerGroup controllerGroup) {
        this.controllerGroup = controllerGroup;
    }

    @Override
    public String handel(String json) throws HandleException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            GetStudentGroupsRequest request = new GetStudentGroupsRequest();
            ResponseEntity<ComonResponse<GetStudentGroupsResponse>> res = controllerGroup.getStudentGroups(request);

            ComonResponse<GetStudentGroupsResponse> comonResponse = res.getAnswer();
            if (comonResponse.isOk()) {
                return mapper.writeValueAsString(res.getStatus()) + "::" + mapper.writeValueAsString(comonResponse.getData());
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
