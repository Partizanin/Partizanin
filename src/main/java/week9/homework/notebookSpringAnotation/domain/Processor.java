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
 * Time: 12:11
 * To change this template use File|Setting|File Templates.
 */

/*
Процессоры(производитель, частота, модель)
*/
@Entity
@Table(name = "PROCESSOR")
public class Processor implements Serializable {


    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_PROCESSOR_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Id
    @Column(name = "PROCESSOR_ID")
    private long id;


    @Column(name = "PROCESSOR_FREQUENCY")
    private long frequency;


    @Column(name = "PROCESSOR_MODEL")
    private String model;

    @ManyToOne
    Manufacturer manufacturer;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "processor")
    private Notebook notebook;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "processor", cascade = CascadeType.ALL)
    private Set<Notebook> notebooks = new HashSet<>();


    public Processor(Manufacturer manufacturer, long frequency, String model) {
        this.frequency = frequency;
        this.model = model;
        this.manufacturer = manufacturer;
    }

    public Processor() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getFrequency() {
        return frequency;
    }

    public void setFrequency(long frequency) {
        this.frequency = frequency;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }


    public Set<Notebook> getNotebooks() {
        return notebooks;
    }

    public void setNotebooks(Set<Notebook> notebooks) {
        this.notebooks = notebooks;
    }


    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Processor{" +
                "id=" + id +
                ", frequency=" + frequency +
                ", model='" + model + '\'' +
                ",manufacturer name=" + manufacturer.getName() +
                '}';
    }

}