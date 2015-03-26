package week9.homework.notebookSpringAnotation.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 18.06.2014
 * Time: 12:03
 * To change this template use File|Setting|File Templates.
 */

/*
*  Производители(имя)
*/

@Entity
@Table(name = "MANUFACTURER")
public class Manufacturer implements Serializable {


    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_MANUFACTURER_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Id
    @Column(name = "MANUFACTURER_ID")
    private long id;

    @Column(name = "MANUFACTURER_NAME")
    private String name;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL)
    private Set<Notebook> notebooks = new HashSet<>();

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL)
    private Set<Memory> memories = new HashSet<>();

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL)
    private Set<Processor> processors = new HashSet<>();

    public Manufacturer(String name) {
        this.name = name;
    }

    public Manufacturer() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        return "Manufacturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    public Set<Notebook> getNotebooks() {
        return notebooks;
    }

    public void setNotebooks(Set<Notebook> notebooks) {
        this.notebooks = notebooks;
    }

    public Set<Processor> getProcessors() {
        return processors;
    }

    public void setProcessors(Set<Processor> processors) {
        this.processors = processors;
    }

    public Set<Memory> getMemories() {
        return memories;
    }

    public void setMemories(Set<Memory> memories) {
        this.memories = memories;
    }
}
