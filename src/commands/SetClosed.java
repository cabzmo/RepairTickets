package commands;

import model.Central;
import model.ClosedStatus;
import model.InProgressStatus;
import model.Ticket;

public class SetClosed implements Command {

    private Ticket ticket;

    public SetClosed(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void execute(Central central) {
        int maxStatusID = 0;
        if (central.getStatuses().size() > 0) {
            int lastIndex = central.getStatuses().size() - 1;
            maxStatusID = central.getStatuses().get(lastIndex).getID();
        }
        ClosedStatus closedStatus = new ClosedStatus(++maxStatusID, ticket.getPerson());
        // InProgressStatus inProgressStatus = new InProgressStatus(++maxStatusID,
        // ticket.getPerson());
        central.addStatus(closedStatus);

        // System.out.println();
        // System.out.println("Ticket ---- " + ticket);
        ticket.setStatus(closedStatus);
        // System.out.println();
        // System.out.println("Ticket ---- " + ticket);

    }

}
