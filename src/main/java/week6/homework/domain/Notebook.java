package week6.homework.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 10.06.2014
 * Time: 11:47
 * To change this template use File|Setting|File Templates.
 */
/*
Создать DAO для таблицы ноутбуки
Таблица ноутбуки имеет следующую структуру
(id, serial, vendor, model, manufactor date, price
*/
@Entity
@Table(name = "noteboks")

public class Notebook implements Serializable {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_NOTEBOOK_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column(name = "NOTEBOOK_ID")
    private long id;


    @Column(name = "NOTEBOOK_SERIAL")
    private long serial;


    @Column(name = "NOTEBOOK_VENDOR")
    private String vendor;

    @Column(name = "NOTEBOOK_MODEL")
    private String model;


    @Column(name = "NOTEBOOK_MANUFACTOR")
    private String manufactor;

    @Column(name = "NOTEBOOK_DATE")
    private Date date;

    @Column(name = "NOTEBOOK_PRICE")
    private long price;

    public Notebook(long serial, String vendor, String model, String manufactor, Date date, long price) {
        this.serial = serial;
        this.vendor = vendor;
        this.model = model;
        this.manufactor = manufactor;
        this.date = date;
        this.price = price;
    }

    public Notebook() {

    }


    @Override
    public String toString() {
        return "Notebook " +
                "id=" + id +
                ", serial=" + serial +
                ", vendor='" + vendor + '\'' +
                ", model='" + model + '\'' +
                ", manufactor='" + manufactor + '\'' +
                ", date=" + date +
                ", price=" + price;
    }


    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSerial() {
        return serial;
    }

    public void setSerial(long serial) {
        this.serial = serial;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufactor() {
        return manufactor;
    }

    public void setManufactor(String manufactor) {
        this.manufactor = manufactor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
