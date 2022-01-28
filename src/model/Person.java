package model;

import java.util.ArrayList;

public class Person {

    private int id;
    private String name;
    private String phone;
    private String email;
    private String userType;
    private ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    public Person(int id, String name, String phone, String email, String userType) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.userType = userType;
    }

    public int getID() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return this.userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public ArrayList<Ticket> getTickets() {
        return this.tickets;
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

    @Override
    public String toString() {
        // return super.toString();
        return "Person: " + this.getID() + "\nName: " + this.getName() + "\nPhone: "
                + this.getPhone() + "\nEmail: " + this.getEmail() + "\nType: " + this.getUserType() + "\nTickets: "
                + this.getTickets();
    }

}
