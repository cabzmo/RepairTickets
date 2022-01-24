package main;

import model.Apartment;
import model.Floor;
import model.Tower;

public class Main {

    public static void main(String[] args) {
        Tower rayan = new Tower(1, "Rayan");
        Floor rayanFive = new Floor(2, "5", rayan);
        Apartment rayanFiveB = new Apartment(3, "5b", rayanFive);
        System.out.println(rayan);
        System.out.println();
        System.out.println(rayanFive);
        System.out.println();
        System.out.println(rayanFiveB);
    }
}
