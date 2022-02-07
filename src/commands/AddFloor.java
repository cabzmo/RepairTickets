package commands;

import java.util.ArrayList;

import main.CentralException;
import model.Central;
import model.Floor;
import model.Tower;

public class AddFloor implements Command {

    private String name;
    private int towerID;

    public AddFloor(String name, int towerID) {
        this.name = name;
        this.towerID = towerID;
    }

    @Override
    public void execute(Central central) throws CentralException {
        int maxID = 0;
        if (central.getLocations().size() > 0) {
            int lastIndex = central.getLocations().size() - 1;
            maxID = central.getLocations().get(lastIndex).getID();
        }

        for (Floor floor : central.getFloors()) {
            if (floor.getName().equals(this.name)) {
                throw new CentralException(this.name + " is already the name of a floor");
            }
        }

        ArrayList<Integer> towerIDs = new ArrayList<Integer>();

        for (Tower tower : central.getTowers()) {
            towerIDs.add(tower.getID());
        }

        if (!towerIDs.contains(this.towerID)) {
            throw new CentralException("Unable to find tower id " + this.towerID);
        }

        Floor floor = new Floor(++maxID, name, towerID);
        central.addFloor(floor);

    }

}
