package server_lab.server.handlers.group;

import com.fasterxml.jackson.databind.ObjectMapper;
import server_lab.controllers.ComonResponse;
import server_lab.controllers.ResponseEntity;
import server_lab.controllers.group.ControllerGroup;
import server_lab.exception.HandleException;
import server_lab.request.group.GetStudentGroupByIdRequest;
import server_lab.response.group.GetStudentGroupByIdResponse;
import server_lab.server.handlers.EndpointHandler;

public class GetStudentGroupByIdHandler implements EndpointHandler {
    private ControllerGroup controllerGroup;

    public GetStudentGroupByIdHandler(ControllerGroup controllerGroup) {
        this.controllerGroup = controllerGroup;
    }
    @Override
    public String handel(String json) throws HandleException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            GetStudentGroupByIdRequest request = mapper.readValue(json, GetStudentGroupByIdRequest.class);
            ResponseEntity<ComonResponse<GetStudentGroupByIdResponse>> res = controllerGroup.getStudentGroupById(request);

            ComonResponse<GetStudentGroupByIdResponse> comonResponse = res.getAnswer();
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
