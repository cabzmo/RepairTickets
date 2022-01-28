package model;

public class InProgressStatus extends Status {

    public InProgressStatus(int id, Person person) {
        super(id, person);
        this.setInProgress();
    }

}
