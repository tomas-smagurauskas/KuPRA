package api.domain.datatransferobjects;

import api.domain.entities.authentication.enums.UserRole;

/**
 * Created by tomas on 14.12.7.
 */
public class UserDTO {

    private String username;
    private UserRole role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
