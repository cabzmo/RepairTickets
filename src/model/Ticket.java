package model;

import java.util.ArrayList;

public class Ticket {

    private int id;
    private Location location;
    private Person person;
    private Status status;
    private ArrayList<Status> statusHistory = new ArrayList<Status>();

    public Ticket(int id, Location location) {
        this.id = id;
        this.location = location;
    }

    public int getID() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
        statusHistory.add(status);
    }

    public ArrayList<Status> getStatusHistory() {
        return this.statusHistory;
    }

    @Override
    public String toString() {
        return "Ticket: " + this.getID() + "; " + this.getLocation().getClass().getSimpleName() + ": "
                + this.location.getName() + "; Status: " + this.getStatus();
    }

}