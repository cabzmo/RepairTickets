package model;

public class Ticket {

    private int id;
    private Location location;
    private String status;

    public Ticket(int id, Location location) {
        this.id = id;
        this.location = location;
    }

    public Ticket(int id, Location location, String status) {
        this.id = id;
        this.location = location;
        this.status = status;
    }

    public int getId() {
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

}