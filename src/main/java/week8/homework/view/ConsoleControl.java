package week8.homework.view;


import week8.homework.domain.*;
import week8.homework.service.serviceimpl.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 19.06.2014
 * Time: 12:44
 * To change this template use File|Setting|File Templates.
 */
public class ConsoleControl {

    private ProcessorServiceimpl processor;

    private MemoryServiceimpl memory;

    private ManufacturerServiceimpl manufacturer;

    private NotebooksTypeServiceimpl notebooksType;

    private WarehouseServiceImpl warehouse;

    private SalesServiceimpl sales;

    public ConsoleControl(ProcessorServiceimpl processor, MemoryServiceimpl memory, ManufacturerServiceimpl manufacturer, NotebooksTypeServiceimpl notebooksType, WarehouseServiceImpl warehouse, SalesServiceimpl sales) {
        this.manufacturer = manufacturer;
        this.memory = memory;
        this.notebooksType = notebooksType;
        this.processor = processor;
        this.warehouse = warehouse;
        this.sales = sales;
    }

    public ConsoleControl() {

    }

    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int select;
        String menu = "\n0 - Exit" +
                "\n1 - Manufacturer" +
                "\n2 - Memory" +
                "\n3 - Notebook" +
                "\n4 - Processor" +
                "\n5 - Sales" +
                "\n6 - Warehouse" +
                "\n7 - Reports\n";


        for (; ; ) {

            System.out.println(menu);


            System.out.print("\nInput item: ");

            select = Integer.parseInt(reader.readLine());

            if (select == 0) {
                System.exit(1);
            } else if (select == 1) {
                manufacturer();
            } else if (select == 2) {
                memory();
            } else if (select == 3) {
                notebook();
            } else if (select == 4) {
                processor();
            } else if (select == 5) {
                sales();
            } else if (select == 6) {
                warhouse();
            } else if (select == 7) {
                reports();
            } else {

                System.err.println("\nYou input wring number,pleas try again");
            }
        }
    }

