package api.domain.entities;

import javax.persistence.*;

/**
 * Created by tomas on 14.10.12.
 */

@Entity
@Table(name= "adasasd")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID", nullable = false)
    private int id;

    @Column(name = "asd")
    private String asd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsd() {
        return asd;
    }

    public void setAsd(String asd) {
        this.asd = asd;
    }
}
