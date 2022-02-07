package commands;

import main.CentralException;
import model.Central;
import model.Tower;

public class AddTower implements Command {

    private String name;

    public AddTower(String name) {
        this.name = name;
    }

    @Override
    public void execute(Central central) throws CentralException {
        int maxID = 0;
        if (central.getLocations().size() > 0) {
            int lastIndex = central.getLocations().size() - 1;
            maxID = central.getLocations().get(lastIndex).getID();
        }

        for (Tower tower : central.getTowers()) {
            if (tower.getName().equals(this.name)) {
                throw new CentralException(this.name + " is already the name of a tower");
            }
        }

        Tower tower = new Tower(++maxID, this.name);
        central.addTower(tower);

    }

}
