package api.domain.datatransferobjects;

import api.domain.entities.authentication.User;
import api.domain.entities.authentication.enums.UserRole;

/**
 * Created by tomas on 14.12.7.
 */
public class UserDTO {

    private String username;
    private UserRole role;
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static UserDTO fromEntity(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setUsername(user.getUsername());
        userDTO.setRole(user.getRole());
        userDTO.setId(user.getId());

        return userDTO;
    }
}
