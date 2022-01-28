package commands;

import model.Central;
import model.Location;
import model.OpenStatus;
import model.Person;
import model.Ticket;

public class OpenTicket implements Command {

    private Location location;
    private Person person;

    public OpenTicket(Location location, Person person) {
        this.location = location;
        this.person = person;
    }

    @Override
    public void execute(Central central) {
        int maxStatusID = 0;
        if (central.getStatuses().size() > 0) {
            int lastIndex = central.getStatuses().size() - 1;
            maxStatusID = central.getStatuses().get(lastIndex).getID();
        }
        OpenStatus status = new OpenStatus(maxStatusID, this.person);

        int maxTicketID = 0;
        if (central.getTickets().size() > 0) {
            int lastIndex = central.getTickets().size() - 1;
            maxTicketID = central.getTickets().get(lastIndex).getID();
        }
        Ticket ticket = new Ticket(++maxTicketID, location);

        ticket.setStatus(status);
        person.addTicket(ticket);

        central.addTicket(ticket);
    }

}
