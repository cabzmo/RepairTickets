package commands;

import model.Central;
import model.InProgressStatus;
import model.Ticket;

public class SetInProgress implements Command {

    private Ticket ticket;

    public SetInProgress(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void execute(Central central) {
        int maxStatusID = 0;
        if (central.getStatuses().size() > 0) {
            int lastIndex = central.getStatuses().size() - 1;
            maxStatusID = central.getStatuses().get(lastIndex).getID();
        }
        InProgressStatus inProgressStatus = new InProgressStatus(++maxStatusID, ticket.getPerson());
        central.addStatus(inProgressStatus);

        // System.out.println();
        // System.out.println("Ticket ---- " + ticket);
        ticket.setStatus(inProgressStatus);
        // System.out.println();
        // System.out.println("Ticket ---- " + ticket);

    }

}
