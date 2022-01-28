package model;

public class OpenStatus extends Status {

    public OpenStatus(int id, Person person) {
        super(id, person);
        this.setOpen();
    }

}
