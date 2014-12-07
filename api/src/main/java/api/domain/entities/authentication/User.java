package api.domain.entities.authentication;

import api.domain.entities.authentication.enums.UserRole;

import javax.persistence.*;

/**
 * Created by tomas on 14.10.12.
 */

@Entity
@Table(name= "users")
public class User {

    private Integer id;
    private String username;
    private String password;
    private UserRole role;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "role")
    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
