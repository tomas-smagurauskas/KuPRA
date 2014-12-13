package api.domain.entities.ingredients;

import api.domain.entities.measurementunits.MeasurementUnit;

import javax.persistence.*;

/**
 * Created by tomas on 14.12.13.
 */
@Entity
@Table(name = "ingredients")
public class Ingredient {

    private Integer id;
    private String name;
    private MeasurementUnit measurementUnit;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "measurementUnit")
    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnit measurementUnit) {
        this.measurementUnit = measurementUnit;
    }
}
