package api.domain.entities.measurementunits;

import javax.persistence.*;

/**
 * Created by tomas on 14.12.7.
 */
@Entity
@Table(name = "measurementUnits")
public class MeasurementUnit {

    private Integer id;
    private String name;

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
}
