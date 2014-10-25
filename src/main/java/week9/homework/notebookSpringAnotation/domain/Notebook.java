package week9.homework.notebookSpringAnotation.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 18.06.2014
 * Time: 11:42
 * To change this template use File|Setting|File Templates.
 */

/*1. Создать сущности для базы данных "Магазин ноутбуков":
    Тип ноутбука(серийный номер, производитель, модель, дата производства)
	Процессоры(производитель, частота, модель)
	Память(производитель, размер)
	Склад ноутбуков(тип ноутбука, количество, цена)
	Продажи(тип ноутбука, дата продажи, количество)
	*/
@Entity
@Table(name = "NOTEBOOK")
public class Notebook implements Serializable {


    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_NOTEBOOKS_TYPE_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Id
    @Column(name = "NOTEBOOKS_ID")
    private long id;

    @Column(name = "SERIAL")
    private long serialNumber;

    @Column(name = "MANUFACTURER_DATE")
    private String manufacturerDate;

    @Column(name = "MODEL")
    private String model;


    @ManyToOne
    private Manufacturer manufacturer;

    @ManyToOne(cascade = CascadeType.ALL)
    private Memory memory;

    @ManyToOne(cascade = CascadeType.ALL)
    private Processor processor;

    @OneToOne(cascade = CascadeType.ALL)
    private Sales sales;

    @OneToOne(mappedBy = "notebook")
    private Warehouse warehouse;


    public Notebook(Manufacturer manufacturer, String model, String manufacturerDate, Processor processor, Memory memory) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.manufacturerDate = manufacturerDate;
        this.processor = processor;
        this.memory = memory;
    }

    public Notebook() {

    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturerDate() {
        return manufacturerDate;
    }

    public void setManufacturerDate(String notebooksManufacturer) {
        this.manufacturerDate = notebooksManufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    @Override
    public String toString() {
        return "NotebookType{" +
                "id=" + id +
                ", serialNumber=" + serialNumber +
                ", notebooksManufacturer='" + manufacturerDate + '\'' +
                '}';
    }

}
