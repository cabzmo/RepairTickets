package data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import main.CentralException;
import model.Central;
import model.Tenant;

public class TenantDataManager implements DataManager {

    private final String RESOURCE = "./resources/data/tenants.txt";

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
                    String phone = properties[2];
                    String email = properties[3];
                    Tenant tenant = new Tenant(id, name, phone, email);
                    central.addTenant(tenant);
                } catch (NumberFormatException ex) {
                    throw new CentralException("Unable to parse floor id " + properties[0] + " on line " + line_idx
                            + "\nError: " + ex);
                }
                line_idx++;
            }
        }
    }

    @Override
    public void storeData(Central central) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(RESOURCE))) {
            for (Tenant tenant : central.getTenants()) {
                out.print(tenant.getID() + SEPARATOR);
                out.print(tenant.getName() + SEPARATOR);
                out.print(tenant.getPhone() + SEPARATOR);
                out.print(tenant.getEmail() + SEPARATOR);
                out.println();
            }
        }
    }

}
