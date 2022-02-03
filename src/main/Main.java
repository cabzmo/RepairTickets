package main;

import java.io.IOException;

import commands.AddApartment;
import commands.AddFloor;
import commands.AddManager;
import commands.AddTenant;
import commands.AddTower;
import commands.OpenTicket;
import commands.RemoveApartment;
import commands.RemoveFloor;
import commands.RemoveManager;
import commands.RemoveTenant;
import commands.RemoveTower;
import data.CentralData;
import model.Central;
import model.Ticket;

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

        // new AddTower("Rayan").execute(central);
        // new AddFloor("5", 1).execute(central);
        // new AddApartment("5b", 1).execute(central);
        // new AddManager("manager", "000", "email").execute(central);
        // new AddTenant("tenant", "001", "email1").execute(central);
        // new RemoveTower(1).execute(central);
        // new RemoveFloor(1).execute(central);
        // new RemoveApartment(1).execute(central);

        // new OpenTicket(central.getApartmentByID(1),
        // central.getTenantByID(1)).execute(central);

        // new RemoveManager(1).execute(central);
        // new RemoveTenant(1).execute(central);

        System.out.println("Towers: \n" + central.getTowers());
        System.out.println("\nFloors: \n" + central.getFloors());
        System.out.println("\nApartments: \n" + central.getApartments());
        System.out.println("\nManagers: \n" + central.getManagers());
        System.out.println("\nTenants: \n" + central.getTenants());

        CentralData.store(central);

    }
}
