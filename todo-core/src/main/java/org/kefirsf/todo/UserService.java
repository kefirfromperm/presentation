package org.kefirsf.todo;

public class UserService {
    public boolean authenticate(String username, String password) {
        return username.equals("test@example.com") && password.equals("password");
    }
}
