package main;

import java.io.IOException;

import commands.AddApartment;
import commands.AddFloor;
import commands.AddManager;
import commands.AddTenant;
import commands.AddTower;
import data.CentralData;
import model.Central;

public class Main {

    public static void main(String[] args) throws CentralException, IOException {

        Central central = CentralData.load();

        // Tower rayan = new Tower(1, "Rayan");
        // Floor rayanFive = new Floor(2, "5", 1);
        // Apartment rayanFiveB = new Apartment(3, "5b", 2);

        // Manager manager = new Manager(4, "manager", "000", "email");
        // Tenant tenant = new Tenant(5, "tenant", "001", "email1");

        // central.addTower(rayan);
        // central.addFloor(rayanFive);
        // central.addApartment(rayanFiveB);
        // central.addManager(manager);
        // central.addTenant(tenant);

        // System.out.println(central.getTowers());

        System.out.println("Towers: \n" + central.getTowers());
        System.out.println("\nFloors: \n" + central.getFloors());
        System.out.println("\nApartments: \n" + central.getApartments());
        System.out.println("\nManagers: \n" + central.getManagers());
        System.out.println("\nTenants: \n" + central.getTenants());

        // new AddTower("Mina").execute(central);
        // new AddFloor("6", 1).execute(central);
        // new AddApartment("6b", 2).execute(central);
        new AddTenant("tenant", "002", "email1").execute(central);

        CentralData.store(central);

    }
}
