package main;

import model.Apartment;
import model.Floor;
import model.Manager;
import model.Tenant;
import model.Ticket;
import model.Tower;

public class Main {

    public static void main(String[] args) {
        Tower rayan = new Tower(1, "Rayan");
        Floor rayanFive = new Floor(2, "5", rayan);
        Apartment rayanFiveB = new Apartment(3, "5b", rayanFive);
        // System.out.println(rayan);
        // System.out.println();
        // System.out.println(rayanFive);
        // System.out.println();
        // System.out.println(rayanFiveB);

        Manager manager = new Manager(4, "manager", "000", "email");
        Ticket ticket5 = new Ticket(5, rayanFiveB);
        Ticket ticket6 = new Ticket(6, rayanFiveB);

        // for (Ticket ticket : manager.getTickets()) {
        // System.out.println(ticket);
        // System.out.println();
        // }
        System.out.println(manager);
        System.out.println();

        manager.addTicket(ticket5);
        manager.addTicket(ticket6);

        // for (Ticket ticket : manager.getTickets()) {
        // System.out.println(ticket);
        // System.out.println();
        // }
        System.out.println(manager);
        System.out.println();

        manager.removeTicket(ticket5);

        // for (Ticket ticket : manager.getTickets()) {
        // System.out.println(ticket);
        // System.out.println();
        // }
        System.out.println(manager);
        System.out.println();
    }
}
