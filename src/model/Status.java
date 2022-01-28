package model;

public class Status {

    private int id;
    private String status;
    private Person person;

    public Status(int id, Person person) {
        this.id = id;
        this.status = "Open";
        this.person = person;
    }

    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
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

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return this.getStatus();
    }

}
