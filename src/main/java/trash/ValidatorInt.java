package trash;

import java.util.List;
// не доделан

public class ValidatorInt {
    public boolean validateIntNotZero(int i, List<String> errors, String fieldName, String errorMessage) {
        if (i <= 0) {
            errors.add(fieldName + ": " + errorMessage);
            return false;
        }
        return true;
    }
}
