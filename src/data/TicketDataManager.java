package data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import main.CentralException;
import model.Central;
import model.Status;
import model.Ticket;

public class TicketDataManager implements DataManager {

    private final String RESOURCE = "./resources/data/tickets.txt";

    @Override
    public void loadData(Central central) throws IOException, CentralException {
        try (Scanner sc = new Scanner(new File(RESOURCE))) {
            int line_idx = 1;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] properties = line.split(SEPARATOR, -1);
                try {
                    int id = Integer.parseInt(properties[0]);
                    int locationID = Integer.parseInt(properties[1]);

                    String numWithCommas = properties[2].substring(1, properties[2].length() - 2);
                    String[] stringStatusHistory = numWithCommas.split(",", -1);

                    ArrayList<Status> statusHistory = new ArrayList<Status>();
                    for (String stringStatusID : stringStatusHistory) {
                        int statusID = Integer.parseInt(stringStatusID);
                        statusHistory.add(central.getStatusByID(statusID));
                    }
                    Ticket ticket = new Ticket(id, central.getLocationByID(locationID), statusHistory);
                    // ticket.setStatus(statusHistory.get(statusHistory.size() - 1));
                    central.addTicket(ticket);

                } catch (NumberFormatException ex) {
                    throw new CentralException("Unable to parse ticket id " + properties[0] + " on line " + line_idx
                            + "\nError: " + ex);
                }
                line_idx++;
            }
        }
    }

    @Override
    public void storeData(Central central) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(RESOURCE))) {
            for (Ticket ticket : central.getTickets()) {
                out.print(ticket.getID() + SEPARATOR);
                out.print(ticket.getLocation().getID() + SEPARATOR);
                out.print("[");
                for (Status status : ticket.getStatusHistory()) {
                    out.print(status.getID() + ",");
                }
                out.print("]" + SEPARATOR);

                // ArrayList<Integer> statusIDs = new ArrayList<Integer>();
                // for (Status status : ticket.getStatusHistory()) {
                // statusIDs.add(status.getID());
                // }
                // out.print(statusIDs + SEPARATOR);
                out.println();
            }
        }
    }

}
