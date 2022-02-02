package data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import main.CentralException;
import model.Central;
import model.Floor;

public class FloorDataManager implements DataManager {

    private final String RESOURCE = "./resources/data/floors.txt";

    @Override
    public void loadData(Central central) throws IOException, CentralException {
        try (Scanner sc = new Scanner(new File(RESOURCE))) {
            int line_idx = 1;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] properties = line.split(SEPARATOR, -1);
                try {
                    int id = Integer.parseInt(properties[0]);
                    String name = properties[1];
                    int towerID = Integer.parseInt(properties[2]);
                    Floor floor = new Floor(id, name, towerID);
                    central.addFloor(floor);
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
