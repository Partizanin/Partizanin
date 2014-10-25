package week9.homework.notebookSpringAnotation.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 18.06.2014
 * Time: 12:40
 * To change this template use File|Setting|File Templates.
 */

/*
* Склад ноутбуков(тип ноутбука, количество, цена)
*/

@Entity
@Table(name = "WAREHOUSE")
public class Warehouse implements Serializable {


    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_WAREHOUSE_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Id
    @Column(name = "WAREHOUSE_ID")
    private long id;

    @Column(name = "NUMBER_NUM")
    private long number;

    @Column(name = "PRICE")
    private long price;

    @OneToOne(cascade = CascadeType.ALL)
    private Notebook notebook;

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    Set<Sales> sales = new HashSet<>();

    public Warehouse(Notebook notebook, long number, long price) {

        this.number = number;
        this.price = price;
        this.notebook = notebook;
    }

    public Warehouse() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public Set<Sales> getSales() {
        return sales;
    }

    public void setSales(Set<Sales> sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", number=" + number +
                ", notebook=" + notebook.toString() +
                ", price=" + price +
                '}';
    }
}
