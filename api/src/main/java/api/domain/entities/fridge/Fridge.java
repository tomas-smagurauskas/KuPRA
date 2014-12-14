package api.domain.entities.fridge;

import api.domain.entities.authentication.User;

import javax.persistence.*;
import java.util.List;

/**
 * Created by tomas on 14.12.14.
 */
@Entity
@Table(name = "fridge")
public class Fridge {

    private Integer id;
    private List<FridgeItem> fridgeItems;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "fridge")
    public List<FridgeItem> getFridgeItems() {
        return fridgeItems;
    }

    public void setFridgeItems(List<FridgeItem> fridgeItems) {
        this.fridgeItems = fridgeItems;
    }

    @OneToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
