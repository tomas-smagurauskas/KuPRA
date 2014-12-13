package api.domain.entities.recipes;

import javax.persistence.*;

/**
 * Created by tomas on 14.12.13.
 */
@Entity
@Table(name = "recipePhotos")
public class RecipePhoto {

    private Integer id;
    private String content;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
