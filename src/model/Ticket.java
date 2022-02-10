package model;

import java.util.ArrayList;

public class Ticket {

    private int id;
    private Location location;
    private Status status;
    private ArrayList<Status> statusHistory = new ArrayList<Status>();

    public Ticket(int id, Location location, Status status) {
        this.id = id;
        this.location = location;
        this.status = status;
        this.statusHistory.add(status);
    }

    public Ticket(int id, Location location, ArrayList<Status> statusHistory) {
        this.id = id;
        this.location = location;
        location.addTicket(this);
        this.statusHistory = statusHistory;
        this.status = this.statusHistory.get(statusHistory.size() - 1);
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

    public ArrayList<Person> getPeople() {
        ArrayList<Person> people = new ArrayList<Person>();
        for (Status status : this.statusHistory) {
            if (!people.contains(status.getPerson())) {
                people.add(status.getPerson());
            }
        }
        return people;
    }

    @Override
    public String toString() {
        return "Ticket: " + this.getID() + "; " + this.getLocation().getClass().getSimpleName() + ": "
                + this.location.getName() + "; Status: " + this.getStatus().getStatusName() + "; Set by: "
                + this.status.getPerson().getName() + "; Opened by: "
                + this.statusHistory.get(0).getPerson().getName();
    }

}