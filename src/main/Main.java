package main;

import java.io.IOException;

import data.CentralData;
import model.Apartment;
import model.Central;
import model.Floor;
import model.Manager;
import model.Tenant;
import model.Tower;

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

        System.out.println("Towers: \t" + central.getTowers());
        System.out.println("\nFloors: \t" + central.getFloors());
        System.out.println("\nApartments: \t" + central.getApartments());
        System.out.println("\nManagers: \t" + central.getManagers());
        System.out.println("\nTenants: \t" + central.getTenants());

        CentralData.store(central);

    }
}