/*
* public Manufacturer(String name)
* public Memory(long size, String manufacturer)
* public  Notebook (long serialNumber,String manufacturer){
* public Processor(String manufacturer, long frequency, String model)
* public Sales(String saleDate,long number)
* public Warehouse(long number, long price)
* */


    public String menu = "\n" +
            "\n0 - Return to the previous menu" +
            "\n1 - Create" +
            "\n2 - Edit" +
            "\n3 - Delete" +
            "\n4 - Show all\n";


    public BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void memory() throws IOException {
        for (; ; ) {
            System.out.println(menu);
            System.out.print("\nInput item: ");
            int select = Integer.parseInt(reader.readLine());

            if (select == 0) {
                break;
            } else if (select == 1) {
                List<Manufacturer> list = manufacturer.findAll();
                Manufacturer manufacturerr;
                Long size = null;
                if (list.size() == 0) {
                    System.err.println("You can`t create memory without manufacturer!!!" +
                            "\nAdd first manufacturer!");
                    break;

                } else {
                    // public Memory(long size, String manufacturer)

                    System.out.print("\nInput size");
                    size = Long.parseLong(reader.readLine());

                    showAll(list);
                    System.out.print("\nSelect manufacturer\n");


                    int id = Integer.parseInt(reader.readLine());

                    manufacturerr = list.get(id - 1);

                }

                memory.create(new Memory(manufacturerr, size));

            } else if (select == 2) {
                List<Memory> list = memory.showAll();
                List<Manufacturer> manufacturerList = manufacturer.findAll();

                showAll(list);
                System.out.print("\nSelect the what you want to change");

                Memory memory1 = list.get(Integer.parseInt(reader.readLine()) - 1);


                System.out.println(memory1);

                System.out.print("\nInput new size");
                memory1.setSize(Long.parseLong(reader.readLine()));

                showAll(manufacturerList);

                System.out.print("\nSelect new manufacturer");

                memory1.setManufacturer(manufacturerList.get((Integer.parseInt(reader.readLine()) - 1)));

                memory.update(memory1);

            } else if (select == 3) {
                List<Memory> list = memory.showAll();

                showAll(list);
                System.out.print("\nSelect want to delete: ");

                memory.delete(list.get(Integer.parseInt(reader.readLine()) - 1));
            } else if (select == 4) {
                showAll(memory.showAll());
            } else {

                System.err.println("You input wrong number,pleas try again!!!");
            }
        }
    }

    public void manufacturer() throws IOException {

        for (; ; ) {

            System.out.println(menu);
            System.out.print("\nInput item: ");
            int select = Integer.parseInt(reader.readLine());

            System.out.println();

            if (select == 0) {
                break;
            } else if (select == 1) {

                System.out.print("\nInput name");

                String name = reader.readLine();

                manufacturer.create(new Manufacturer(name));

            } else if (select == 2) {
                List<Manufacturer> manufacturerList = manufacturer.findAll();


                showAll(manufacturerList);
                System.out.print("\nSelect the what you want to change");

                Manufacturer manufacturer1 = manufacturerList.get(Integer.parseInt(reader.readLine()) - 1);

                System.out.print("\nInput new name");

                manufacturer1.setName(reader.readLine());

                manufacturer.update(manufacturer1);

            } else if (select == 3) {

                List<Manufacturer> list = manufacturer.findAll();

                showAll(list);
                System.out.print("\nSelect want to delete: ");

                manufacturer.delete(list.get(Integer.parseInt(reader.readLine()) - 1));

            } else if (select == 4) {
                showAll(manufacturer.findAll());
            } else {

                System.err.println("You input wrong number,pleas try again!!!");
            }
        }
    }

    public void notebook() throws IOException {

        for (; ; ) {

            System.out.println(menu);
            System.out.print("\nInput item: ");
            int select = Integer.parseInt(reader.readLine());

            if (select == 0) {
                break;
            } else if (select == 1) {
                List<Manufacturer> manufacturerList = manufacturer.findAll();
                List<Processor> processorList = processor.showAll();
                List<Memory> memoryList = memory.showAll();
                if (manufacturerList.size() == 0
                        && processorList.size() == 0
                        && memoryList.size() == 0) {
                    System.err.println("You can`t create memory without manufacturer,memory,processor!!!" +
                            "\nAdd first manufacturer!");
                    break;
                }

                showAll(manufacturerList);
                System.out.print("\nSelect manufacturer ");
                Manufacturer manufacturer1 = manufacturerList.get(Integer.parseInt(reader.readLine()) - 1);

                System.out.print("\nInput model ");
                String model = reader.readLine();

                System.out.print("\nInput date ");
                String date = reader.readLine();

                showAll(memoryList);
                System.out.print("\nSelect memory ");
                Memory memory1 = memoryList.get(Integer.parseInt(reader.readLine()) - 1);

                showAll(processorList);
                System.out.print("\nSelect processor ");
                Processor processor1 = processorList.get(Integer.parseInt(reader.readLine()) - 1);

                Notebook notebook = new Notebook(manufacturer1, model, date, processor1, memory1);

                notebooksType.create(notebook);

            } else if (select == 2) {
                List<Notebook> notebookList = notebooksType.showAll();
                List<Manufacturer> manufacturerList = manufacturer.findAll();
                List<Processor> processorList = processor.showAll();
                List<Memory> memoryList = memory.showAll();

                showAll(notebookList);
                System.out.print("\nSelect the what you want to change");


                Notebook notebook = notebookList.get(Integer.parseInt(reader.readLine()) - 1);


                showAll(manufacturerList);
                System.out.print("\nSelect new manufacturer ");
                notebook.setManufacturer(manufacturerList.get(Integer.parseInt(reader.readLine()) - 1));

                System.out.print("\nInput new model ");
                notebook.setModel(reader.readLine());

                System.out.print("\nInput new date ");
                notebook.setManufacturerDate(reader.readLine());


                showAll(memoryList);
                System.out.print("\nSelect new memory ");
                notebook.setMemory(memoryList.get(Integer.parseInt(reader.readLine()) - 1));


                showAll(processorList);
                System.out.print("\nSelect new processor ");
                notebook.setProcessor(processorList.get(Integer.parseInt(reader.readLine()) - 1));

                notebooksType.update(notebook);
            } else if (select == 3) {
                List<Notebook> list = notebooksType.showAll();

                showAll(list);

                System.out.print("\nSelect want to delete: ");
                notebooksType.delete(list.get(Integer.parseInt(reader.readLine()) - 1));

            } else if (select == 4) {
                showAll(notebooksType.showAll());
            } else {

                System.err.println("You input wrong number,pleas try again!!!");
            }
        }
    }

    private void processor() throws IOException {

        for (; ; ) {
            System.out.println(menu);
            System.out.print("\nInput item: ");

            int select = Integer.parseInt(reader.readLine());

            if (select == 0) {
                break;
            } else if (select == 1) {
                List<Manufacturer> list = manufacturer.findAll();
                if (list.size() == 0) {
                    System.err.println("You can`t create memory without manufacturer!!!" +
                            "\nAdd first manufacturer!");
                    break;
                }

                System.out.print("\nInput model ");
                String model = reader.readLine();

                System.out.print("\nInput frequency ");
                Long frequency = Long.parseLong(reader.readLine());

                showAll(list);
                System.out.println("\nSelect manufacturer: ");

                Manufacturer manufacturer1 = list.get(Integer.parseInt(reader.readLine()) - 1);

                processor.create(new Processor(manufacturer1, frequency, model));

            } else if (select == 2) {
                List<Processor> list = processor.showAll();
                List<Manufacturer> manufacturerList = manufacturer.findAll();
                showAll(list);
                System.out.print("\nSelect the what you want to change");

                Processor processor1 = list.get(Integer.parseInt(reader.readLine()) - 1);

                System.out.print("\nInput model ");
                processor1.setModel(reader.readLine());

                System.out.print("\nInput frequency ");
                processor1.setFrequency(Long.parseLong(reader.readLine()));

                showAll(list);
                System.out.println("\nSelect manufacturer: ");
                processor1.setManufacturer(manufacturerList.get(Integer.parseInt(reader.readLine()) - 1));

                processor.update(processor1);

            } else if (select == 3) {
                List<Processor> list = processor.showAll();
                System.out.println("Select want to delete: ");

                showAll(list);

                processor.delete(list.get(Integer.parseInt(reader.readLine()) - 1));

            } else if (select == 4) {
                showAll(processor.showAll());
            } else {

                System.err.println("You input wrong number,pleas try again!!!");
            }
        }
    }

    public void sales() throws IOException {
        for (; ; ) {

            System.out.println(menu);

            System.out.print("\nInput item: ");
            int select = Integer.parseInt(reader.readLine());

            if (select == 0) {
                break;
            } else if (select == 1) {

                List<Warehouse> list = warehouse.showAll();

                if (list.size() == 0) {
                    System.err.println("You can`t create sales without warehouse!!!" +
                            "\nAdd first warehouse!");
                    break;

                }


                showAll(list);
                System.out.print("\nSelect warehouse ");

                Warehouse warhouse1 = list.get(Integer.parseInt(reader.readLine()) - 1);

                System.out.print("\nInput date ");
                String date = reader.readLine();

                System.out.print("\nInput numbe ");

                Long number = Long.parseLong(reader.readLine());

                sales.add(new Sales(warhouse1, date, number));

            } else if (select == 2) {
                List<Sales> salesList = sales.showAll();
                List<Warehouse> warehouseList = warehouse.showAll();
                showAll(salesList);
                System.out.println("\nSelect the what you want to change");


                Sales sales1 = salesList.get(Integer.parseInt(reader.readLine()) - 1);

                showAll(warehouseList);
                System.out.print("\nSelect warehouse ");
                sales1.setWarehouse(warehouseList.get(Integer.parseInt(reader.readLine()) - 1));


                System.out.print("\nInput date ");
                sales1.setSaleDate(reader.readLine());

                System.out.print("\nInput numbe ");

                sales1.setNumber(Long.parseLong(reader.readLine()));

                sales.update(sales1);
            } else if (select == 3) {
                List<Sales> list = sales.showAll();
                System.out.println("Select want to delete: ");

                showAll(list);

                sales.delete(list.get(Integer.parseInt(reader.readLine()) - 1));

            } else if (select == 4) {
                showAll(sales.showAll());
            } else {

                System.err.println("You input wrong number,pleas try again!!!");
            }
        }
    }

    public void warhouse() throws IOException {

        for (; ; ) {
            System.out.println(menu);
            System.out.print("\nInput item: ");
            int select = Integer.parseInt(reader.readLine());

            if (select == 0) {
                break;
            } else if (select == 1) {
                List<Notebook> list = notebooksType.showAll();

                if (list.size() == 0) {
                    System.err.println("You can`t create warehouse without notebook!!!" +
                            "\nAdd first notebook!");
                    break;

                }
                System.out.println("\nInput number");

                long number = Long.parseLong(reader.readLine());

                System.out.println("Input price");

                long price = Long.parseLong(reader.readLine());

                System.out.println("Select notebook: ");

                showAll(list);

                Notebook notebook = list.get(Integer.parseInt(reader.readLine()) - 1);

                warehouse.add(new Warehouse(notebook, number, price));

            } else if (select == 2) {
                List<Warehouse> list = warehouse.showAll();

                System.out.println("\nSelect the what you want to change");

                showAll(list);

                Warehouse warehouse1 = list.get(Integer.parseInt(reader.readLine()) - 1);


                System.out.println(warehouse1);


                System.out.println("Input new number");
                warehouse1.setNumber(Long.parseLong(reader.readLine()));

                System.out.println("Input new price");
                warehouse1.setPrice(Long.parseLong(reader.readLine()));


                System.out.println("Select new notebook");

                List<Notebook> notebookList = notebooksType.showAll();

                showAll(notebookList);

                warehouse1.setNotebook(notebookList.get(Integer.parseInt(reader.readLine()) - 1));

                warehouse.update(warehouse1);

            } else if (select == 3) {
                List<Warehouse> list = warehouse.showAll();
                System.out.println("Select want to delete: ");

                showAll(list);

                warehouse.delete(list.get(Integer.parseInt(reader.readLine()) - 1));

            } else if (select == 4) {
                showAll(warehouse.showAll());
            } else {
                System.err.println("You input wrong number,pleas try again!!!");
            }
        }
    }

    public void reports() throws IOException {
/*Добавить в приложение ноутбуков следующие функции:
    Показать все ноутбуки на складе (пользователь указывает размер порции)
	Показать все ноутбуки которых больше указанного количества
	Показать все ноутбуки по указанному имени производителя процессора
	Показать все ноутбуки на складе
	Показать остатки ноутбуков по каждому производителю
	Получить объем продаж ноутбуков по каждому дню

	Add to notebook application the following functions:
See all the laptops in stock (user specifies the size of servings)
Show all laptops which more specified number
Show all laptops with the specified name processor manufacturer
See all the laptops in stock
See the remnants of laptops for each manufacturer
Get Laptop sales for each day
*/
        String reportsMenu = "\n" +
                "\n0 - Return to the previous menu" +
                "\n1 - Show all the notebooks in warehouse" +
                "\n2 - Show all notebooks which more specified number" +
                "\n3 - Show all notebooks with the specified name processor manufacturer" +
                "\n4 - Show all the notebooks in warehouse" +
                "\n5 - Show the remnants of notebooks for each manufacturer" +
                "\n6 - Get notebooks sales for each day\n";

        for (; ; ) {

            System.out.println(reportsMenu);

            int select = Integer.parseInt(reader.readLine());

            if (select == 0) {
                break;
            } else if (select == 1) {
                List<Notebook> notebookList = warehouse.getAllNotebooks();

                System.out.print("\nInput number to show");

                int number = Integer.parseInt(reader.readLine());
                int countre = 0;
                int j = 0;
                for (; ; ) {

                    System.out.print("Number of notebooks: " + notebookList.size() +
                            "\nTo exit press 0" +
                            "\nPress enter to continue: ");

                    String s = reader.readLine();

                    if (s.equals("")) {

                        for (int i = 0; i < number; i++) {
                            j = countre;
                            countre += number;

                            for (; j < countre; j++) {

                                System.out.println(notebookList.get(j));

                                if (countre >= notebookList.size()) {
                                    System.err.println("\nThis is all notebook");
                                    return;
                                }

                            }


                        }

                    } else if (s.equals("0")) {
                        break;
                    }

                }


            } else if (select == 2) {

                System.out.print("Input variable: ");

                int variable = Integer.parseInt(reader.readLine());

                showAll(warehouse.showAllWichMore(variable));

            } else if (select == 3) {


                System.out.print("\nInput name processor manufacturer: ");
                String name = reader.readLine();

                showAll(warehouse.showAllWichManufacturerName(name));

            } else if (select == 4) {

            } else if (select == 5) {

            } else if (select == 6) {

            } else {
                System.err.println("You input wrong number,pleas try again!!!");
            }


        }
    }

    public void showAll(List<?> list) {
        System.out.println();
        if (list.size() == 0) {
            System.err.println("List is empty");

        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + " - " + list.get(i));
            }
            System.out.println();
        }
    }

}
