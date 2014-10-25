package week6.classwork.regiontable;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 5/12/13
 */
@Entity
@Table(name = "REGIONS")
public class Region {
    @Id
    @SequenceGenerator(name = " sequence", sequenceName = "SEQ_REGIONS_ID", allocationSize = 6)

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "REGION_ID")


    private Long id;

    @Column(name = "REGION_NAME")
    private String name;

    public Region(String name, long id) {

        this.name = name;
        this.id = id;

    }

    public Region() {


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
