package api.domain.entities.menu;

import api.domain.entities.authentication.User;

import javax.persistence.*;
import java.util.List;

/**
 * Created by tomas on 14.12.14.
 */
@Entity
@Table(name = "menus")
public class Menu {

    private Integer id;
    private User owner;
    private List<MenuItem> meals;

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
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu")
    public List<MenuItem> getMeals() {
        return meals;
    }

    public void setMeals(List<MenuItem> meals) {
        this.meals = meals;
    }
}
