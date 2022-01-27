package model;

public class Ticket {

    private int id;
    private Location location;
    private Person person;
    private String status;

    public Ticket(int id, Location location, Person person) {
        this.id = id;
        this.location = location;
        this.person = person;
    }

    public Ticket(int id, Location location, String status) {
        this.id = id;
        this.location = location;
        this.status = status;
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

    public String getStatus() {
        return this.status;
    }

    public void setOpen() {
        this.status = "Open";
    }

    public void setInProgress() {
        this.status = "In Progress";
    }

    public void setClosed() {
        this.status = "Closed";
    }

    @Override
    public String toString() {
        return "Ticket: " + this.getID() + " " + this.getLocation().getClass().getSimpleName() + ": "
                + this.location.getName();
    }

}