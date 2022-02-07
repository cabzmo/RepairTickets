package commands;

import java.util.ArrayList;

import main.CentralException;
import model.Apartment;
import model.Central;
import model.Floor;

public class AddApartment implements Command {

    private String name;
    private int floorID;

    public AddApartment(String name, int floorID) {
        this.name = name;
        this.floorID = floorID;
    }

    @Override
    public void execute(Central central) throws CentralException {
        int maxID = 0;
        if (central.getLocations().size() > 0) {
            int lastIndex = central.getLocations().size() - 1;
            maxID = central.getLocations().get(lastIndex).getID();
        }

        for (Apartment apartment : central.getApartments()) {
            if (apartment.getName().equals(this.name)) {
                throw new CentralException(this.name + " is already the name of a apartment");
            }
        }

        ArrayList<Integer> floorIDs = new ArrayList<Integer>();

        for (Floor floor : central.getFloors()) {
            floorIDs.add(floor.getID());
        }

        if (!floorIDs.contains(this.floorID)) {
            throw new CentralException("Unable to find floor id " + this.floorID);
        }

        Apartment apartment = new Apartment(++maxID, name, floorID);
        central.addApartment(apartment);

    }

}
