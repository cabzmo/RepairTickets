package data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import main.CentralException;
import model.Central;
import model.Manager;

public class ManagerDataManager implements DataManager {

    private final String RESOURCE = "./resources/data/managers.txt";

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
                    String phone = properties[2];
                    String email = properties[3];
                    Manager manager = new Manager(id, name, phone, email);
                    central.addManager(manager);
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
            for (Manager manager : central.getManagers()) {
                out.print(manager.getID() + SEPARATOR);
                out.print(manager.getName() + SEPARATOR);
                out.print(manager.getPhone() + SEPARATOR);
                out.print(manager.getEmail() + SEPARATOR);
                out.println();
            }
        }
    }

}
