package learning.junit5.nested;

public class UserValidator {
    public boolean isValidUsername(String username) {
        return username != null
                && username.length() >= 3
                && username.length() <= 12
                && username.matches("[a-zA-Z0-9]+");
    }
}
