package commands;

import model.Central;
import model.ClosedStatus;
import model.Person;
import model.Ticket;

public class SetClosed implements Command {

    private Ticket ticket;
    private Person person;

    public SetClosed(Ticket ticket, Person person) {
        this.ticket = ticket;
        this.person = person;
    }

    @Override
    public void execute(Central central) {
        int maxStatusID = 0;
        if (central.getStatuses().size() > 0) {
            int lastIndex = central.getStatuses().size() - 1;
            maxStatusID = central.getStatuses().get(lastIndex).getID();
        }
        ClosedStatus closedStatus = new ClosedStatus(++maxStatusID, this.person);

        central.changeTicketStatus(this.ticket, closedStatus);

    }

}
