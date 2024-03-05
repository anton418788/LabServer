package server_lab.validator.primitive;

import java.util.List;

public class ValidatorId {
    public ValidatorId() {
    }

    public boolean validateIdNotZero(long id, List<String> errors, String fieldName, String errorMessage) {
        if (id <= 0) {
            errors.add(fieldName + ": " + errorMessage);
            return false;
        }
        return true;
    }
}
