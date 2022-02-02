package commands;

import main.CentralException;
import model.Apartment;
import model.Central;

public class RemoveApartment implements Command {

    private int apartmentID;

    public RemoveApartment(int apartmentID) {
        this.apartmentID = apartmentID;
    }

    @Override
    public void execute(Central central) throws CentralException {
        boolean flag = false;

        // need to check no apartments are connected to this floor before deleting

        for (Apartment apartment : central.getApartments()) {
            if (apartment.getID() == this.apartmentID) {
                central.removeApartment(apartment);
                flag = true;
                break;
            }
        }

        if (!flag) {
            throw new CentralException("No apartment with ID number " + this.apartmentID);
        }
    }

}
