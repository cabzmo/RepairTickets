package data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import main.CentralException;
import model.Apartment;
import model.Central;

public class ApartmentDataManager implements DataManager {

    private final String RESOURCE = "./resources/data/apartments.txt";

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
                    int floorID = Integer.parseInt(properties[2]);
                    Apartment apartment = new Apartment(id, name, floorID);
                    central.addApartment(apartment);
                } catch (NumberFormatException ex) {
                    throw new CentralException("Unable to parse tower id " + properties[0] + " on line " + line_idx
                            + "\nError: " + ex);
                }
                line_idx++;
            }
        }
    }

    @Override
    public void storeData(Central central) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(RESOURCE))) {
            for (Apartment apartment : central.getApartments()) {
                out.print(apartment.getID() + SEPARATOR);
                out.print(apartment.getName() + SEPARATOR);
                out.print(apartment.getFloorID() + SEPARATOR);
                out.println();
            }
        }
    }

}