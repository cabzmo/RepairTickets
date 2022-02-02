package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.CentralException;
import model.Central;

public class CentralData {

    private static final List<DataManager> dataManagers = new ArrayList<>();

    static {
        dataManagers.add(new TowerDataManager());
        dataManagers.add(new FloorDataManager());
        dataManagers.add(new ApartmentDataManager());
        dataManagers.add(new ManagerDataManager());
        dataManagers.add(new TenantDataManager());
    }

    public static Central load() throws CentralException, IOException {

        Central central = new Central();
        for (DataManager dm : dataManagers) {
            dm.loadData(central);
        }
        return central;
    }

    public static void store(Central central) throws IOException {

        for (DataManager dm : dataManagers) {
            dm.storeData(central);
        }
    }

}
