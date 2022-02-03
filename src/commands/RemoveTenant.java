package commands;

import main.CentralException;
import model.Central;
import model.Tenant;

public class RemoveTenant implements Command {

    private int tenantID;

    public RemoveTenant(int tenantID) {
        this.tenantID = tenantID;
    }

    @Override
    public void execute(Central central) throws CentralException {
        boolean flag = false;

        if (central.canCleanPerson(central.getTenantByID(this.tenantID))) {
            for (Tenant tenant : central.getTenants()) {
                if (tenant.getID() == this.tenantID) {
                    central.removeTenant(tenant);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                throw new CentralException("No tenant with ID number " + this.tenantID);
            }
        } else {
            throw new CentralException("Tenant with ID number " + this.tenantID + " has dependencies");
        }
    }

}
