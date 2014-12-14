package api.domain.entities.menu;

import api.domain.entities.recipes.Recipe;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by tomas on 14.12.14.
 */
@Entity
@Table(name = "menuitems")
public class MenuItem {

    private Integer id;
    private Recipe meal;
    private Date time;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "meal")
    public Recipe getMeal() {
        return meal;
    }

    public void setMeal(Recipe meal) {
        this.meal = meal;
    }

    @Column(name = "time")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
