package week9.homework.notebookSpringAnotation.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 18.06.2014
 * Time: 12:48
 * To change this template use File|Setting|File Templates.
 */


/*
* 	Продажи(тип ноутбука, дата продажи, количество)
*/

@Entity
@Table(name = "SALES")
public class Sales implements Serializable {


    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_SALES_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Id
    @Column(name = "SALES_ID")
    private long id;

    @Column(name = "SALE_DATE")
    private String saleDate;

    @Column(name = "NUMBER_NUM")
    private long number;

    @ManyToOne
    Warehouse warehouse;

    public Sales(Warehouse warehouse, String saleDate, long number) {
        this.saleDate = saleDate;
        this.number = number;
        this.warehouse = warehouse;


    }

    public Sales() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", saleDate='" + saleDate + '\'' +
                ", number=" + number +
                '}';
    }

}
