package commands;

import model.Central;
import model.InProgressStatus;
import model.Person;
import model.Ticket;

public class SetInProgress implements Command {

    private Ticket ticket;
    private Person person;

    public SetInProgress(Ticket ticket, Person person) {
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

        InProgressStatus inProgressStatus = new InProgressStatus(++maxStatusID, this.person);

        central.addInProgressStatusToTicket(this.ticket, inProgressStatus);

        // central.addStatus(inProgressStatus);

        // ticket.setStatus(inProgressStatus);

    }

}
