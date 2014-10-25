package week6.classwork.arcitecture.Domain;


import org.hibernate.Hibernate;
import org.hibernate.Session;
import week6.classwork.arcitecture.DAO.HibernateUtil;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 07.06.2014
 * Time: 17:59
 * To change this template use File|Setting|File Templates.
 */

@Entity
@Table(name = "notebooks")


public class Notebook implements Serializable {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_NOTEBOOK_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    private long id;

    @Column(name = "NOTEBOOK_ID")
    private long notebookID;

    @Column(name = "SERIAL_NUMBER")
    private long serialNumber;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "PRICE")
    private long price;


    public Notebook(long serialNumber, String brand, String model, Date creationDate, long price) {
        this.serialNumber = serialNumber;
        this.brand = brand;
        this.model = model;
        this.creationDate = creationDate;
        this.price = price;
    }

    public Notebook() {

    }


    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", notebookID=" + notebookID +
                ", serialNumber=" + serialNumber +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", creationDate=" + creationDate +
                ", price=" + price +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNotebookID() {
        return notebookID;
    }

    public void setNotebookID(long notebookID) {
        this.notebookID = notebookID;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Notebook getById(long notebook_id) {
        Session session = null;
        Notebook notebook = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            notebook = (Notebook) session.load(Notebook.class, notebook_id);
            Hibernate.initialize(notebook);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return notebook;
    }
}

