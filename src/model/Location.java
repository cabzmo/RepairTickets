package model;

import java.util.ArrayList;

public class Location {

    private int id;
    private String name;
    private ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    public Location(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Ticket> getTickets() {
        return this.tickets;
    }

    public Ticket getTicketByID(int ticketID) {
        for (Ticket ticket : tickets) {
            if (ticket.getID() == ticketID) {
                return ticket;
            }
        }
        return null;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public void removeTicket(Ticket searchTicket) {

        for (Ticket ticket : tickets) {
            if (ticket == searchTicket) {
                this.tickets.remove(ticket);
                break;
            }
        }
    }

}
