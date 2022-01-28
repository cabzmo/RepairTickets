package main;

import commands.OpenTicket;
import commands.SetInProgress;
import model.*;

public class Main {

    public static void main(String[] args) {

        Central central = new Central();

        Tower rayan = new Tower(1, "Rayan");
        Floor rayanFive = new Floor(2, "5", rayan);
        Apartment rayanFiveB = new Apartment(3, "5b", rayanFive);

        Manager manager = new Manager(4, "manager", "000", "email");

        central.addLocation(rayan);
        central.addLocation(rayanFive);
        central.addLocation(rayanFiveB);
        central.addPerson(manager);

        System.out.println(central.getPersonByID(manager.getID()));

        new OpenTicket(rayanFiveB, manager).execute(central);

        System.out.println();
        System.out.println(central.getPersonByID(manager.getID()));

        new SetInProgress(central.getTicketByID(manager.getTickets().get(0).getID())).execute(central);

        System.out.println();
        System.out.println(central.getPersonByID(manager.getID()));

        System.out.println();
        System.out.println(central.getTicketByID(manager.getTickets().get(0).getID()).getStatusHistory());
    }
}
