package week8.homework.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 18.06.2014
 * Time: 12:26
 * To change this template use File|Setting|File Templates.
 */
/*
Память(производитель, размер MANUFACTURER)
*/

@Entity
@Table(name = "MEMORY")
public class Memory implements Serializable {


    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_MEMORY_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Id
    @Column(name = "MEMORY_ID")
    private long id;

    @Column(name = "MEMORY_SIZE")
    private long size;

    @OneToMany(mappedBy = "memory", cascade = CascadeType.ALL)
    private Set<Notebook> notebooks = new HashSet<>();

    @ManyToOne
    Manufacturer manufacturer;


    public Memory(Manufacturer manufacturer, long size) {
        this.size = size;
        this.manufacturer = manufacturer;
    }

    public Memory() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "id=" + id +
                ", size=" + size +
                ", memoryManufacturer = " + manufacturer.getName() +
                '}';
    }


}
