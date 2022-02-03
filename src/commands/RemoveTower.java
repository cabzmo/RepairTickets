package commands;

import main.CentralException;
import model.Central;
import model.Tower;

public class RemoveTower implements Command {

    private int towerID;

    public RemoveTower(int towerID) {
        this.towerID = towerID;
    }

    @Override
    public void execute(Central central) throws CentralException {
        boolean flag = false;

        // need to check no floors are connected to this tower before deleting

        if (central.canCleanTower(central.getTowerByID(this.towerID))) {
            for (Tower tower : central.getTowers()) {
                if (tower.getID() == this.towerID) {
                    central.removeTower(tower);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                throw new CentralException("No tower with ID number " + this.towerID);
            }
        } else {
            throw new CentralException("Tower with ID number " + this.towerID + " has dependencies");
        }
    }

}
