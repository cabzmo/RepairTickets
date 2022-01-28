package model;

public class ClosedStatus extends Status {

    public ClosedStatus(int id, Person person) {
        super(id, person);
        this.setClosed();
    }

}
