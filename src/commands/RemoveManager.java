package commands;

import main.CentralException;
import model.Central;
import model.Manager;

public class RemoveManager implements Command {

    private int managerID;

    public RemoveManager(int managerID) {
        this.managerID = managerID;
    }

    @Override
    public void execute(Central central) throws CentralException {
        boolean flag = false;

        // need to check no apartments are connected to this floor before deleting

        for (Manager manager : central.getManagers()) {
            if (manager.getID() == this.managerID) {
                central.removeManager(manager);
                flag = true;
                break;
            }
        }

        if (!flag) {
            throw new CentralException("No manager with ID number " + this.managerID);
        }
    }

}
