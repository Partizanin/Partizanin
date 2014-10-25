package week9.homework.siteGrabber.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import week9.homework.siteGrabber.domain.SiteTable;
import week9.homework.siteGrabber.service.SiteServiceImpl;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 29.06.2014
 * Time: 17:31
 * To change this template use File|Setting|File Templates.
 */
@Component
public class Console {
    private SiteServiceImpl siteService;

    @Autowired
    public Console(SiteServiceImpl siteService) {
        this.siteService = siteService;

    }

    public Console() {

    }


    public BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @PostConstruct
    public void start() throws IOException {
        for (; ; ) {
            System.out.println("\nSelect action:" +
                    "\n0 - Exit" +
                    "\n1 - Create" +
                    "\n3 - Write content to file");

            Integer selected = Integer.parseInt(reader.readLine());


            if (selected == 1) {
                create();
                System.out.println();
            } else if (selected == 0) {
                System.exit(1);
            } else if (selected == 3) {


                System.out.print("Input url:");

                siteService.writeContentToFile(reader.readLine());

            } else {
                System.err.println("You input wrong number!!!\nPleas try again");
            }
        }
    }

    public void create() throws IOException {
        System.out.print("\nInput site url");

        // String url = reader.readLine();

        SiteTable siteTable = new SiteTable();
        siteTable.setAddress("https://github.com/partizanin");
        siteService.createContent(siteTable);
    }


}
