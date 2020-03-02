package lv.itlat.helloweb.helper;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class FormValidator {
    Map<String, String> errors = new HashMap<>();

    public void validateRegistration(String firstName, String lastName, String email) {
        errors.clear();
        if (firstName == null || firstName.isEmpty()) {
            errors.put("firstName", "FirstName can not be empty.");
        }
        if (lastName == null || lastName.isEmpty()) {
            errors.put("lastName", "LastName can not be empty.");
        }
        if (email == null || email.isEmpty()) {
            errors.put("email", "email can not be empty.");
        }
    }
    public Map<String, String> getErrors() {
        return errors;
    }
}


