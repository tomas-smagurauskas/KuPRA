package api.domain.entities.fridge;

import api.domain.entities.ingredients.Ingredient;

import javax.persistence.*;

/**
 * Created by tomas on 14.12.14.
 */
@Entity
@Table(name = "fridgeItems")
public class FridgeItem {

    private Integer id;
    private Ingredient ingredient;
    private Integer quantity;

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
    @JoinColumn(name = "ingredient")
    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
