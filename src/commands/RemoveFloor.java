package commands;

import main.CentralException;
import model.Central;
import model.Floor;

public class RemoveFloor implements Command {

    private int floorID;

    public RemoveFloor(int floorID) {
        this.floorID = floorID;
    }

    @Override
    public void execute(Central central) throws CentralException {
        boolean flag = false;

        // need to check no apartments are connected to this floor before deleting

        for (Floor floor : central.getFloors()) {
            if (floor.getID() == this.floorID) {
                central.removeFloor(floor);
                flag = true;
                break;
            }
        }

        if (!flag) {
            throw new CentralException("No floor with ID number " + this.floorID);
        }
    }

}
