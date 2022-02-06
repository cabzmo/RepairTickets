package data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import main.CentralException;
import model.Central;
import model.Floor;
import model.OpenStatus;

public class OpenStatusDataManager implements DataManager {

    private final String RESOURCE = "./resources/data/statusOpen.txt";

    @Override
    public void loadData(Central central) throws IOException, CentralException {
        try (Scanner sc = new Scanner(new File(RESOURCE))) {
            int line_idx = 1;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] properties = line.split(SEPARATOR, -1);
                try {
                    int id = Integer.parseInt(properties[0]);
                    int personID = Integer.parseInt(properties[0]);
                    OpenStatus status = new OpenStatus(id, central.getManagerByID(personID));
                    central.addStatus(status);
                } catch (NumberFormatException ex) {
                    throw new CentralException("Unable to parse floor id " + properties[0] + " on line " + line_idx
                            + "\nError: " + ex);
                }
                line_idx++;
            }
        }
    }

    @Override
    public void storeData(Central central) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(RESOURCE))) {
            for (Floor floor : central.getFloors()) {
                out.print(floor.getID() + SEPARATOR);
                out.print(floor.getName() + SEPARATOR);
                out.print(floor.getTowerID() + SEPARATOR);
                out.println();
            }
        }
    }

}
