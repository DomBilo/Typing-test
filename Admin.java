package TypingTestVer11;

import java.util.Map;
import java.util.List;

public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    public Admin(String username, String password, Map<String, List<Result>> resultsByLevel) {
        super(username, password, resultsByLevel);
    }


    @Override
    public String toString() {
        return "Admin: " + super.toString();
    }
}