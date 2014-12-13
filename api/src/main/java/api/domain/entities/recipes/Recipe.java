package api.domain.entities.recipes;

import api.domain.entities.authentication.User;

import javax.persistence.*;
import java.util.List;

/**
 * Created by tomas on 14.12.13.
 */
@Entity
@Table(name = "recipes")
public class Recipe {

    private Integer id;
    private String name;
    private String description;
    private Integer quantity;
    private Integer duration;
    private Integer rating;
    private User author;
    private Boolean privacy;
    private List<RecipeIngredient> recipeIngredients;
    private List<RecipePhoto> recipePhotos;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Column(name = "duration")
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Column(name = "rating")
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @ManyToOne
    @JoinColumn(name = "author")
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Column(name = "privacy")
    public Boolean getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Boolean privacy) {
        this.privacy = privacy;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "recipeIngredients")
    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "recipePhotos")
    public List<RecipePhoto> getRecipePhoto() {
        return this.recipePhotos;
    }

    public void setRecipePhoto(List<RecipePhoto> recipePhotos) {
        this.recipePhotos = recipePhotos;
    }
}
