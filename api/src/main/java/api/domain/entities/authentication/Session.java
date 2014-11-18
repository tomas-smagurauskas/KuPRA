package api.domain.entities.authentication;

import javax.persistence.*;

/**
 * Created by tomas on 14.10.13.
 */
@Entity
@Table(name = "sessions")
public class Session {

    private Integer id;

    private User user;

    private String token;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
