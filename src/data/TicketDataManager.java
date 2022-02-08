package data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import main.CentralException;
import model.Central;
import model.OpenStatus;
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
                    Ticket ticket = new Ticket(id, location, status);
                    System.out.println("\nproperties[0]: \t" + properties[0]);
                    System.out.println("\nproperties[1]: \t" + properties[1]);
                    System.out.println("\nproperties[2]: \t" + properties[2]);
                    String numWithCommas = properties[2].substring(1, properties[2].length() - 1);
                    System.out.println("\nNumbers with commas: \t" + numWithCommas);
                    String[] statusHistory = numWithCommas.split(",", -1);
                    int count = 0;

                    for (String stringStatusID : statusHistory) {
                        System.out.println("\nstatusHistory[" + count + "]: \t" + stringStatusID);
                        int statusID = Integer.parseInt(stringStatusID);
                        String statusType = central.getStatusByID(statusID).getStatusName();
                        if (statusType.equals("Open")) {
                            OpenStatus status = new OpenStatus(1, central.getPersonByID(1));

                        } else {
                            status = new OpenStatus(1, central.getPersonByID(1));
                        }
                        count++;
                    }
                    // System.out.println("\nstatusHistory[0]: \t" + statusHistory[0]);
                    // System.out.println("\nstatusHistory[1]: \t" + statusHistory[1]);
                    // System.out.println("\nstatusHistory[2]: \t" + statusHistory[2]);
                    // System.out.println("\nstatusHistory[3]: \t" + statusHistory[3]);

                } catch (NumberFormatException ex) {
                    throw new CentralException("Unable to parse status id " + properties[0] + " on line " + line_idx
                            + "\nError: " + ex);
                }
                line_idx++;
            }
        }
    }

    @Override
    public void storeData(Central central) throws IOException {
        // try (PrintWriter out = new PrintWriter(new FileWriter(RESOURCE))) {
        // for (OpenStatus status : central.getOpenStatuses()) {
        // out.print(status.getID() + SEPARATOR);
        // out.print(status.getPerson().getID() + SEPARATOR);
        // out.println();
        // }
        // }
    }

}
