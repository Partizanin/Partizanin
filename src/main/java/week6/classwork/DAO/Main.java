package week6.classwork.DAO;

import javax.swing.*;
import java.util.List;
import java.util.Locale;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 08.06.2014
 * Time: 15:29
 * To change this template use File|Setting|File Templates.
 */
public class Main {

    public static void main(String[] args) {

        RegionHibernateDaoImpl rhdi = new RegionHibernateDaoImpl();
        Locale.setDefault(Locale.ENGLISH);


        rhdi.create(new Region("Africa"));
        rhdi.create(new Region("USA"));

        Region irland = new Region("Irland");
        rhdi.create(irland);

        String country = JOptionPane.showInputDialog(null, "Введите страну");

        irland.setName(country);

        rhdi.update(irland);

        List<Region> list = rhdi.findAll();

        for (Region aList : list) {

            System.out.println(aList);

        }
    }
}
